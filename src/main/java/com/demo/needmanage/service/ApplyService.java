package com.demo.needmanage.service;

import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Apply;

import java.util.List;

public interface ApplyService {


    public ResponeCode changeStatus(Integer status,Integer id);

    public ResponeCode<ListDto<Apply>> findApplyByStatus(Integer status, Integer offset, Integer limit);

    public ResponeCode getApplySuccess(Integer offset,Integer limit);

    ResponeCode getTotal();

}
