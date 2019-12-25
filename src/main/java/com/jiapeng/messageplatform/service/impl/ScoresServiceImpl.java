package com.jiapeng.messageplatform.service.impl;

/**
 * Created by Administrator on 2019/9/4.
 */

import com.google.gson.JsonObject;
import com.jiapeng.messageplatform.dao.ScoresMapper;
import com.jiapeng.messageplatform.dao.StudentMapper;
import com.jiapeng.messageplatform.entity.ScoreEntity;
import com.jiapeng.messageplatform.entity.Student;
import com.jiapeng.messageplatform.model.ImportErrorResult;
import com.jiapeng.messageplatform.service.ScoresService;
import com.jiapeng.messageplatform.utils.Excel;
import com.jiapeng.messageplatform.utils.PageResult;
import com.jiapeng.messageplatform.utils.ReturnT;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by LLJ on 2019/7/8.
 */
@Service
public class ScoresServiceImpl implements ScoresService {

    @Autowired
    private ScoresMapper scoresMapper;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页获取学生成绩表
     * @param page
     * @param limit
     * @param clCodeList
     * @param stuNo
     * @param term
     * @return
     */
    @Override
    public PageResult list(Integer page, Integer limit,
                           List<String> clCodeList, String stuNo, String term) {
        List<Map<String, Object>> map =  scoresMapper.list(clCodeList,stuNo,term,limit,page);
        int count = scoresMapper.count(clCodeList,stuNo,term);
        PageResult result = new PageResult(count,map);
        return result;
    }

    /**
     * 根据班级代码   学生编号  学期 选择性修改学生成绩
     * @param scoreEntity
     */
    @Override
    public void update(ScoreEntity scoreEntity){
        scoresMapper.updateByPrimaryKeySelective(scoreEntity);
    }

    /**
     * 根据id更新记录
     * @param scoreEntity
     */
    @Override
    public void updateById(ScoreEntity scoreEntity){
        scoresMapper.updateByPrimaryKeySelectiveById(scoreEntity);
    }


    /**
     * 添加学生成绩
     * @param scoreEntity
     */
    @Override
    public void insert(ScoreEntity scoreEntity){
        scoreEntity.setId(UUID.randomUUID().toString());
        scoresMapper.insertSelective(scoreEntity);
    }

    @Override
    public void delete(String id){
        scoresMapper.deleteByPrimaryKey(id);
    }









    /********************************************成绩导入********************************/

    @Override
    public void importStuScore(String fileName, String sheetName) {
        ImportStuScore importT = new ImportStuScore(fileName, sheetName);
        //importT.start();
        importT.run();
    }


    public static int total = 0;
    public static int totalSuccess = 0;
    public static int totalFail = 0;
    public static boolean isImporting = false;
    public static boolean isImportEnd = false;
    public static List<Object> errList = new ArrayList<>();
    public static String errMessage = null;

    class ImportStuScore extends Thread {
        private String fileName;
        private String sheetName;


        public ImportStuScore(String fileName, String sheetName) {
            this.fileName = fileName;
            this.sheetName = sheetName;
        }

