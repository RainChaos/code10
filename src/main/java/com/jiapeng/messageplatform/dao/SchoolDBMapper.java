package com.jiapeng.messageplatform.dao;

import com.jiapeng.messageplatform.entity.SchoolDB;
import com.jiapeng.messageplatform.entity.SchoolTerm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SchoolDBMapper {
    int deleteByPrimaryKey(String scCode);

    int insert(SchoolDB record);

    int insertSelective(SchoolDB record);

    SchoolDB selectByPrimaryKey(String scCode);

    int updateByPrimaryKeySelective(SchoolDB record);

    int updateByPrimaryKey(SchoolDB record);

    List <SchoolDB> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);

    int listCount();

    @Select("select term.* from school_term term where term.scCode = #{scCode}")
    List<SchoolTerm> listTerm(@Param("scCode") String scCode);

    @Select("select term.* from school_term term where term.scCode = #{scCode} and term.name = #{name}")
    List<SchoolTerm> findTerm(@Param("scCode") String scCode,@Param("name") String name);

    @Insert("INSERT INTO school_term(scCode,name) values( #{scCode}, #{name})")
    int insertTerm(@Param("scCode") String scCode,@Param("name") String name);

}