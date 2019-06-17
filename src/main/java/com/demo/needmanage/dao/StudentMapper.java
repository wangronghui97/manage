package com.demo.needmanage.dao;

import com.demo.needmanage.dto.StudentDto;
import com.demo.needmanage.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByClass(@Param("classId") Integer classId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    Student selectByStudentNum(@Param("studentNum") String studentNum);

    List<Student> selectAllStudent();

    List<StudentDto> selectByOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    StudentDto selectByStudentNumJiaQiang(String studentNum);

    StudentDto selectByIdjiaqiang(Integer id);

    StudentDto selectByNameAndPassword(@Param("name") String name, @Param("password") String password);

}