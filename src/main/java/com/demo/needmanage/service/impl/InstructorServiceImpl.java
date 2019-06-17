package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.ClassMapper;
import com.demo.needmanage.dao.InstructorMapper;
import com.demo.needmanage.dto.AdminDto;
import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.LoginResponse;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Instructor;
import com.demo.needmanage.entity.Student;
import com.demo.needmanage.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorMapper instructorMapper;

    @Autowired
    private ClassMapper classMapper;

    @Override
    public ResponeCode addInsructor(Instructor instructor) {
        if (instructor==null|| StringUtils.isEmpty(instructor.getName())||instructor.getSex()==null){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }
        if (instructor.getSex()!=1&&instructor.getSex()!=2){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }
        instructor.setPassword("1111");
        int result = this.instructorMapper.insertSelective(instructor);
        if (result>0){

            instructor.setNumber("BSGUFE0"+instructor.getId());
            this.instructorMapper.updateByPrimaryKeySelective(instructor);
            return ResponeCode.newResponeCode(MessageCode.ADD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }
    }

    @Override
    public ResponeCode<ListDto<Instructor>> getInstructors(Integer offset, Integer limit,String number) {
        if (offset==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        if (limit==null){
            limit = 10;
        }

        int total = this.instructorMapper.selectAllInstructor(number).size();
        if (offset>=total){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }
        ListDto<Instructor> listDto = new ListDto<>();
        listDto.setTotal(total);
        listDto.setEntitys(this.instructorMapper.selectByOffset(offset, limit,number));
        ResponeCode<ListDto<Instructor>> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        responeCode.setData(listDto);

        return responeCode;
    }

    @Override
    public ResponeCode deleteInstructor(Integer id) {
        if (id==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
        int code = this.instructorMapper.deleteByPrimaryKey(id);
        if (code>0){
            this.classMapper.updateByInstructor(id);
            return ResponeCode.newResponeCode(MessageCode.DELETE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
    }

    @Override
    public ResponeCode modifyInstructor(Instructor instructor) {
        if (instructor==null|| StringUtils.isEmpty(instructor.getName())||instructor.getSex()==null){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }
        if (instructor.getSex()!=1&&instructor.getSex()!=2){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }
        int code = this.instructorMapper.updateByPrimaryKeySelective(instructor);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }
    }

    @Override
    public ResponeCode<LoginResponse<Instructor>> modifyInstructorByInstructor(Instructor instructor) {

        ResponeCode responeCode = this.modifyInstructor(instructor);
        if (responeCode.getStatus()!=200){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }else {

            LoginResponse<Instructor> loginResponse = new LoginResponse<>();
            loginResponse.setInfo(this.instructorMapper.selectByPrimaryKey(instructor.getId()));
            loginResponse.setType("instructor");
            ResponeCode<LoginResponse<Instructor>> responseResponeCode = ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
            responseResponeCode.setData(loginResponse);
            return responseResponeCode;
        }

    }

    @Override
    public ResponeCode modifyPassword(AdminDto adminDto) {
        if (adminDto==null||adminDto.getId()==null||StringUtils.isEmpty(adminDto.getPassword())||StringUtils.isEmpty(adminDto.getOldpassword())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL);
        }
        Instructor instructor = this.instructorMapper.selectByPrimaryKey(adminDto.getId());
        if (instructor==null){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL);
        }
        if (!adminDto.getOldpassword().equals(instructor.getPassword())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL_OLD);
        }
        instructor.setPassword(adminDto.getPassword());
        int code = this.instructorMapper.updateByPrimaryKeySelective(instructor);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL);

        }
    }
}
