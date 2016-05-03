<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/back_page/head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>babasport-list</title>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 库存管理 - 列表</div>
	<div class="clear"></div>
</div>
<div class="body-box">
<form method="post" id="tableForm">
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>商品编号</th>
			<th>商品颜色</th>
			<th>商品尺码</th>
			<th>市场价格</th>
			<th>销售价格</th>
			<th>库       存</th>
			<th>购买限制</th>
			<th>运       费</th>
			<th>是否赠品</th>
			<th>操       作</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="73"/></td>
				<td>20141028114308048</td>
				<td align="center">西瓜红</td>
				<td align="center">S</td>
				<td align="center"><input type="text" id="m52" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="p52" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="i52" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="l52" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="f52" value="10.0" disabled="disabled" size="10"/></td>
				<td align="center">不是</td>
				<td align="center"><a href="javascript:updateSku(52)" class="pn-opt">修改</a> | <a href="javascript:addSku(52)" class="pn-opt">保存</a></td>
			</tr>
		
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="73"/></td>
				<td>20141028114308048</td>
				<td align="center">西瓜红</td>
				<td align="center">M</td>
				<td align="center"><input type="text" id="m53" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="p53" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="i53" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="l53" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="f53" value="10.0" disabled="disabled" size="10"/></td>
				<td align="center">不是</td>
				<td align="center"><a href="javascript:updateSku(53)" class="pn-opt">修改</a> | <a href="javascript:addSku(53)" class="pn-opt">保存</a></td>
			</tr>
		
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="73"/></td>
				<td>20141028114308048</td>
				<td align="center">西瓜红</td>
				<td align="center">L</td>
				<td align="center"><input type="text" id="m54" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="p54" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="i54" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="l54" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="f54" value="10.0" disabled="disabled" size="10"/></td>
				<td align="center">不是</td>
				<td align="center"><a href="javascript:updateSku(54)" class="pn-opt">修改</a> | <a href="javascript:addSku(54)" class="pn-opt">保存</a></td>
			</tr>
		
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="73"/></td>
				<td>20141028114308048</td>
				<td align="center">西瓜红</td>
				<td align="center">XL</td>
				<td align="center"><input type="text" id="m55" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="p55" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="i55" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="l55" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="f55" value="10.0" disabled="disabled" size="10"/></td>
				<td align="center">不是</td>
				<td align="center"><a href="javascript:updateSku(55)" class="pn-opt">修改</a> | <a href="javascript:addSku(55)" class="pn-opt">保存</a></td>
			</tr>
		
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="73"/></td>
				<td>20141028114308048</td>
				<td align="center">墨绿</td>
				<td align="center">S</td>
				<td align="center"><input type="text" id="m56" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="p56" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="i56" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="l56" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="f56" value="10.0" disabled="disabled" size="10"/></td>
				<td align="center">不是</td>
				<td align="center"><a href="javascript:updateSku(56)" class="pn-opt">修改</a> | <a href="javascript:addSku(56)" class="pn-opt">保存</a></td>
			</tr>
		
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="73"/></td>
				<td>20141028114308048</td>
				<td align="center">墨绿</td>
				<td align="center">M</td>
				<td align="center"><input type="text" id="m57" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="p57" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="i57" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="l57" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="f57" value="10.0" disabled="disabled" size="10"/></td>
				<td align="center">不是</td>
				<td align="center"><a href="javascript:updateSku(57)" class="pn-opt">修改</a> | <a href="javascript:addSku(57)" class="pn-opt">保存</a></td>
			</tr>
		
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="73"/></td>
				<td>20141028114308048</td>
				<td align="center">墨绿</td>
				<td align="center">L</td>
				<td align="center"><input type="text" id="m58" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="p58" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="i58" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="l58" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="f58" value="10.0" disabled="disabled" size="10"/></td>
				<td align="center">不是</td>
				<td align="center"><a href="javascript:updateSku(58)" class="pn-opt">修改</a> | <a href="javascript:addSku(58)" class="pn-opt">保存</a></td>
			</tr>
		
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="73"/></td>
				<td>20141028114308048</td>
				<td align="center">墨绿</td>
				<td align="center">XL</td>
				<td align="center"><input type="text" id="m59" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="p59" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="i59" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="l59" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="f59" value="10.0" disabled="disabled" size="10"/></td>
				<td align="center">不是</td>
				<td align="center"><a href="javascript:updateSku(59)" class="pn-opt">修改</a> | <a href="javascript:addSku(59)" class="pn-opt">保存</a></td>
			</tr>
		
			<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
				<td><input type="checkbox" name="ids" value="73"/></td>
				<td>20141028114308048</td>
				<td align="center">浅粉</td>
				<td align="center">S</td>
				<td align="center"><input type="text" id="m60" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="p60" value="0.0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="i60" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="l60" value="0" disabled="disabled" size="10"/></td>
				<td align="center"><input type="text" id="f60" value="10.0" disabled="disabled" size="10"/></td>
				<td align="center">不是</td>
				<td align="center"><a href="javascript:updateSku(60)" class="pn-opt">修改</a> | <a href="javascript:addSku(60)" class="pn-opt">保存</a></td>
			</tr>
	</tbody>
</table>
</form>
</div>
</body>
</html>