# babasport 整理每天学到的技术点
新巴巴运动网（10天）  
这是一个 基于maven的SSM整合 demo项目。  
开发环境：  
	 - IntelliJ IDEA 15.0.1  
	 - JDK 1.8.0——05   
	 - tomcat 7.0.69



[TOC]


##day01 系统框架搭建
1. 商品列表页的优化方案：  
 - 1. 整合Lucene+Solr 建立索引，进行全文检索  
 - 2. 页面缓存（Os）  
 - 3. 分布式缓存（全网站）  
 - 4. 高并发（80%）  

2. 商品详情页（单品页）：  
 - 页面静态化技术 Freemarker

## day02 品牌模块开发
1. 查询： 条件+分页
2. 添加：异步上传图片，图片放在另一台服务器
3. 修改：信息回显
4. 删除 删除多个（查询列表页面）
	 不用<hidden />标签 


 - get请求中文乱码：
	 - 1. 该服务器配置文件（tomcat8之后 就不用担心此问题了，因为）
	 - 2. 配置过滤器，将请求重编码: new String("".getByte("iso-8859-1"), utf8);  

 - 异步上传技术： jersey put提交 2号服务器总是返回409错误。。。  
```UniformInterfaceException：returned a response status of 409 Conflict```
（！BUG）失败，只能将图片上传到本地服务器上了  
文件路径问题：值得注意![](https://github.com/nibnait/babasport/blob/master/%E6%8A%80%E6%9C%AF%E7%82%B9%E7%AC%94%E8%AE%B0%E9%99%84%E4%BB%B6/README-1.png?raw=true)

 - 由于mybatis.xml无法接收Serializable数组，所以 deleteById,和deleteByIds只能分开写了

## day03 商品管理模块
1. 商品管理的添加：
 - 用```MultipartHttpServletRequest```接收图片

 - 往商品表添加数据的时候，注入的是Service 为了之后做分布式缓存的时候，刷新数据。


2. 商品前台列表页面：
	- （品牌、类型、颜色、材质）数据字典的加载（开启二级缓存），写个commonUtils类
	- “已选条件”、商品列表：采用ajax动态加载【看一下京东是不是这么做的？】
	- url字符串的长度限制：
		- 火狐：7000~
		- orthers：6000~


## day04 前台商品列表页面+商品详情页面
 - 一级缓存：一次Session中，随着这一次Dao Session的消失而消失
 - 二级缓存：事物级别， 在全局（定时刷新）
 - 分布式缓存：一处缓存，多地存取【但是同步慢（设置时间）】
 - Oscached：页面缓存

----------------------------

1. Oscached页面缓存技术

	Map<K,V>:	K:url,V:页面html

2. 库存管理
3. 商品的删除（多表，删图片时，要先删服务器中的文件，再删数据库中的数据）
4. 商品的修改（不做了）

5. 商品详情页面 **sku联动**

 - 在页面隐藏list集合 
 - 对象bean.contains()比较的是:
	对象bean重写的equals方法


6. 页面静态化，使用[FreeMarker]()技术 生成商品详情页（完成上架）

	 - 通过 implements **ServletContextAware**类，重写setServletContext(ServletContext servletContext)方法，通过**servletContext.getRealPath(name);**即可获得服务器下的任意目录的实际地址。


## day05 用户模块
1. Session共享 面向接口编程
>
 - ```HttpSession session = request.getSession();```//默认为true，如果request中有Session(用Cookie中的JESSIONID在request域中找)，则返回此Session，如果没有这创建一个新的Session返回。
 - ```HttpSession session = request.getSession(false);```//request中有则返回Session，无则返回null

----
>
 - ```request.getSession().getId();```//有则返回此request中的JESSIONID,无则创建个新的Session返回其id
 - ```request.getRequestSessionId();```//返回url中的JSESSIONID


2. ${param.returnUrl}:自己从url中获取对应的参数
3. 关于枚举： 
	1. ${buyer.gender.name}	中文
	2. ${buyer.gender}	对应的英文

```
<label for="gender">性　　别：</label> 
<span class="word">
	<input type="radio" name="gender" value="SECRECY" <c:if test="${buyer.gender == 'SECRECY' }">checked="checked"</c:if>/>保密
	<input type="radio" name="gender" value="MAN" <c:if test="${buyer.gender == 'MAN' }">checked="checked"</c:if>/>男
	<input type="radio" name="gender" value="WOMAN" <c:if test="${buyer.gender == 'WOMAN' }">checked="checked"</c:if>/>女
</span>
```

3. 密码加密：

加盐+MD5+Hexencode

```
//加盐
String password = pwd + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
//MD5加密
byte[] digest = MessageDigest.getInstance("MD5").digest(password.getBytes());
//十六进制加密
char[] encodeHex = Hex.encodeHex(digest);
```

4. springmvc拦截器

中央处理器(DispatcherServlet)**<拦截器>**，中央调度各个器
	 处理器映射器（根据Url， 找对应的handler）
	 处理器适配器（执行handler）

	 视图解析器（根据modelMap,填充页面（进行页面渲染））


5. 
>http://localhost:8080/buyer/index.shtml
>
>```request.getURI()```：/buyer/index.shtml  
>```request.getURL()```：http://localhost:8080/buyer/index.shtml

## day06 购物车模块(面向对象编程)
//判断Cookie中有没有购物车  
//如果Cookie中还没有，则new一个BuyCart  
 if (skuId != null) {
            //往购物车中添加商品  
//将购物车装满-->model.addAttribute("buyCart", buyCart);



1. 存放位置：Cookie

2. 使用sprigmvc提供的ObjectMapper进行  
	ObjectMapper om = new ObjectMapper();
	om.setSerializationInclusion(Inclusion.NON_NULL);  
	StringWriter str = new StringWriter();
	 - **对象转Json**：om.writeValue(str,buyer);
	 - **Json转对象**：om.readValue(str.toString(),Buyer.class);
>ObjectMapper要转化的为json对象的java对象必须要是标准的java对象（有声明，有set、get方法）。
>否则 请使用@JsonIgnore注解，不让ObjectMapper转化此属性。

3. 对象和List集合的equals比较，执行remove方法，
	对象都必须重写equals和hashCode方法，否则比较的就是地址了。  


4. Controller层：
5. Service层：整合多个Dao对象，处理数据。事物（Transactional）相关。

## day07 订单模块
1. 结算按钮（就不写那么多ajax校验了，直接把所有逻辑写后台了）  
//1:判断是否登陆 --> 否则登陆  
//2:判断购物车中是否有商品 --> 去首页(redirect:/shopping/buyCart.shtml)(用户点完结算，再返回的时候，看到的浏览器缓存，误会)  
//3:判断购物车中的各个购物项是否还有库存 --> 如果库存小于购买数量，直接删除此商品。  
//4:再判断购物车是否为空    
//5:收货地址加载

 - fn:length()
 - fn:substring(str,startIndex,endIndex)

2. 提交订单(保存Order、Detail 二张表)  
mybatis 自动生成主键标签：
	- ```useGeneratedKeys="true" keyProperty="id"```：返回 id主键
	- ```<selectKey order="@1" resultType="@2" KeyProperty="id">select LAST_INSERT_ID()</selectKey>```
 		- @1:BEFORE(Oracle数据库先生成ID，后生成数据)
 		- @1:AFTER(MySQL先生成数据，后生成ID)
 		- @2:此表主键的类型

3. 后台-订单列表
4. 后天-订单查看



## ？？？（一些逻辑上的问题）
 - 如果用户删除了订单
 - 如果商家删除了商品，然而用户已经下单。