        @Override
        public void run() {
            try {
                List<JsonObject> list = new Excel().getData(fileName, sheetName);
                checkFieldExist(list.get(0));

                ScoresServiceImpl.total = list.size();
                ScoresServiceImpl.totalSuccess = 0;
                ScoresServiceImpl.totalFail = 0;
                ScoresServiceImpl.isImporting = true;
                ScoresServiceImpl.isImportEnd = false;
                ScoresServiceImpl.errList.clear();
                ScoresServiceImpl.errMessage = null;

                list.forEach(jsonObject -> {



                    ScoreEntity scoreEntity = new ScoreEntity();
                    scoreEntity.setId(UUID.randomUUID().toString());

                    scoreEntity.setChinese(jsonObject.get("语文").getAsString().trim());
                    scoreEntity.setMaths(jsonObject.get("数学").getAsString().trim());
                    scoreEntity.setEnglish(jsonObject.get("英语").getAsString().trim());
                    scoreEntity.setPolitics(jsonObject.get("政治").getAsString().trim());
                    scoreEntity.setHistory(jsonObject.get("历史").getAsString().trim());
                    scoreEntity.setGeography(jsonObject.get("地理").getAsString().trim());
                    scoreEntity.setPhysics(jsonObject.get("物理").getAsString().trim());
                    scoreEntity.setChemistry(jsonObject.get("化学").getAsString().trim());
                    scoreEntity.setBiology(jsonObject.get("生物").getAsString().trim());
                    scoreEntity.setTerm(jsonObject.get("学期").getAsString().trim());
                    scoreEntity.setCreateDate(new Date());

                    Student student = studentMapper.getStuId(jsonObject.get("班级代码").getAsString().trim(),jsonObject.get("学生编号").getAsString().trim());

                    if(student==null){
                        ScoresServiceImpl.totalFail++;
                        errList.add(new ImportErrorResult(jsonObject.get("班级代码").getAsString().trim(), jsonObject.get("学生编号").getAsString().trim(), "没有该班级或者没有该学生！"));
                        return;
                    }
                    scoreEntity.setStuId(student.getStuId());


                    try {
                        checkFieldConetentEmpty(jsonObject);
                        ScoreEntity dbStuScore = scoresMapper.selectByPrimaryKey(scoreEntity.getStuId(),scoreEntity.getTerm());
                        //  List<ClassTeacher> classList = teacher.getClassTeacherList();
                        //增加
                        if (dbStuScore == null) {
                            scoresMapper.insertSelective(scoreEntity);
                            ScoresServiceImpl.totalSuccess++;
                        }
                        //修改
                        else {
                            scoreEntity.setUpdateDate(new Date());
                            scoresMapper.updateByPrimaryKeySelective(scoreEntity);
                            ScoresServiceImpl.totalSuccess++;
                        }

                    } catch (Exception e) {
                        ScoresServiceImpl.totalFail++;
                        errList.add(new ImportErrorResult(jsonObject.get("班级代码").getAsString().trim(), jsonObject.get("学生编号").getAsString().trim(), e.getMessage()));
                    }
                });
            } catch (Exception ex) {
                ScoresServiceImpl.errMessage = ex.getMessage();
            } finally {
                ScoresServiceImpl.isImporting = false;
                ScoresServiceImpl.isImportEnd = true;
            }
        }

        public void checkFieldExist(JsonObject jsonObject) throws Exception {
            if (null == jsonObject.get("班级代码"))
                throw new Exception("“班级代码”字段不存在");
            if (null == jsonObject.get("学生编号"))
                throw new Exception("“学生编号”字段不存在");
            if (null == jsonObject.get("语文"))
                throw new Exception("“语文”字段不存在");
            if (null == jsonObject.get("数学"))
                throw new Exception("“数学”字段不存在");
            if (null == jsonObject.get("英语"))
                throw new Exception("“英语”字段不存在");
            if (null == jsonObject.get("政治"))
                throw new Exception("“政治”字段不存在");
            if (null == jsonObject.get("历史"))
                throw new Exception("“历史”字段不存在");
            if (null == jsonObject.get("地理"))
                throw new Exception("“地理”字段不存在");
            if (null == jsonObject.get("物理"))
                throw new Exception("“物理”字段不存在");
            if (null == jsonObject.get("化学"))
                throw new Exception("“化学”字段不存在");
            if (null == jsonObject.get("生物"))
                throw new Exception("“生物”字段不存在");
            if (null == jsonObject.get("学期"))
                throw new Exception("“学期”字段不存在");
        }

        public JsonObject checkFieldConetentEmpty(JsonObject jsonObject) throws Exception {
            if (jsonObject.get("班级代码").getAsString().trim().equals(""))
                throw new Exception("“班级代码”不能为空");
            if (jsonObject.get("学生编号").getAsString().trim().equals(""))
                throw new Exception("“学生编号”不能为空");
            return jsonObject;
        }
    }



    private String errXlsFileName = "import_score_.xls";
    @Value("${system.config.downpath}")
    private String downPath;

    @Override
    public ReturnT<Object> importMsg() {
        if (ScoresServiceImpl.isImportEnd) {
            if (StringUtils.isNotBlank(ScoresServiceImpl.errMessage)) {
                return ReturnT.getFail(ScoresServiceImpl.errMessage);
            }
            if (ScoresServiceImpl.errList.size() > 0) {
                Map<String, String> colMap = new HashMap<>();
                colMap.put("班级代码", "no");
                colMap.put("学生编号", "name");
                colMap.put("错误原因", "description");
                try {
                    String xlsFile = downPath + errXlsFileName;
                    new Excel().writeData(xlsFile, "导入出错数据", ScoresServiceImpl.errList, colMap);
                    return new ReturnT(200, "/download/" + errXlsFileName, "导入已结束，不过出现错误");
                } catch (Exception e) {
                    e.printStackTrace();
                    return ReturnT.getFail(e.getMessage());
                }
            } else {
                return new ReturnT<>();
            }
        } else {
            Map<String, Integer> map = new HashMap<>();
            map.put("total", ScoresServiceImpl.total);
            map.put("success", ScoresServiceImpl.totalSuccess);
            map.put("fail", ScoresServiceImpl.totalFail);
            return new ReturnT(map);
        }
    }





}
