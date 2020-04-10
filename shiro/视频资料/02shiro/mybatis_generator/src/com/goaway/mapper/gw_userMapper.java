package com.goaway.mapper;

import com.goaway.entity.gw_user;

public interface gw_userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(gw_user record);

    int insertSelective(gw_user record);

    gw_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(gw_user record);

    int updateByPrimaryKey(gw_user record);
}