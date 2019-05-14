package com.bawei.goods.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bawei.goods.service.ItemService;
import com.bawei.goods.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class ItemController {
	
	@Resource
	private ItemService itemService;

	@RequestMapping("list")
	 public String list(@RequestParam(defaultValue="3")  Integer pageSize ,HttpServletRequest request,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="")String name) {
		//分页拦截\
		PageHelper.startPage(page, pageSize);
		List<Map> list = itemService.selectList(name);
		
		PageInfo<Map> info = new PageInfo<>(list);
		//初始化分页工具类
		PageUtil.page(request, "/list?name="+name, pageSize, list, (int)info.getTotal(), page);
		//封装查询的集合对象和查询条件
		request.setAttribute("list", list);
		request.setAttribute("name", name);
		request.setAttribute("pageSize", pageSize);
		return "list";//跳转到列表页面
		 
	 }
}
