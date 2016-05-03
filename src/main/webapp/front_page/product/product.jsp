<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<title>新巴巴运动网-电子商城</title>
<link rel="stylesheet" href="/res/css/style.css" />
<script src="/res/js/jquery.js"></script>
<script src="/res/js/com.js"></script>
<script type="text/javascript">
//登陆
function login(){
	window.location.href = "../buyer/login.jsp";
}
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
	<li class="dev">您好,欢迎来到新巴巴运动网！</li>
	<li class="dev"><a href="javascript:void(0)" onclick="login()"  title="登陆">[登陆]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="register()" title="免费注册">[免费注册]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="logout()" title="退出">[退出]</a></li>
	<li class="dev"><a href="javascript:void(0)" onclick="myOrder()" title="我的订单">我的订单</a></li>
	<li class="dev"><a href="#" title="在线客服">在线客服</a></li>
	<li class="dev after"><a href="#" title="English">English</a></li>
	</ul>
</div></div>
<div class="w loc">
	<div class="h-title">
		<div class="h-logo"><a href="http://localhost:8080"><img src="/res/img/pic/logo-1.png" /></a></div>
	    <div class="h-search">
	      	<input type="text" />
	        <div class="h-se-btn"><a href="#">搜索</a></div>
	    </div>
	</div>
	<dl id="cart" class="cart r">
		<dt><a href="#" title="结算">结算</a>购物车:<b id="">5</b>件</dt>
		<dd class="hidden">
			<p class="alg_c hidden">购物车中还没有商品，赶紧选购吧！</p>
			<h3 title="最新加入的商品">最新加入的商品</h3>
			<ul class="uls">
				<li>
					<a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
					<img src="/res/img/pic/p50x50.jpg" alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元" /></a>
					<p class="dt"><a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
					<p class="dd">
						<b><var>¥128</var><span>x1</span></b>
						<a href="javascript:void(0);" title="删除" class="del">删除</a>
					</p>
				</li>
				<li>
					<a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
					<img src="/res/img/pic/p50x50.jpg" alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元" /></a>
					<p class="dt"><a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
					<p class="dd">
						<b><var>¥128</var><span>x1</span></b>
						<a href="javascript:void(0);" title="删除" class="del">删除</a>
					</p>
				</li>
				<li>
					<a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
					<img src="/res/img/pic/p50x50.jpg" alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元" /></a>
					<p class="dt"><a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
					<p class="dd">
						<b><var>¥128</var><span>x1</span></b>
						<a href="javascript:void(0);" title="删除" class="del">删除</a>
					</p>
				</li>
				<li>
					<a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
					<img src="/res/img/pic/p50x50.jpg" alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元" /></a>
					<p class="dt"><a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
					<p class="dd">
						<b><var>¥128</var><span>x1</span></b>
						<a href="javascript:void(0);" title="删除" class="del">删除</a>
					</p>
				</li>
				<li>
					<a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">
					<img src="/res/img/pic/p50x50.jpg" alt="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元" /></a>
					<p class="dt"><a href="#" title="依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元">依琦莲2014瑜伽服套装新 瑜珈健身服三件套 广场舞蹈服装 女瑜伽服送胸垫 长袖紫色 M全场支持货到付款 全网最低价 千人超高好评瑜伽服赶紧抢！全五分好评截图联系客服还返现五元</a></p>
					<p class="dd">
						<b><var>¥128</var><span>x1</span></b>
						<a href="javascript:void(0);" title="删除" class="del">删除</a>
					</p>
				</li>
			</ul>
			<div>
				<p>共<b>5</b>件商品&nbsp;&nbsp;&nbsp;&nbsp;共计<b class="f20">¥640.00</b></p>
				<a href="#" title="去购物车结算" class="inb btn120x30c">去购物车结算</a>
			</div>
		</dd>
	</dl>
</div>

