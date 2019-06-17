package com.demo.needmanage.service;

import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Depatment;


public interface DepatmentService {

    ResponeCode addDepatment(Depatment depatment);

    ResponeCode<ListDto<Depatment>> getDepatments(Integer offset, Integer limit);

    ResponeCode deleteDepatment(Integer id);

    ResponeCode modifyDepatment(Depatment depatment);

}
