package com.demo.needmanage.dao;

import com.demo.needmanage.dto.ApplyDto;
import com.demo.needmanage.dto.TotalDto;
import com.demo.needmanage.entity.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Apply record);

    int insertSelective(Apply record);

    List<Apply> selectByStatus(Integer status);

    List<Apply> selectByStatusByLimit(@Param("status") Integer status,@Param("offset") Integer offset, @Param("limit") Integer limit);

    Apply selectByPrimaryKey(Integer id);

    Apply selectByStudentNum(@Param("studentNum") String studentNum);

    List<ApplyDto> selectBySuccess();

    List<ApplyDto> selectBySuccessByLimit(@Param("offset") Integer offset, @Param("limit") Integer limit);

    int updateByPrimaryKeySelective(Apply record);

    int updateStudentNumKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);

    TotalDto selectTotal(@Param("id") Integer id);
}