
-- ----------------------------
-- Table structure for `bbs_addr`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_addr`;
CREATE TABLE `bbs_addr` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `buyer_id` varchar(40) NOT NULL COMMENT '用户ID',
  `name` varchar(80) NOT NULL COMMENT '收货人',
  `city` varchar(255) DEFAULT NULL,
  `addr` varchar(400) NOT NULL COMMENT '收货地址',
  `phone` varchar(60) NOT NULL COMMENT '手机号或是固定电话号',
  `is_def` int(1) NOT NULL COMMENT '是否默认',
  PRIMARY KEY (`id`),
  KEY `buyer_id` (`buyer_id`),
  CONSTRAINT `bbs_addr_ibfk_1` FOREIGN KEY (`buyer_id`) REFERENCES `bbs_buyer` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='收货地址';


-- ----------------------------
-- Table structure for `bbs_brand`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_brand`;
CREATE TABLE `bbs_brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(40) NOT NULL COMMENT '名称',
  `description` varchar(80) DEFAULT NULL COMMENT '描述',
  `img_url` varchar(80) DEFAULT NULL COMMENT '图片Url',
  `web_site` varchar(80) DEFAULT NULL COMMENT '品牌网址',
  `sort` int(11) DEFAULT NULL COMMENT '排序:最大最排前',
  `is_display` tinyint(1) DEFAULT NULL COMMENT '是否可见 1:可见 0:不可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='品牌';



-- ----------------------------
-- Table structure for `bbs_buyer`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_buyer`;
CREATE TABLE `bbs_buyer` (
  `username` varchar(18) NOT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `gender` varchar(8) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `real_name` varchar(8) DEFAULT NULL COMMENT '真实名字',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `province` varchar(11) DEFAULT NULL COMMENT '省ID',
  `city` varchar(11) DEFAULT NULL COMMENT '市ID',
  `town` varchar(11) DEFAULT NULL COMMENT '县ID',
  `addr` varchar(255) DEFAULT NULL COMMENT '地址',
  `is_del` tinyint(1) DEFAULT NULL COMMENT '是否已删除:1:未,0:删除了',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购买者';


-- ----------------------------
-- Table structure for `bbs_city`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_city`;
CREATE TABLE `bbs_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(6) NOT NULL COMMENT '城市编码',
  `name` varchar(40) NOT NULL COMMENT '城市名称',
  `province` char(6) NOT NULL COMMENT '所属省份编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8 COMMENT='城市信息表';


-- ----------------------------
-- Table structure for `bbs_color`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_color`;
CREATE TABLE `bbs_color` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父ID为色系',
  `img_url` varchar(50) DEFAULT NULL COMMENT '颜色对应的衣服小图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='颜色大全';


-- ----------------------------
-- Table structure for `bbs_detail`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_detail`;
CREATE TABLE `bbs_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `product_no` varchar(255) DEFAULT NULL COMMENT '商品编号',
  `product_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `color` varchar(11) NOT NULL COMMENT ' 颜色名称',
  `size` varchar(11) NOT NULL COMMENT '尺码',
  `sku_price` double NOT NULL COMMENT '商品销售价',
  `amount` int(11) NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`),
  KEY `fk_order_id` (`order_id`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `bbs_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='订单详情';



-- ----------------------------
-- Table structure for `bbs_employee`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_employee`;
CREATE TABLE `bbs_employee` (
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `degree` varchar(10) DEFAULT NULL COMMENT '学历',
  `email` varchar(40) DEFAULT NULL COMMENT '邮箱',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别 ',
  `img_url` varchar(41) DEFAULT NULL COMMENT '图片(头像)',
  `phone` varchar(18) DEFAULT NULL COMMENT '手机',
  `real_name` varchar(8) DEFAULT NULL COMMENT '真实名字',
  `school` varchar(20) DEFAULT NULL COMMENT '毕业学校',
  `is_del` tinyint(1) NOT NULL COMMENT '是否删除 1:未删除 0:删除',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';


-- ----------------------------
-- Table structure for `bbs_feature`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_feature`;
CREATE TABLE `bbs_feature` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `value` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL COMMENT '前台排序',
  `is_del` tinyint(1) DEFAULT NULL COMMENT '是否废弃:1:未废弃,0:废弃了',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='属性表';


-- ----------------------------
-- Table structure for `bbs_img`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_img`;
CREATE TABLE `bbs_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `url` varchar(80) DEFAULT NULL COMMENT '图片URL',
  `is_def` tinyint(1) DEFAULT NULL COMMENT '是否默认:0否 1:是',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `bbs_img_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `bbs_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8 COMMENT='图片';


-- ----------------------------
-- Table structure for `bbs_order`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_order`;
CREATE TABLE `bbs_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `oid` varchar(36) NOT NULL COMMENT '订单号',
  `deliver_fee` decimal(10,2) NOT NULL COMMENT '运费',
  `payable_fee` double NOT NULL COMMENT '应付金额',
  `total_price` double NOT NULL COMMENT '订单金额',
  `payment_way` tinyint(1) NOT NULL COMMENT '支付方式 0:到付 1:在线 2:邮局 3:公司转帐',
  `payment_cash` tinyint(1) DEFAULT NULL COMMENT '货到付款方式.1现金,2POS刷卡',
  `delivery` tinyint(1) DEFAULT NULL COMMENT '送货时间',
  `isConfirm` tinyint(1) DEFAULT NULL COMMENT '是否电话确认 1:是  0: 否',
  `is_paiy` tinyint(1) NOT NULL COMMENT '支付状态 :0到付1待付款,2已付款,3待退款,4退款成功,5退款失败',
  `state` tinyint(1) NOT NULL COMMENT '订单状态 0:提交订单 1:仓库配货 2:商品出库 3:等待收货 4:完成 5待退货 6已退货',
  `create_date` datetime NOT NULL COMMENT '订单生成时间',
  `note` varchar(100) DEFAULT NULL COMMENT '附言',
  `buyer_id` varchar(18) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`),
  KEY `buyer_id` (`buyer_id`),
  CONSTRAINT `bbs_order_ibfk_1` FOREIGN KEY (`buyer_id`) REFERENCES `bbs_buyer` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Table structure for `bbs_product`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_product`;
CREATE TABLE `bbs_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `no` varchar(30) DEFAULT NULL COMMENT '商品编号',
  `name` varchar(255) NOT NULL COMMENT '商品名称',
  `weight` double(11,0) DEFAULT NULL COMMENT '重量 单位:克',
  `is_new` tinyint(1) DEFAULT NULL COMMENT '是否新品:0:旧品,1:新品',
  `is_hot` tinyint(1) DEFAULT NULL COMMENT '是否热销:0,否 1:是',
  `is_commend` tinyint(1) DEFAULT NULL COMMENT '推荐 1推荐 0 不推荐',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `create_user_id` varchar(255) DEFAULT NULL COMMENT '添加人ID',
  `check_time` datetime DEFAULT NULL COMMENT '审核时间',
  `check_user_id` varchar(255) DEFAULT NULL COMMENT '审核人ID',
  `is_show` tinyint(1) DEFAULT NULL COMMENT '上下架:0否 1是',
  `is_del` tinyint(1) DEFAULT NULL COMMENT '是否删除:0删除,1,没删除',
  `type_id` int(11) DEFAULT NULL COMMENT '类型ID',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌ID',
  `keywords` varchar(255) DEFAULT NULL COMMENT '检索关键词',
  `sales` int(11) DEFAULT NULL COMMENT '销量',
  `description` longtext COMMENT '商品描述',
  `package_list` longtext COMMENT '包装清单',
  `feature` varchar(255) DEFAULT NULL COMMENT '商品属性集',
  `color` varchar(255) DEFAULT NULL COMMENT '颜色集',
  `size` varchar(255) DEFAULT NULL COMMENT '尺寸集',
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `bbs_product_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `bbs_type` (`id`),
  CONSTRAINT `bbs_product_ibfk_2` FOREIGN KEY (`brand_id`) REFERENCES `bbs_brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=276 DEFAULT CHARSET=utf8 COMMENT='商品';


-- ----------------------------
-- Table structure for `bbs_province`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_province`;
CREATE TABLE `bbs_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(6) NOT NULL COMMENT '省份编码',
  `name` varchar(40) NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='省份信息表';


-- ----------------------------
-- Table structure for `bbs_sku`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_sku`;
CREATE TABLE `bbs_sku` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` int(11) NOT NULL COMMENT '商品ID',
  `color_id` int(11) DEFAULT NULL COMMENT '颜色ID',
  `size` varchar(5) DEFAULT NULL COMMENT '尺码',
  `delive_fee` double DEFAULT NULL COMMENT '运费 默认10元',
  `sku_price` double(20,2) NOT NULL COMMENT '售价',
  `stock_inventory` int(5) NOT NULL COMMENT '库存',
  `sku_upper_limit` int(5) DEFAULT NULL COMMENT '购买限制',
  `location` varchar(80) DEFAULT NULL COMMENT '仓库位置:货架号',
  `sku_img` varchar(80) DEFAULT NULL COMMENT 'SKU图片  精确到颜色及尺码对应的图片',
  `sku_sort` int(5) DEFAULT NULL COMMENT '前台显示排序',
  `sku_name` varchar(500) DEFAULT NULL COMMENT 'SKU名称',
  `market_price` double(20,2) DEFAULT NULL COMMENT '市场价',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_user_id` varchar(255) DEFAULT NULL,
  `update_user_id` varchar(255) DEFAULT NULL,
  `last_status` int(1) DEFAULT NULL COMMENT '0,历史 1最新',
  `sku_type` int(1) DEFAULT NULL COMMENT '0:赠品,1普通',
  `sales` int(10) DEFAULT NULL COMMENT '销量',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  KEY `color_id` (`color_id`),
  CONSTRAINT `bbs_sku_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `bbs_product` (`id`),
  CONSTRAINT `bbs_sku_ibfk_2` FOREIGN KEY (`color_id`) REFERENCES `bbs_color` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=516 DEFAULT CHARSET=utf8 COMMENT='最小销售单元';


-- ----------------------------
-- Table structure for `bbs_town`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_town`;
CREATE TABLE `bbs_town` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` char(6) NOT NULL COMMENT '区县编码',
  `name` varchar(40) NOT NULL COMMENT '区县名称',
  `city` char(6) NOT NULL COMMENT '所属城市编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3145 DEFAULT CHARSET=utf8 COMMENT='区县信息表';



-- ----------------------------
-- Table structure for `bbs_type`
-- ----------------------------
DROP TABLE IF EXISTS `bbs_type`;
CREATE TABLE `bbs_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(36) NOT NULL COMMENT '名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父ID',
  `note` varchar(200) DEFAULT NULL COMMENT '备注,用于google搜索页面描述',
  `is_display` tinyint(1) NOT NULL COMMENT '是否可见 1:可见 0:不可见',
  PRIMARY KEY (`id`),
  KEY `FKA8168A929B5A332` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='商品类型';


