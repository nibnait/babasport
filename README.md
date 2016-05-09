# babasport 整理每天学到的技术点
新巴巴运动网（10天）  
这是一个 基于maven的ssm整合项目。  
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
 - mybatis 标签：
```useGeneratedKeys="true" keyProperty="id"```：返回 id主键
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

3. 密码加密：

加盐+MD5+Hexencode

```


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

2. 购物车 面向对象编程
