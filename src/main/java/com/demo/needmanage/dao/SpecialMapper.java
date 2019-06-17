package com.demo.needmanage.dao;

import com.demo.needmanage.dto.SpecialDto;
import com.demo.needmanage.entity.Special;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpecialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Special record);

    int insertSelective(Special record);

    Special selectByPrimaryKey(Integer id);

    Special selectBySelective(Special special);

    List<Integer> selectByDepatmentId(@Param("id") Integer id);

    List<Special> selectAllSpecial();

    List<SpecialDto> selectByOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);

    int updateByPrimaryKeySelective(Special record);

    int updateByPrimaryKey(Special record);
}