package com.jiapeng.messageplatform.dao;

import com.jiapeng.messageplatform.entity.ScoreEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface ScoresMapper {


    int deleteByPrimaryKey(String id);

    int insert(ScoreEntity scoreEntity);

    int insertSelective(ScoreEntity scoreEntity);

    ScoreEntity selectByPrimaryKey(@Param("stuId")String stuId,@Param("term")String term);

    int updateByPrimaryKeySelective(ScoreEntity record);

    int updateByPrimaryKeySelectiveById(ScoreEntity record);

    ScoreEntity selectById(String id);





    @SelectProvider(type = ScoresProvider.class, method = "listSql")
    List<Map<String, Object>> list(@Param("clCode") List<String> clCode,@Param("stuNo") String stuId,@Param("term") String term, @Param("limit") int rows, @Param("page") int page);


    @SelectProvider(type = ScoresProvider.class, method = "countSql")
    int count(@Param("clCode") List<String> clCode, @Param("stuNo") String stuId, @Param("term") String term);

}
