package com.jiapeng.messageplatform.service.impl;

import com.jiapeng.messageplatform.service.ScoresService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
//@SpringBootTest
// 这块需要引入依赖 mybatis的测试依赖jar
@MybatisTest
// 这个注解的意义是指定了默认数据源
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan("com.jiapeng.messageplatform")
public class TableTest {
    @Autowired
    private ScoresService scoresService;

    @Rollback(false)
    @Test
    public void testTable() throws Exception {
        try {
            scoresService.importStuScore("D:\\学生成绩导入模板.xlsx","sheet1");
        }catch (Exception e){
            e.printStackTrace();

        }

    }



}
