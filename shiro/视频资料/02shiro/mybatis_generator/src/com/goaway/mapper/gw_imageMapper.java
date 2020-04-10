package com.goaway.mapper;

import com.goaway.entity.gw_image;

public interface gw_imageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(gw_image record);

    int insertSelective(gw_image record);

    gw_image selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(gw_image record);

    int updateByPrimaryKey(gw_image record);
}