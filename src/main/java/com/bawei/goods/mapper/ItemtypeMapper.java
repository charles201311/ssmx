package com.bawei.goods.mapper;

import com.bawei.goods.entity.Itemtype;

public interface ItemtypeMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Itemtype record);

    int insertSelective(Itemtype record);

    Itemtype selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Itemtype record);

    int updateByPrimaryKey(Itemtype record);
}