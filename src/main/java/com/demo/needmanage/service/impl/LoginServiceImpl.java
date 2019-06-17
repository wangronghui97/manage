package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.AdminMapper;
import com.demo.needmanage.dao.InstructorMapper;
import com.demo.needmanage.dao.StudentMapper;
import com.demo.needmanage.dto.LoginResponse;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.dto.StudentDto;
import com.demo.needmanage.entity.Admin;
import com.demo.needmanage.entity.Instructor;
import com.demo.needmanage.entity.Student;
import com.demo.needmanage.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private InstructorMapper instructorMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ResponeCode dologin(String name, String password, String type) {

        if (StringUtils.isEmpty(name)||StringUtils.isEmpty(password)||StringUtils.isEmpty(type)){

            return ResponeCode.newResponeCode(MessageCode.LOGIN_FAIL);

        }

       if (type.equals("admin")){

           Admin admin = this.adminMapper.selectByNameAndPassword(name,password);
           if (admin==null){
               return ResponeCode.newResponeCode(MessageCode.LOGIN_FAIL);
           }
           admin.setPassword(null);
           ResponeCode<LoginResponse<Admin>> responeCode = ResponeCode.newResponeCode(MessageCode.LOGIN_SUCCESS);
           LoginResponse<Admin> loginResponse = new LoginResponse<>();
           loginResponse.setType(type);
           loginResponse.setInfo(admin);
           responeCode.setData(loginResponse);
           return responeCode;


       }else if(type.equals("instructor")){
           Instructor instructor = this.instructorMapper.selectByNameAndPassword(name, password);
           if (instructor==null){
               return ResponeCode.newResponeCode(MessageCode.LOGIN_FAIL);
           }

           instructor.setPassword(null);
           ResponeCode<LoginResponse<Instructor>> responeCode = ResponeCode.newResponeCode(MessageCode.LOGIN_SUCCESS);
           LoginResponse<Instructor> loginResponse = new LoginResponse<>();
           loginResponse.setType(type);
           loginResponse.setInfo(instructor);
           responeCode.setData(loginResponse);
           return responeCode;



       }else if (type.equals("student")){
           StudentDto studentDto = this.studentMapper.selectByNameAndPassword(name, password);
           if (studentDto==null){
               return ResponeCode.newResponeCode(MessageCode.LOGIN_FAIL);
           }


           ResponeCode<LoginResponse<StudentDto>> responeCode = ResponeCode.newResponeCode(MessageCode.LOGIN_SUCCESS);
           LoginResponse<StudentDto> loginResponse = new LoginResponse<>();
           loginResponse.setType(type);
           loginResponse.setInfo(studentDto);
           responeCode.setData(loginResponse);
           return responeCode;


       }else {
           return ResponeCode.newResponeCode(MessageCode.LOGIN_FAIL);
       }

    }
}
