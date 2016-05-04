<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='toAdd.do'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/brand/list.do" method="post" style="padding-top:5px;">
品牌名称: <input type="text" name="name" value="${name }"/>
	<select name="isDisplay">
		<option value="1" <c:if test="${isDisplay == 1 }">selected="selected"</c:if> >是</option>
		<option value="0" <c:if test="${isDisplay == 0 }">selected="selected"</c:if>>不是</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="checkBox('ids',this.checked)"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th>
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<c:forEach items="${pagination.list }" var="entry">
		
			<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
				<td><input type="checkbox" value="${entry.id }" name="ids"/></td>
				<td align="center">${entry.id }</td>
				<td align="center">${entry.name }</td>
				<td align="center"><img width="40" height="40" src="${entry.allUrl}"/></td>
				<td align="center">${entry.description }</td>
				<td align="center">${entry.sort }</td>
				<td align="center"><c:if test="${entry.isDisplay == 1 }">是</c:if><c:if test="${entry.isDisplay == 0 }">不是</c:if></td>
				<td align="center">
				<a class="pn-opt" href="#">修改</a> | <a class="pn-opt"  href="/brand/delete.do?id=${entry.id }&name=${name}&isDisplay=${isDisplay}">删除</a>
				</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>
<div class="page pb15">
	<span class="r inb_a page_b">
		<c:forEach items="${pagination.pageView }" var="page">
			${page }
		</c:forEach>
	</span>
</div>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/></div>
</div>
</body>
</html>