<div class="w ofc">
	<div class="l wl">
		<h2 class="h2 h2_l"><em title="销量排行榜">销量排行榜</em><cite></cite></h2>
		<div class="box bg_white">
			<ul class="uls x_50x50">
				<li>
					<var class="sfont">1</var>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<var class="sfont">2</var>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<var class="sfont">3</var>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
			</ul>
		</div>

		<h2 class="h2 h2_l mt"><em title="我的浏览记录">我的浏览记录</em><cite></cite></h2>
		<div class="box bg_white">
			<ul class="uls x_50x50">
				<li>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
				<li>
					<a href="#" title="富一代" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<!-- dt 8个文字+... -->
						<dt><a href="#" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="orange">￥120 ~ ￥150</dd>
					</dl>
				</li>
			</ul>
		</div>
		
		<h2 class="h2 h2_l mt"><em title="商家精选">商家精选</em><cite></cite></h2>
		<img src="/res/img/pic/ad200x75.jpg" alt="" />
	</div>
	<div class="r wr">
		<h2 class="h2 h2_r rel"><samp></samp><em title="热卖推荐">&nbsp;&nbsp;&nbsp;热卖推荐</em></h2>
		<div class="box bg_white">
			<ul class="uls i_150x150 x4_150x150">
				<li>
					<a href="productDetail.jsp" title="富一代" target="_blank" class="pic"><img src="	/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="h40">依琦莲2014瑜伽服套装新！</dd>
						<dd class="orange">￥120 ~ ￥150</dd>
						<dd><a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a></dd>
					</dl>
				</li>
				<li>
					<a href="productDetail.jsp" title="富一代" target="_blank" class="pic"><img src="	/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="h40">依琦莲2014瑜伽服套装新！</dd>
						<dd class="orange">￥120 ~ ￥150</dd>
						<dd><a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a></dd>
					</dl>
				</li>
				<li>
					<a href="productDetail.jsp" title="富一代" target="_blank" class="pic"><img src="	/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="h40">依琦莲2014瑜伽服套装新！</dd>
						<dd class="orange">￥120 ~ ￥150</dd>
						<dd><a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a></dd>
					</dl>
				</li>
				<li>
					<a href="productDetail.jsp" title="富一代" target="_blank" class="pic"><img src="	/res/img/pic/ppp.jpg" alt="依琦莲2014瑜伽服套装新" /></a>
					<dl>
						<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新" target="_blank">依琦莲2014瑜伽服套装新</a></dt>
						<dd class="h40">依琦莲2014瑜伽服套装新！</dd>
						<dd class="orange">￥120 ~ ￥150</dd>
						<dd><a href="productDetail.jsp" title="立即抢购" class="inb btn70x21 mr">立即抢购</a></dd>
					</dl>
				</li>
			</ul>
		</div>

		<h2 class="h2 h2_filter mt"><em title="商品筛选">商品筛选</em><cite><a href="javascript:void(0);" id="filterRest" title="重置筛选条件">重置筛选条件</a></cite></h2>
			<ul class="uls filter">
				<li><label>已选条件：</label>
				<p class="sel">
					<a href="javascript:void(0);">
					<em>品牌：</em>依琦莲
					<cite title="关闭此筛选条件">X</cite></a>
				</p>
				</li>
				<li><b>品牌：</b><p>
					<a href="javascript:void(0);" title="不限" class="here">不限</a>
					<a href="/product/list/display.shtml?brandId=1&brandName=依琦莲&typeName=${typeName }&typeId=${typeId}" title="依琦莲">依琦莲</a>
					<a href="javascript:void(0);" title="凯速（KANSOON）">凯速（KANSOON）</a>
					<a href="javascript:void(0);" title="梵歌纳（vangona）">梵歌纳（vangona）</a>
					<a href="javascript:void(0);" title="菩媞">菩媞</a>
					<a href="javascript:void(0);" title="伽美斯（Jamars）">伽美斯（Jamars）</a>
					<a href="javascript:void(0);" title="金啦啦">金啦啦</a>
					<a href="javascript:void(0);" title="伊朵莲">伊朵莲</a>
					<a href="javascript:void(0);" title="喜悦瑜伽">喜悦瑜伽</a>
					<a href="javascript:void(0);" title="路伊梵（LEFAN）">路伊梵（LEFAN）</a>
					<a href="javascript:void(0);" title="来尔瑜伽（LaiErYoGA）">来尔瑜伽（LaiErYoGA）</a>
				</p></li>
				<li><b>价格：</b><p>
					<a href="javascript:void(0);" title="不限" class="here">不限</a>
					<a href="javascript:void(0);" title="1-99">0-79</a>
					<a href="javascript:void(0);" title="100-199">80-199</a>
					<a href="javascript:void(0);" title="200-499">200-299</a>
					<a href="javascript:void(0);" title="200-499">300-499</a>
					<a href="javascript:void(0);" title="200-499">500-599</a>
					<a href="javascript:void(0);" title="200-499">600以上</a>
				</p></li>
				<li><b>类型：</b><p>
					<a href="javascript:void(0);" title="不限" class="here">不限</a>
					<a href="/product/list/display.shtml?typeId=2&brandId=${brandId }&brandName=${brandName}&typeName=瑜伽服" title="瑜伽服">瑜伽服</a>
					<a href="javascript:void(0);" title="瑜伽铺巾">瑜伽铺巾</a>
					<a href="javascript:void(0);" title="瑜伽垫">瑜伽垫</a>
					<a href="javascript:void(0);" title="舞蹈鞋服">舞蹈鞋服</a>
					<a href="javascript:void(0);" title="瑜伽辅助">瑜伽辅助</a>
				</p></li>
				<li><b>材质：</b><p>
					<span><a href="javascript:void(0);" title="不限" class="here">不限</a></span>
					<span><a href="javascript:void(0);" title="环保人棉">环保人棉</a></span>
					<span><a href="javascript:void(0);" title="莫代尔">莫代尔</a></span>
					<span><a href="javascript:void(0);" title="莫代尔">莫代尔</a></span>
					<span><a href="javascript:void(0);" title="莫代尔">莫代尔</a></span>
					<span><a href="javascript:void(0);" title="莫代尔">莫代尔</a></span>
				</p></li>

				<li><b>适用人群：</b><p>
					<a href="javascript:void(0);" title="不限" class="here">不限</a>
					<a href="javascript:void(0);" title="男士">男士</a>
					<a href="javascript:void(0);" title="女士">女士</a>
					<a href="javascript:void(0);" title="儿童">儿童</a>
					<a href="javascript:void(0);" title="中性">中性</a>
				</p></li>
			</ul>
			<div class="sort_type">
				<a href="javascript:void(0);" title="销量" class="sales">销量</a>
				<a href="javascript:void(0);" title="价格" class="price">价格</a>
				<a href="javascript:void(0);" title="上架时间" class="time">上架时间</a>
			</div>
			<div class="mt ofc">
				<ul class="uls i_150x150 x4_150x150b">
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
					<li>
						<a href="productDetail.jsp" title="瑜伽服" target="_blank" class="pic"><img src="/res/img/pic/ppp.jpg" alt="瑜伽服" /></a>
						<dl>
							<!-- dt 10个文字+... -->
							<dt><a href="productDetail.jsp" title="依琦莲2014瑜伽服套装新款" target="_blank">依琦莲2014瑜伽服套装新款</a></dt>
							<!-- dt 25个文字+... -->
							<dd class="h40">依琦莲2014瑜伽服套装新款</dd>
							<dd class="orange">￥128.00</dd>
							<dd>北京有货</dd>
							<dd><a href="#" title="加入购物车" class="inb btn70x21 mr">加入购物车</a></dd>
						</dl>
						<img src="/res/img/pic/hot.gif" alt="热门" class="type" />
					</li>
				</ul>
			<div class="page pb15">
				<span class="r inb_a page_b">
					<span id="previousNo" class="inb" title="上一页"><samp>&lt;&lt;</samp>上一页</span><a href="javascript:void(0);" id="previous" title="上一页" style="display:none"><samp>&lt;&lt;</samp>上一页</a><span title="第1页" class="inb current">1</span><!--a href="#" title="第1页">1</a--><a href="#" title="第2页">2</a><a href="#" title="第3页">3</a><a href="#" title="第4页">4</a><a href="#" title="第5页">5</a><span class="break">...</span><a href="#" title="第16页">16</a><span id="nextNo" class="inb" title="下一页" style="display:none">下一页<samp>&gt;&gt;</samp></span><a href="javascript:void(0);" id="next" title="下一页">下一页<samp>&gt;&gt;</samp></a>共<var id="pageTotal" class="orange">0</var>页 到第<input type="text" id="number" name="number" class="txts" size="3" />页 <input type="button" id="skip" class="hand btn60x20" value='确定' />
				</span>
			</div>
	</div>
