<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/back_page/head.jsp" %>
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
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='add.jsp'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="v_list.shtml" method="post" style="padding-top:5px;">
品牌名称: <input type="text" name="name"/>
	<select >
		<option value="1">是</option>
		<option>不是</option>
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
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="8" name="ids"/></td>
			<td align="center">8</td>
			<td align="center">金乐乐</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="7" name="ids"/></td>
			<td align="center">7</td>
			<td align="center">喜悦瑜伽</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="6" name="ids"/></td>
			<td align="center">6</td>
			<td align="center">丹璐斯</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="5" name="ids"/></td>
			<td align="center">5</td>
			<td align="center">菩媞</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="4" name="ids"/></td>
			<td align="center">4</td>
			<td align="center">伊朵莲</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="3" name="ids"/></td>
			<td align="center">3</td>
			<td align="center">梵歌纳（vangona）</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="2" name="ids"/></td>
			<td align="center">2</td>
			<td align="center">凯速（KANSOON）</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="1" name="ids"/></td>
			<td align="center">1</td>
			<td align="center">依琦莲</td>
			<td align="center"><img width="40" height="40" src="/res/img/pic/ppp0.jpg"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">是</td>
			<td align="center">
			<a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	
	</tbody>
</table>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/></div>
</div>
</body>
</html>