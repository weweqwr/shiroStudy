package com.goaway.mapper;

import com.goaway.entity.gw_group;

public interface gw_groupMapper {
    int deleteByPrimaryKey(String id);

    int insert(gw_group record);

    int insertSelective(gw_group record);

    gw_group selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(gw_group record);

    int updateByPrimaryKey(gw_group record);
}