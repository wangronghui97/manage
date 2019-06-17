package com.demo.needmanage.service;

import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;

import com.demo.needmanage.dto.SpecialListDto;
import com.demo.needmanage.entity.Special;

public interface SpecialService {

    ResponeCode addSpecial(Special special);

    ResponeCode<SpecialListDto> getSpecials(Integer offset, Integer limit);

    ResponeCode deleteSpecial(Integer id);

    ResponeCode modifySpecial(Special special);

}
