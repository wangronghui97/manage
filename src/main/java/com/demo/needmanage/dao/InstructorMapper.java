package com.demo.needmanage.dao;

import com.demo.needmanage.entity.Instructor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InstructorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Instructor record);

    int insertSelective(Instructor record);

    Instructor selectByPrimaryKey(Integer id);

    List<Instructor> selectAllInstructor(@Param("number") String number);

    List<Instructor> selectByOffset(@Param("offset") Integer offset, @Param("limit") Integer limit,@Param("number") String number);

    int updateByPrimaryKeySelective(Instructor record);

    int updateByPrimaryKey(Instructor record);

    Instructor selectByNameAndPassword(@Param("name") String name, @Param("password") String password);
}