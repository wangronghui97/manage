package com.demo.needmanage.service;

import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Type;

public interface TypeService {

    ResponeCode addType(Type type);

    ResponeCode<ListDto<Type>> getTypes(Integer offset, Integer limit);

    ResponeCode deleteType(Integer id);

    ResponeCode modifyType(Type type);

}
