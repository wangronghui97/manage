package com.demo.needmanage.service;

import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Notice;
import com.demo.needmanage.entity.Standard;

public interface StandardService {

    ResponeCode addStandard(Standard standard);

    ResponeCode<ListDto<Standard>> getStandards(Integer offset, Integer limit);

    ResponeCode deleteStandard(Integer id);

    ResponeCode modifyStandard(Standard standard);

}
