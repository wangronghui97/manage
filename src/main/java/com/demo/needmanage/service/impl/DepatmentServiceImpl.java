package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.ClassMapper;
import com.demo.needmanage.dao.DepatmentMapper;
import com.demo.needmanage.dao.SpecialMapper;
import com.demo.needmanage.dao.StudentMapper;
import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Depatment;
import com.demo.needmanage.entity.Notice;
import com.demo.needmanage.service.DepatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepatmentServiceImpl implements DepatmentService {

    @Autowired
    private DepatmentMapper depatmentMapper;

    @Autowired
    private SpecialMapper specialMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ResponeCode addDepatment(Depatment depatment) {
        if (depatment==null|| StringUtils.isEmpty(depatment.getName())){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }
        Depatment depatment1 = this.depatmentMapper.selectByName(depatment.getName());

        if (depatment1!=null){
            return ResponeCode.newResponeCode(MessageCode.ADDFAIL_BY_DEPATMENT);
        }

        int result = this.depatmentMapper.insertSelective(depatment);
        if (result>0){
            return ResponeCode.newResponeCode(MessageCode.ADD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

    }


    @Override
    public ResponeCode<ListDto<Depatment>> getDepatments(Integer offset, Integer limit) {
        if (offset==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        if (limit==null){
            limit = 10;
        }

        Integer total = this.depatmentMapper.selectAllDepatment().size();
        if (offset>=total){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }
        ListDto<Depatment> listDto = new ListDto<>();
        listDto.setTotal(total);
        listDto.setEntitys(this.depatmentMapper.selectByOffset(offset,limit));


        ResponeCode<ListDto<Depatment>> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        responeCode.setData(listDto);

        return responeCode;
    }

    @Override
    public ResponeCode deleteDepatment(Integer id) {
        if (id==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }


     int code = this.depatmentMapper.deleteByPrimaryKey(id);
        if (code>0){
            //删除专业
            List<Integer> list = this.specialMapper.selectByDepatmentId(id);
            for (Integer integer:list){
                this.classMapper.deleteByPrimaryKey(integer);
            }
            //删除班级
            List<Integer> list1 = this.classMapper.selectByDepatmentId(id);
            for (Integer integer:list1){
                this.classMapper.deleteByPrimaryKey(integer);
                //删除班级的学生
                this.studentMapper.deleteByClass(integer);

            }

            return ResponeCode.newResponeCode(MessageCode.DELETE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }

    }

    @Override
    public ResponeCode modifyDepatment(Depatment depatment) {

        if (depatment==null||StringUtils.isEmpty(depatment.getName())||depatment.getId()==null){

            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);

        }

        int code = this.depatmentMapper.updateByPrimaryKeySelective(depatment);

        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }


    }
}

