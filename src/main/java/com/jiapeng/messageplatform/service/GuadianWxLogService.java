package com.jiapeng.messageplatform.service;

import com.jiapeng.messageplatform.utils.PageResult;

public interface GuadianWxLogService {

    PageResult getRecord(int pageIndex, int pageSize, String scCode, String stuNo,String stuName,  String startDate, String endDate);
}
