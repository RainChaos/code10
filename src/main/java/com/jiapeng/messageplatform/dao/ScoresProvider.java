package com.jiapeng.messageplatform.dao;

import com.jiapeng.messageplatform.utils.DataGridJson;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public class ScoresProvider {
    public String listSql(@Param("clCode") List<String> clCode, @Param("stuNo") String stuNo, @Param("term") String term, @Param("limit") int rows, @Param("page") int page) throws Exception {



        String where = " where 1 = 1";
        if(clCode.size()!=0&&clCode!=null){
            String clList = String.join(",", clCode);
            where+=" and cla.cl_code in ( "+clList+")";
        }
        if(StringUtils.isNotBlank(stuNo)){
            where+=" and  stu.stuNo = #{stuNo} ";
        }

        if(StringUtils.isNotBlank(term)){
            where+=" and  tbsco.term = #{term} ";
        }

        Map<String,Integer> pObj = DataGridJson.compuPage(rows,page);

// String sql = String.format("select cla.*,gra.name as graName from class  cla left join grade gra on gra.gr_code = cla.gr_code %s  order by cl_number",where);
//       elect cla.*,gra.name as graName from class  cla left join grade gra on gra.gr_code = cla.gr_code %s  order by cl_number",where
        String sql = String.format("select * from (select ROW_NUMBER() over(order by id) rowid,sch.name as schName,gra.name as graName ,cla.name as claName,tbsco.* from  score tbsco " +
                " left join student stu on stu.stuId = tbsco.stuId " +
                " left join class cla  on stu.cl_code = cla.cl_code " +
                " left join grade gra on gra.gr_code = cla.gr_code" +
                " left join school sch on sch.sc_code = gra.sc_code %s) as t" +
                " where rowid between %d and %d",where,pObj.get("start"),pObj.get("end"));

        System.out.println("查询语句："+sql);
        return sql;

    }

    public String countSql(@Param("clCode") List<String> clCode, @Param("stuNo") String stuNo, @Param("term") String term){
        String where = " where 1 = 1";
        if(clCode.size()!=0&&clCode!=null){
            String clList = String.join(",", clCode);
            where+=" and cla.cl_code in ( "+clList+")";
        }
        if(StringUtils.isNotBlank(stuNo)){
            where+=" and  stu.stuNo = #{stuNo} ";
        }

        if(StringUtils.isNotBlank(term)){
            where+=" and  tbsco.term = #{term} ";
        }
        String sql = String.format("select count(0) from score tbsco " +
                " left join student stu on stu.stuId = tbsco.stuId " +
                " left join class cla  on stu.cl_code = cla.cl_code " +
                " %s",where);
        return sql;
    }

}
