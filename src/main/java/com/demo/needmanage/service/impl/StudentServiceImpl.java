package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.ApplyMapper;
import com.demo.needmanage.dao.ClassMapper;
import com.demo.needmanage.dao.DepatmentMapper;
import com.demo.needmanage.dao.StudentMapper;
import com.demo.needmanage.dto.*;
import com.demo.needmanage.entity.Apply;
import com.demo.needmanage.entity.Class;
import com.demo.needmanage.entity.Student;
import com.demo.needmanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DepatmentMapper depatmentMapper;

    @Autowired
    private ApplyMapper applyMapper;

    @Autowired
    private ClassMapper classMapper;

    @Override
    public ResponeCode addStudent(Student student) {

        if (student==null|| StringUtils.isEmpty(student.getName())||StringUtils.isEmpty(student.getStudentNum())||student.getClassId()==null||student.getDepatmentId()==null||student.getSpecialId()==null){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }
        if (student.getSex()!=1&&student.getSex()!=2){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

        Student student1 = this.studentMapper.selectByStudentNum(student.getStudentNum());
        if (student1!=null){
            return ResponeCode.newResponeCode(MessageCode.ADDFAIL_BY_STUDENTNUM);
        }

        Class cla = this.classMapper.selectByPrimaryKey(student.getClassId());
        student.setGrade(cla.getName().substring(0,5));
        if (student.getPassword()==null) {
            student.setPassword("111111");
        }
        int result = this.studentMapper.insertSelective(student);
        if (result>0){
            return ResponeCode.newResponeCode(MessageCode.ADD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }
    }

    @Override
    public ResponeCode<StudentListDto> getStudents(Integer offset, Integer limit) {
        if (offset==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        if (limit==null){
            limit = 10;
        }

        int total = this.studentMapper.selectAllStudent().size();
        if (offset>=total){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }
        StudentListDto listDto = new StudentListDto();
        listDto.setTotal(total);
        listDto.setEntitys(this.studentMapper.selectByOffset(offset, limit));
        listDto.setDepatments(this.depatmentMapper.selectDepatmentAndSpecialAndClass());
        ResponeCode<StudentListDto> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        responeCode.setData(listDto);
        return responeCode;


    }

    @Override
    public ResponeCode deleteStudent(Integer id) {
        if (id==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
        Student student = this.studentMapper.selectByPrimaryKey(id);
        if (student==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
        Apply apply = this.applyMapper.selectByStudentNum(student.getStudentNum());
        if (apply==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
        this.applyMapper.deleteByPrimaryKey(apply.getId());
        int code = this.studentMapper.deleteByPrimaryKey(id);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.DELETE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
    }

    @Override
    public ResponeCode modifyStudent(Student student) {
        if (student==null|| StringUtils.isEmpty(student.getName())||StringUtils.isEmpty(student.getStudentNum())||student.getClassId()==null||student.getDepatmentId()==null||student.getSpecialId()==null){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }
        if (student.getSex()!=1&&student.getSex()!=2){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }

        Class cla = this.classMapper.selectByPrimaryKey(student.getClassId());
        student.setGrade(cla.getName().substring(0,5));
        int code = this.studentMapper.updateByPrimaryKeySelective(student);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }
    }

    @Override
    public ResponeCode modifyStudentByStudent(Student student) {

        int code = this.studentMapper.updateByPrimaryKeySelective(student);
        if (code<0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }else {

            StudentDto studentDto = this.studentMapper.selectByIdjiaqiang(student.getId());
            ResponeCode<LoginResponse<StudentDto>> responeCode1 = ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
            LoginResponse<StudentDto> loginResponse = new LoginResponse<>();
            loginResponse.setType("student");
            loginResponse.setInfo(studentDto);
            responeCode1.setData(loginResponse);
            return responeCode1;

        }

    }

    @Override
    public ResponeCode modifyPassword(AdminDto adminDto) {
        if (adminDto==null||adminDto.getId()==null||StringUtils.isEmpty(adminDto.getPassword())||StringUtils.isEmpty(adminDto.getOldpassword())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL);
        }
        Student student = this.studentMapper.selectByPrimaryKey(adminDto.getId());
        if (student==null){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL);
        }
        if (!adminDto.getOldpassword().equals(student.getPassword())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL_OLD);
        }
        student.setPassword(adminDto.getPassword());
        int code = this.studentMapper.updateByPrimaryKeySelective(student);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_PASSWORD_FAIL);

        }

    }

    @Override
    public ResponeCode addApply(Apply apply) {

        if (apply==null||StringUtils.isEmpty(apply.getFatherName())||StringUtils.isEmpty(apply.getFatherPhone())||StringUtils.isEmpty(apply.getFatherProfe())||StringUtils.isEmpty(apply.getIncome())||StringUtils.isEmpty(apply.getMoney())||apply.getTypeId()==null||StringUtils.isEmpty(apply.getImageAdd())){
            return ResponeCode.newResponeCode(MessageCode.ADDFAIL_BY_INFO);
        }
        if (StringUtils.isEmpty(apply.getMotherName())||StringUtils.isEmpty(apply.getMotherPhone())||StringUtils.isEmpty(apply.getMotherProfe())||StringUtils.isEmpty(apply.getReason())||StringUtils.isEmpty(apply.getStudentName())||StringUtils.isEmpty(apply.getStudentNum())){
            return ResponeCode.newResponeCode(MessageCode.ADDFAIL_BY_INFO);
        }

        apply.setStatus(0);


        int code = this.applyMapper.insertSelective(apply);

        if (code>0){

            return ResponeCode.newResponeCode(MessageCode.ADD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }



    }

    @Override
    public ResponeCode findApplyByStudentNum(String studentNum) {

        Apply apply = this.applyMapper.selectByStudentNum(studentNum);

        if (apply==null){
            ResponeCode<String> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);

            return responeCode;
        }else {
            ResponeCode<Apply> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
            responeCode.setData(apply);
            return responeCode;
        }

    }

    @Override
    public ResponeCode modifyApply(Apply apply) {
        if (apply==null||StringUtils.isEmpty(apply.getFatherName())||StringUtils.isEmpty(apply.getFatherPhone())||StringUtils.isEmpty(apply.getFatherProfe())||StringUtils.isEmpty(apply.getIncome())||StringUtils.isEmpty(apply.getMoney())||apply.getTypeId()==null||StringUtils.isEmpty(apply.getImageAdd())){
            return ResponeCode.newResponeCode(MessageCode.ADDFAIL_BY_INFO);
        }
        if (StringUtils.isEmpty(apply.getMotherName())||StringUtils.isEmpty(apply.getMotherPhone())||StringUtils.isEmpty(apply.getMotherProfe())||StringUtils.isEmpty(apply.getReason())||StringUtils.isEmpty(apply.getStudentName())||StringUtils.isEmpty(apply.getStudentNum())){
            return ResponeCode.newResponeCode(MessageCode.ADDFAIL_BY_INFO);
        }

        apply.setStatus(0);

        int code = this.applyMapper.updateStudentNumKeySelective(apply);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }




    }
}
