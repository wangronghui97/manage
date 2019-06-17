package com.demo.needmanage.dao;

import com.demo.needmanage.dto.ClassDto;
import com.demo.needmanage.entity.Class;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer id);

    List<Integer> selectBySpecialId(Integer id);

    List<Integer> selectByDepatmentId(Integer id);

    Class selectBySelective(Class cla);

    List<Class> selectAllClass();

    List<ClassDto> selectByOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    int updateByInstructor(Integer id);
}