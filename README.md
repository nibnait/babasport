# babasport 
新巴巴运动网（10天）  
这是一个 基于maven的ssm整合项目。  
开发环境：  
	 - IntelliJ IDEA 15.0.1  
	 - JDK 1.7.0_80  
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

3. 