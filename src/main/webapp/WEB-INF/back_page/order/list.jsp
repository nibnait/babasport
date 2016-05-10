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
            <c:forEach items="${orders }" var="order">
                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td><input type="checkbox" name="ids" value="73"/></td>
                    <td align="center">${order.id }--${order.oid }</td>
                    <td align="center">${order.totalPrice}</td>
                    <td align="center">${order.deliverFee}</td>
                    <td align="center">${order.payableFee}</td>
                    <td align="center">${order.paymentWayName}</td>
                    <td align="center">${order.paymentCashName}</td>
                    <td align="center">${order.isPaiyName}</td>
                    <td align="center">${order.stateName}</td>
                    <td align="center">${fn:substring(order.createDate,0,19) }</td>
                    <td align="center"></td>
                    <td align="center">
                        <a href="view.do?id=${order.id }" class="pn-opt">查看</a>
                    </td>
                </tr>
            </c:forEach>

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