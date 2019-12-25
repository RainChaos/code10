package com.jiapeng.messageplatform.controller;

import com.jiapeng.messageplatform.service.TeacherWxInfoService;
import com.jiapeng.messageplatform.utils.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HZL on 2019/8/9.
 */
@RestController
@RequestMapping("/teacherWxInfo")
public class TeacherWxInfoController{
    @Autowired
    TeacherWxInfoService teacherWxInfoService;

    @PostMapping("/wxBind")
    public ReturnT<Object> wxBind(String clCodes, String teNo, String openId, String phoneNo) throws Exception {
        teacherWxInfoService.wxBind(clCodes,teNo,openId,phoneNo);
        return new ReturnT<>();
    }

//    @PostMapping("/update")
//    public ReturnT<Object> update(Teacher teacher) {
//        teacherWxInfoService.cancelWxBind();
//        return new ReturnT<>();
//    }

    @PostMapping("/cancelWxBind")
    public ReturnT<Object> del(Integer id) {
        teacherWxInfoService.cancelWxBind(id);
        return new ReturnT<>();
    }
}
