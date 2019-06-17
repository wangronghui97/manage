package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.ClassMapper;
import com.demo.needmanage.dao.DepatmentMapper;
import com.demo.needmanage.dao.InstructorMapper;
import com.demo.needmanage.dao.StudentMapper;
import com.demo.needmanage.dto.ClassListDto;

import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Class;
import com.demo.needmanage.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassSerivceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private DepatmentMapper depatmentMapper;

    @Autowired
    private InstructorMapper instructorMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ResponeCode addClass(Class cla) {

        if (cla==null||cla.getDepatmentId()==null||cla.getInstructorId()==null||cla.getSpecialId()==null|| StringUtils.isEmpty(cla.getGrade())||StringUtils.isEmpty(cla.getName())){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

        Class cla1 = this.classMapper.selectBySelective(cla);
        if (cla1!=null){
            return ResponeCode.newResponeCode(MessageCode.ADDFAIL_BY_CLASS);

        }

        int result = this.classMapper.insertSelective(cla);
        if (result>0){
            return ResponeCode.newResponeCode(MessageCode.ADD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

    }

    @Override
    public ResponeCode<ClassListDto> getClasses(Integer offset, Integer limit) {
        if (offset==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        if (limit==null){
            limit = 10;
        }
        Integer total = this.classMapper.selectAllClass().size();
        if (offset>=total){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }
        ClassListDto listDto = new ClassListDto();
        listDto.setTotal(total);
        listDto.setEntitys(this.classMapper.selectByOffset(offset, limit));
        listDto.setDepatments(this.depatmentMapper.selectDepatmentAndSpecial());
        ResponeCode<ClassListDto> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        listDto.setInstructors(this.instructorMapper.selectAllInstructor(null));
        responeCode.setData(listDto);

        return responeCode;
    }

    @Override
    public ResponeCode deleteClass(Integer id) {
        if (id==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }

        int code = this.classMapper.deleteByPrimaryKey(id);
        if (code>0){
            //删除班级的所有学生
            this.studentMapper.deleteByClass(id);

            return ResponeCode.newResponeCode(MessageCode.DELETE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
    }

    @Override
    public ResponeCode modifyClass(Class cla) {
        if (cla==null||cla.getId()==null||cla.getDepatmentId()==null||cla.getInstructorId()==null||cla.getSpecialId()==null|| StringUtils.isEmpty(cla.getGrade())||StringUtils.isEmpty(cla.getName())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }

        int code = this.classMapper.updateByPrimaryKeySelective(cla);

        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }

    }
}
