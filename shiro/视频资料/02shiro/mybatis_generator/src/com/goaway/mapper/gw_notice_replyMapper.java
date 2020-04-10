package com.goaway.mapper;

import com.goaway.entity.gw_notice_reply;

public interface gw_notice_replyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(gw_notice_reply record);

    int insertSelective(gw_notice_reply record);

    gw_notice_reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(gw_notice_reply record);

    int updateByPrimaryKey(gw_notice_reply record);
}