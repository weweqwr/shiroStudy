package com.goaway.mapper;

import com.goaway.entity.gw_document;

public interface gw_documentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(gw_document record);

    int insertSelective(gw_document record);

    gw_document selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(gw_document record);

    int updateByPrimaryKey(gw_document record);
}