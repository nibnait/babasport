<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>填写核对订单信息</title>
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script src="/res/js/com.js"></script>
<script type="text/javascript">
$(function(){
	$("input[name='paymentWay']").click(function(){
		var v = $(this).val();
		if(v == 0){
			$("#paymentCash").attr("style","");
		}else{
			$("#paymentCash").attr("style","display: none;");
		}
	});
});
</script>
</head>
<body>
<div class="bar"><div class="bar_w">
	<p class="l">
		<span class="l">
			收藏本网站！北京<a href="#" title="更换">[更换]</a>
		</span>
	</p>
	<ul class="r uls">
		<li class="dev">
			您好,欢迎来到新巴巴运动网！
		</li>
	<li class="dev"><a href="javascript:void(0)" onclick="login()"  title="登陆">[登陆]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="register()" title="免费注册">[免费注册]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="logout()" title="退出">[退出]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="myOrder()" title="我的订单">我的订单</a></li>
	<li class="dev"><a href="#" title="在线客服">在线客服</a></li>
	<li class="dev after"><a href="#" title="English">English</a></li>
	</ul>
</div></div>
<ul class="ul step st3_2">
<li title="1.我的购物车">1.我的购物车</li>
<li title="2.填写核对订单信息" class="here">2.填写核对订单信息</li>
<li title="3.成功提交订单">3.成功提交订单</li>
</ul>
<form action="confirmOrder.jsp" method="post">

<div class="w ofc case">
	<h2 class="h2 h2_r mt"><em title="收货人信息">收货人信息      [<a href="#"><font style="color:blue;">修改</font></a>]</em><cite></cite></h2>
	<div class="box bg_white">
		<dl class="distr">
			<dd>范冰冰   13888888888 <span style="margin-left: 30px">北京海淀区西三旗 XXXXXXXXXXXXXXXXXXXXXXXXXXX</span></dd>
		</dl>
	</div>
	
	<div class="box bg_white pb">
		<dl class="distr">
			<dt><input type="radio" name="paymentWay" value="0" />货到付款<span class="gray" style="margin-left: 140px">送货上门后再收款，支持现金、POS机刷卡、支票支付</span></dt>
			<dt><input type="radio" name="paymentWay" value="1" checked="checked"/>在线支付<span class="gray" style="margin-left: 140px">即时到帐，支持绝大数银行借记卡及部分银行信用卡；</span></dt>
			<dt><input type="radio" name="paymentWay" value="2"/>公司转账<span class="gray" style="margin-left: 140px"> 公司转账通过快钱平台转账 转帐后1-3个工作日内到帐</span></dt>
			<dt><input type="radio" name="paymentWay" value="3"/>邮局汇款<span class="gray" style="margin-left: 140px"> 公司转账通过快钱平台转账 转帐后1-3个工作日内到帐</span></dt>
			<dd id="paymentCash"  style="display: none;">
				<label>付款方式：</label>
				<input type="radio" name="paymentCash" value="0" checked="checked"/>现金&nbsp;&nbsp;<input type="radio" name="paymentCash" value="1"/>POS刷卡
			</dd>
			<dt style="margin-top: 40px"><input type="radio" value="1" name="deliveryMethod" checked="checked" />快递运输</dt>
			<dd class="box_d bg_gray2 ofc">
				<ul class="uls form">
					<li>
						<label for="deliveryTime">送货时间：</label>
						<input type="radio" name="delivery" value="3" checked="checked" />只工作日送货（双休日，节假日不送）
					</li>
					<li>
						<label>&nbsp;</label>
						<input type="radio" name="delivery" value="1"/>工作日，双休日，假日均可送货
					</li>
					<li>
						<label>&nbsp;</label>
						<input type="radio" name="delivery" value="2"/>只双休日，假日送货
					</li>
					<li>
						<label>送货前电话确认：</label>
						<input type="radio" name="isConfirm" value="1"/>是&nbsp;&nbsp;<input type="radio" name="isConfirm" checked="checked" value="0"/>否
					</li>
				</ul>
			</dd>
		</dl>
	</div>
	
	<h2 class="h2 h2_r mt"><em title="发票信息">发票信息</em><cite></cite></h2>
	<div class="box bg_white pb">
		<dl class="distr">
			<dd class="box_d bg_gray2 ofc">
				<ul class="uls form">
				<li><label for="">发票类型：</label><input type="radio" value="1" name="payable" checked="checked" />个人&nbsp;&nbsp;<input type="radio" value="2" name="payable" />单位</li>
				<li><label for="">发票抬头：</label><span class="bg_text"><input type="text" id="invoiceNick" name="company" maxLength="32" class="txt" value="" /></span></li>
				<li><label>发票内容：</label><select name="contents"><option value="1" selected>明细</option><option value="2">办公用品</option></select></li>
				</ul>
			</dd>
		</dl>
	</div>

	<h2 class="h2 h2_r mt"><em title="商品清单">商品清单</em><cite></cite></h2>
	<div class="box bg_white pb">
		<table cellspacing="0" class="tab tab4" summary="">
		<thead>
		<tr>
		<th>编号</th>
		<th class="wp">商品</th>
		<th>商品价格（元）</th>
		<th>数量</th>
		<th>库存状态</th>
		</tr>                                                                                           
		</thead>
		<tbody>
			<tr>
				<td>20141028114510004</td>
				<td class="img48x20">
					<span class="inb"><img src="/res/img/pic/ppp0.jpg"></span>
					<a target="block" href="javascript:void(0);"> 喜悦2014秋冬新款瑜伽服三件套装 韩版女士瑜珈舞蹈服 愈--西瓜红--S</a>
				</td>
				<td>￥333.01元</td>
				<td>x1</td>
				<td>88</td>
			</tr>
			<tr>
				<td>20141028114510004</td>
				<td class="img48x20">
					<span class="inb"><img src="/res/img/pic/ppp0.jpg"></span>
					<a target="block" href="javascript:void(0);"> 喜悦2014秋冬新款瑜伽服三件套装 韩版女士瑜珈舞蹈服 愈--典雅灰--M</a>
				</td>
				<td>￥235.0元</td>
				<td>x1</td>
				<td>333</td>
			</tr>
			<tr>
				<td>20141028114510004</td>
				<td class="img48x20">
					<span class="inb"><img src="/res/img/pic/ppp0.jpg"></span>
					<a target="block" href="javascript:void(0);"> 喜悦2014秋冬新款瑜伽服三件套装 韩版女士瑜珈舞蹈服 愈--草绿--XL</a>
				</td>
				<td>￥121.0元</td>
				<td>x1</td>
				<td>66</td>
			</tr>
		</tbody>
		</table>
	</div>

	 <div class="confirm mt">
		<div class="tl"></div><div class="tr"></div>
		<div class="ofc">
			<div class="r">
				<dl class="total">
					<dt>订单金额：<cite>(共<var id="totalNum">3</var>个商品)</cite></dt>
					<dd><em class="l">商品金额：</em>￥<var>689.01</var></dd>
					<dd><em class="l">返现：</em>￥<var>0.00</var></dd>
					<dd><em class="l">运费：</em>￥<var>0.0</var></dd>
					<dd class="orange"><em class="l">应付总额：</em>￥<var id="totalMoney">689.01</var></dd>
					<dd class="alg_c"><input type="submit" class="hand btn136x36a" value="提交订单" id="submitOrderID"></dd>
				</dl>
			</div>
		</div>
    </div>
</div>
</form>
</body>
</html>