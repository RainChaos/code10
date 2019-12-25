package com.jiapeng.messageplatform.controller;

import com.jiapeng.messageplatform.dao.ScoresMapper;
import com.jiapeng.messageplatform.entity.ScoreEntity;
import com.jiapeng.messageplatform.entity.Student;
import com.jiapeng.messageplatform.service.ScoresService;
import com.jiapeng.messageplatform.utils.PageResult;
import com.jiapeng.messageplatform.utils.ReturnT;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoresService scoresService;


    /**
     * 添加学生成绩
     *
     * @param scoreEntity
     * @return
     */
    @PostMapping("/add")
    public ReturnT<Object> add(ScoreEntity scoreEntity) throws Exception {
        scoresService.insert(scoreEntity);
        return new ReturnT<>();
    }

    /**
     * 根据学生编号，班级代码，学期
     * @param scoreEntity
     * @return
     */
    @PostMapping("/update")
    public ReturnT<Object> update(ScoreEntity scoreEntity) {
        scoresService.update(scoreEntity);
        return new ReturnT<>();
    }

    @PostMapping("/del")
    public ReturnT<Object> del(String id) {
        scoresService.delete(id);
        return new ReturnT<>();
    }

    /**
     * 学生成绩
     *
     * @param page
     * @param limit
     * @param clCode
     * @param stuNo
     * @param term
     * @return
     */
    @PostMapping("/list")
    public ReturnT<Object> getList(HttpServletRequest request, Integer page, Integer limit,
                                   String clCode, String stuNo,String term) {
        List<String> clCodeList = new ArrayList<>();
        PageResult pageResult = scoresService.list(page, limit, clCodeList, stuNo, term);
        return new ReturnT<>(pageResult);
    }

    /**
     * 导入学生
     *
     * @param
     * @param
     * @return (String fileName, String sheetName
     */
    @PostMapping("/import")
    public ReturnT<Object> importTeacher(){
        scoresService.importStuScore("D:\\test.xlsx", "sheet1");
        return new ReturnT<>();
    }



    /**
     * 查看导入教师进度信息，导入后通过轮询查看该方法是否导入完成
     *
     * @return
     */
    @PostMapping("/importMsg")
    public ReturnT<Object> importMsg() {
        return scoresService.importMsg();
    }







}
