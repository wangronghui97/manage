package com.demo.needmanage.service;

import com.demo.needmanage.dto.AdminDto;
import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.LoginResponse;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Instructor;


public interface InstructorService {

    ResponeCode addInsructor(Instructor instructor);

    ResponeCode<ListDto<Instructor>> getInstructors(Integer offset, Integer limit,String number);

    ResponeCode deleteInstructor(Integer id);

    ResponeCode modifyInstructor(Instructor instructor);

    ResponeCode<LoginResponse<Instructor>> modifyInstructorByInstructor(Instructor instructor);

    public ResponeCode modifyPassword(AdminDto adminDto);
}