</div>
</div>
<div class="mode">
	<div class="tl"></div><div class="tr"></div>
	<ul class="uls">
		<li class="first">
			<span class="guide"></span>
			<dl>
			<dt title="购物指南">购物指南</dt>
			<dd><a href="#" title="购物流程">购物流程</a></dd>
			<dd><a href="#" title="购物流程">购物流程</a></dd>
			<dd><a href="#" target="_blank" title="联系客服">联系客服</a></dd>
			<dd><a href="#" target="_blank" title="联系客服">联系客服</a></dd>
			</dl>
		</li>
		<li>
			<span class="way"></span>
			<dl>
			<dt title="支付方式">支付方式</dt>
			<dd><a href="#" title="货到付款">货到付款</a></dd>
			<dd><a href="#" title="在线支付">在线支付</a></dd>
			<dd><a href="#" title="分期付款">分期付款</a></dd>
			<dd><a href="#" title="分期付款">分期付款</a></dd>
			</dl>
		</li>
		<li>
			<span class="help"></span>
			<dl>
			<dt title="配送方式">配送方式</dt>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			<dd><a href="#" title="上门自提">上门自提</a></dd>
			</dl>
		</li>
		<li>
			<span class="service"></span>
			<dl>
			<dt title="售后服务">售后服务</dt>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			<dd><a href="#" target="_blank" title="售后策略">售后策略</a></dd>
			</dl>
		</li>
		<li>
			<span class="problem"></span>
			<dl>
			<dt title="特色服务">特色服务</dt>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			<dd><a href="#" target="_blank" title="夺宝岛">夺宝岛</a></dd>
			</dl>
		</li>
	</ul>
</div>
</body>
</html>