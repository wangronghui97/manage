package com.demo.needmanage.dao;

import com.demo.needmanage.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    List<Notice> selectAllNotice();

    List<Notice> selectByOffset(@Param("offset") Integer offset, @Param("limit") Integer limit);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}




