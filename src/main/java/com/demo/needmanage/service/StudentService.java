package com.demo.needmanage.service;

import com.demo.needmanage.dto.AdminDto;
import com.demo.needmanage.dto.ResponeCode;

import com.demo.needmanage.dto.StudentListDto;
import com.demo.needmanage.entity.Apply;
import com.demo.needmanage.entity.Student;

public interface StudentService {

    ResponeCode addStudent(Student student);

    ResponeCode<StudentListDto> getStudents(Integer offset, Integer limit);

    ResponeCode deleteStudent(Integer id);

    ResponeCode modifyStudent(Student student);

    ResponeCode modifyStudentByStudent(Student student);

    public ResponeCode modifyPassword(AdminDto adminDto);

    public ResponeCode addApply(Apply apply);

    public ResponeCode modifyApply(Apply apply);

    ResponeCode findApplyByStudentNum(String studentNum);

}
