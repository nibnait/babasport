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
	<div class="rpos">当前位置: 订单管理 - 列表</div>
	<div class="clear"></div>
</div>
<div class="body-box">
<input type="hidden" name="pageNo" value="${pageNo}"/>
<form method="post" id="tableForm">
<input type="hidden" value="" name="pageNo"/>
<input type="hidden" value="" name="queryName"/>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>订单号</th>
			<th>订单金额</th>
			<th>运费</th>
			<th>应付金额</th>
			<th>支付方式</th>
			<th>支付要求</th>
			<th>支付状态</th>
			<th>订单状态</th>
			<th>下单时间</th>
			<th>备注</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" value="73"/></td>
			<td align="center">20--20141212114007973</td>
			<td align="center">128.0</td>
			<td align="center">0.0</td>
			<td align="center">128.11</td>
			<td align="center">货到到付</td>
			<td align="center">现金</td>
			<td align="center">货到到付</td>
			<td align="center">提交订单</td>
			<td align="center">2014-12-12 11:40:08.0</td>
			<td align="center"></td>
			<td align="center">
			<a href="view.jsp" class="pn-opt">查看</a>
			</td>
		</tr>
		
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" value="73"/></td>
			<td align="center">26--20141212170911104</td>
			<td align="center">128.0</td>
			<td align="center">0.0</td>
			<td align="center">128.0</td>
			<td align="center">货到到付</td>
			<td align="center">现金</td>
			<td align="center">货到到付</td>
			<td align="center">提交订单</td>
			<td align="center">2014-12-12 17:09:11.0</td>
			<td align="center"></td>
			<td align="center">
			<a href="view.jsp" class="pn-opt">查看</a>
			</td>
		</tr>
		
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" value="73"/></td>
			<td align="center">33--20141212172259427</td>
			<td align="center">328.0</td>
			<td align="center">0.0</td>
			<td align="center">328.0</td>
			<td align="center">货到到付</td>
			<td align="center">现金</td>
			<td align="center">货到到付</td>
			<td align="center">提交订单</td>
			<td align="center">2014-12-12 17:22:59.0</td>
			<td align="center"></td>
			<td align="center">
			<a href="view.jsp" class="pn-opt">查看</a>
			</td>
		</tr>
		
		<tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
			<td><input type="checkbox" name="ids" value="73"/></td>
			<td align="center">34--20141212172311831</td>
			<td align="center">200.0</td>
			<td align="center">0.0</td>
			<td align="center">200.0</td>
			<td align="center">货到到付</td>
			<td align="center">现金</td>
			<td align="center">货到到付</td>
			<td align="center">提交订单</td>
			<td align="center">2014-12-12 17:23:11.0</td>
			<td align="center"></td>
			<td align="center">
			<a href="view.jsp" class="pn-opt">查看</a>
			</td>
		</tr>
		
	</tbody>
</table>
<div style="margin-top:15px;">
<!-- 	<input class="del-button" type="button" value="取消" onclick="optCancel();"/>
	<input class="submit" type="button" value="通过" onclick="optPass();"/> -->
</div>
</form>
</div>
</body>
</html>