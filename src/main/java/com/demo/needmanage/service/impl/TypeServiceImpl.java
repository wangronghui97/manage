package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.TypeMapper;
import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Type;
import com.demo.needmanage.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public ResponeCode addType(Type type) {

        if (type==null|| StringUtils.isEmpty(type.getName())||StringUtils.isEmpty(type.getConditional())){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

        int result = this.typeMapper.insertSelective(type);
        if (result>0){
            return ResponeCode.newResponeCode(MessageCode.ADD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

    }

    @Override
    public ResponeCode<ListDto<Type>> getTypes(Integer offset, Integer limit) {
        if (offset==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        if (limit==null){
            limit = 10;
        }

        Integer total = this.typeMapper.selectAllType().size();
        if (offset>=total){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }
        ListDto<Type> listDto = new ListDto<>();
        listDto.setTotal(total);
        listDto.setEntitys(this.typeMapper.selectByOffset(offset, limit));
        ResponeCode<ListDto<Type>> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        responeCode.setData(listDto);

        return responeCode;
    }

    @Override
    public ResponeCode deleteType(Integer id) {
        if (id==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
        int code = this.typeMapper.deleteByPrimaryKey(id);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.DELETE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
    }

    @Override
    public ResponeCode modifyType(Type type) {
        if (type==null|| StringUtils.isEmpty(type.getName())||StringUtils.isEmpty(type.getConditional())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }
        int code = this.typeMapper.updateByPrimaryKeySelective(type);

        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }
    }
}
