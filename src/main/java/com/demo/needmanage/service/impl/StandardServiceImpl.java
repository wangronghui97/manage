package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.comment.StringUtils;
import com.demo.needmanage.dao.StandardMapper;
import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Notice;
import com.demo.needmanage.entity.Standard;
import com.demo.needmanage.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardServiceImpl implements StandardService {

    @Autowired
    private StandardMapper standardMapper;

    @Override
    public ResponeCode addStandard(Standard standard) {

        if (standard==null|| StringUtils.isEmpty(standard.getContent())){
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

        int result = this.standardMapper.insertSelective(standard);
        if (result>0){
            return ResponeCode.newResponeCode(MessageCode.ADD_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.ADD_FAIL);
        }

    }

    @Override
    public ResponeCode<ListDto<Standard>> getStandards(Integer offset, Integer limit) {
        if (offset==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        if (limit==null){
            limit = 10;
        }

        Integer total = this.standardMapper.selectAllStandard().size();
        if (offset>=total){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }
        ListDto<Standard> listDto = new ListDto<>();
        listDto.setTotal(total);
        listDto.setEntitys(this.standardMapper.selectByOffset(offset, limit));
        ResponeCode<ListDto<Standard>> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        responeCode.setData(listDto);

        return responeCode;

    }

    @Override
    public ResponeCode deleteStandard(Integer id) {
        if (id==null){
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }

        int code = this.standardMapper.deleteByPrimaryKey(id);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.DELETE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.DELETE_FAIL);
        }
    }

    @Override
    public ResponeCode modifyStandard(Standard standard) {
        if (standard==null|| StringUtils.isEmpty(standard.getContent())){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }

        int code = this.standardMapper.updateByPrimaryKeySelective(standard);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }

    }
}
