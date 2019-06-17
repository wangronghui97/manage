package com.demo.needmanage.service;

import com.demo.needmanage.dto.ClassListDto;
import com.demo.needmanage.dto.ListDto;
import com.demo.needmanage.dto.ResponeCode;
import com.demo.needmanage.entity.Class;


public interface ClassService {

    ResponeCode addClass(Class cla);

    ResponeCode<ClassListDto> getClasses(Integer offset, Integer limit);

    ResponeCode deleteClass(Integer id);

    ResponeCode modifyClass(Class cla);

}
