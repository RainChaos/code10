package com.jiapeng.messageplatform.service;

import com.jiapeng.messageplatform.entity.ScoreEntity;
import com.jiapeng.messageplatform.utils.PageResult;
import com.jiapeng.messageplatform.utils.ReturnT;

import java.util.List;
import java.util.Map;

public interface ScoresService {

    PageResult list(Integer page, Integer limit,
                    List<String> clCodeList, String stuNo,String term);

    void importStuScore(String fileName, String sheetName);

    ReturnT<Object> importMsg();

    void update(ScoreEntity scoreEntity);

    void updateById(ScoreEntity scoreEntity);

    void insert(ScoreEntity scoreEntity);

    void delete(String id);
}
