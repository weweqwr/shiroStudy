package com.goaway.mapper;

import com.goaway.entity.gw_user_group;

public interface gw_user_groupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(gw_user_group record);

    int insertSelective(gw_user_group record);

    gw_user_group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(gw_user_group record);

    int updateByPrimaryKey(gw_user_group record);
}