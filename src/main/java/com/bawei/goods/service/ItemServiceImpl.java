package com.bawei.goods.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.goods.entity.Item;
import com.bawei.goods.mapper.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {
	@Resource
	private ItemMapper itemMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return itemMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Item record) {
		return itemMapper.insertSelective(record);
	}

	@Override
	public Item selectByPrimaryKey(Integer id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Item record) {
		return itemMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Map> selectList(String name) {
		return itemMapper.selectList(name);
	}

}
