package com.demo.needmanage.service.impl;

import com.demo.needmanage.comment.MessageCode;
import com.demo.needmanage.dao.ApplyMapper;
import com.demo.needmanage.dao.StudentMapper;
import com.demo.needmanage.dto.ApplyDto;
import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.dto.TotalDto;
import com.demo.needmanage.entity.Apply;
import com.demo.needmanage.entity.Notice;
import com.demo.needmanage.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public ResponeCode changeStatus(Integer status,Integer id) {

        Apply apply = new Apply();
        apply.setId(id);
        apply.setStatus(status);
        int code = this.applyMapper.updateByPrimaryKeySelective(apply);
        if (code>0){
            return ResponeCode.newResponeCode(MessageCode.UPDATE_SUCCESS);
        }else {
            return ResponeCode.newResponeCode(MessageCode.UPDATE_FAIL);
        }

    }

    @Override
    public ResponeCode<ListDto<Apply>> findApplyByStatus(Integer status, Integer offset, Integer limit) {

        if (offset==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        if (limit==null){
            limit = 10;
        }
        Integer total = this.applyMapper.selectByStatus(status).size();
        if (offset>total){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }
        ListDto<Apply> listDto = new ListDto<>();
        listDto.setTotal(total);
        listDto.setEntitys(this.applyMapper.selectByStatusByLimit(status, offset, limit));
        ResponeCode<ListDto<Apply>> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        responeCode.setData(listDto);

        return responeCode;


    }

    @Override
    public ResponeCode getApplySuccess(Integer offset,Integer limit) {

        List<ApplyDto> applyDtos = this.applyMapper.selectBySuccess();

        if (limit==null){
            limit=10;
        }

        if (applyDtos==null){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }

        ListDto<ApplyDto> listListDto = new ListDto<>();
        listListDto.setTotal(applyDtos.size());
        listListDto.setEntitys(this.applyMapper.selectBySuccessByLimit(offset, limit));

        ResponeCode<ListDto<ApplyDto>> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
        responeCode.setData(listListDto);


        return responeCode;


    }

    @Override
    public ResponeCode getTotal() {

        List<TotalDto> totalDtos = new ArrayList<>();

        TotalDto totalDto1 = this.applyMapper.selectTotal(1);
        totalDto1.setType("国家助学金A等");
        TotalDto totalDto2 = this.applyMapper.selectTotal(2);
        totalDto2.setType("国家助学金B等");
        TotalDto totalDto3 = this.applyMapper.selectTotal(3);
        totalDto3.setType("国家助学金C等");
        TotalDto totalDto4 = this.applyMapper.selectTotal(4);
        totalDto4.setType("国家励志奖学金");
        TotalDto totalDto5 = this.applyMapper.selectTotal(5);
        totalDto5.setType("精准扶贫");

        totalDtos.add(totalDto1);
        totalDtos.add(totalDto2);
        totalDtos.add(totalDto3);
        totalDtos.add(totalDto4);
        totalDtos.add(totalDto5);


        if (totalDtos.size()<1){
            return ResponeCode.newResponeCode(MessageCode.FIND_FAIL);
        }else {
            ResponeCode<List<TotalDto>> responeCode = ResponeCode.newResponeCode(MessageCode.FIND_SUCCESS);
            responeCode.setData(totalDtos);
            return responeCode;
        }

    }
}
