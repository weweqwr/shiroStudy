package com.goaway.mapper;

import com.goaway.entity.gw_notice_user;

public interface gw_notice_userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(gw_notice_user record);

    int insertSelective(gw_notice_user record);

    gw_notice_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(gw_notice_user record);

    int updateByPrimaryKey(gw_notice_user record);
}