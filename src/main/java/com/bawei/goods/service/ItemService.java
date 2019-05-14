package com.bawei.goods.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bawei.goods.entity.Item;

public interface ItemService {

	 int deleteByPrimaryKey(Integer id);

	    int insertSelective(Item record);

	    Item selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Item record);

	    //列表查询
	    List<Map> selectList(@Param("name")String name);
}
