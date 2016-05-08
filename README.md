# babasport 
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
 - 分布式缓存：一处缓存，多地存取
 - Oscached：页面缓存

----------------------------

1. Oscached页面缓存技术

	Map<K,V>:	K:url,V:页面html

2. 库存管理

3. 商品详情页面 **sku联动**

 - 在页面隐藏list集合 
 - 对象bean.contains()比较的是:
	对象bean重写的equals方法
 - **sku JQuery联动**
