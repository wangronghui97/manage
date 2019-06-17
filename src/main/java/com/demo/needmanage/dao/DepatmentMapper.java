package com.demo.needmanage.dao;

import com.demo.needmanage.dto.CascadeDto;
import com.demo.needmanage.entity.Depatment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepatmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Depatment record);

    int insertSelective(Depatment record);

    Depatment selectByPrimaryKey(Integer id);

    List<Depatment> selectAllDepatment();

    List<Depatment> selectByOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);

    int updateByPrimaryKeySelective(Depatment record);

    int updateByPrimaryKey(Depatment record);

    List<CascadeDto> selectDepatmentAndSpecial();

    List<CascadeDto> selectDepatmentAndSpecialAndClass();

    Depatment selectByName(@Param("name") String name);
}