<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>列表展示</title>
<!-- 引入css样式 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resource/css/mystyles.css">
	<!-- 引入jquery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/js/jquery-3.0.0.min.js"></script>

<script type="text/javascript">
//文档就绪函数
$(function(){
	//获取 request域中的值
	var pageSize='${pageSize}';
	//让分页下拉框动态选中
	$("[name='pageSize']").find("option[value='"+pageSize+"']").prop("selected",true)
	
})


function query(){
	var name =$("[name='name']").val();
	//获取没有要显示的记录数
	var pageSize=$("[name='pageSize']").val();
	location.href="list?name="+name+"&pageSize="+pageSize;
}

</script>

</head>
<body>



用户名称:<input type="text" name="name" value="${name }">
   <input type="button" value="查询" onclick="query()">
         <input type="button" value="增加" onclick="toAdd()">
	<table>
		<tr>
			<td>序号</td>
			<td>商品名称</td>
			<td>价格</td>
			<td>分类</td>
			<td>库存</td>
			<td>单位</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${list}" var="c" varStatus="i">
			<tr>
				<td>${i.index+1 }</td>
				<td>${c.name }</td>
				<td>${c.price }</td>
				<td>${c.tname }</td>
				<td>${c.store}</td>
				<td>${c.dw }</td>
				<td>修改|删除</td>
			</tr>
		</c:forEach>

       <tr >
       <td colspan="7">${page}
       <select name="pageSize" onchange="query()">
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
       
       </select>
       
       </td>
       </tr>
	</table>
</body>
</html>