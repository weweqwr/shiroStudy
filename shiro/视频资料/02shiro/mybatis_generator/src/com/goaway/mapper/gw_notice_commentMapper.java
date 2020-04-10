package com.goaway.mapper;

import com.goaway.entity.gw_notice_comment;

public interface gw_notice_commentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(gw_notice_comment record);

    int insertSelective(gw_notice_comment record);

    gw_notice_comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(gw_notice_comment record);

    int updateByPrimaryKey(gw_notice_comment record);
}