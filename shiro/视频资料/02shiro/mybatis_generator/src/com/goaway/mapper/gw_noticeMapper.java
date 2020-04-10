package com.goaway.mapper;

import com.goaway.entity.gw_notice;

public interface gw_noticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(gw_notice record);

    int insertSelective(gw_notice record);

    gw_notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(gw_notice record);

    int updateByPrimaryKeyWithBLOBs(gw_notice record);

    int updateByPrimaryKey(gw_notice record);
}