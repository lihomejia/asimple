/*
Navicat MySQL Data Transfer

Source Server         : 221
Source Server Version : 50532
Source Host           : 192.168.7.1:3306
Source Database       : gap

Target Server Type    : MYSQL
Target Server Version : 50532
File Encoding         : 65001

Date: 2013-08-29 17:06:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_comp`
-- ----------------------------
DROP TABLE IF EXISTS `t_comp`;
CREATE TABLE `t_comp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `content` text,
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comp
-- ----------------------------
INSERT INTO `t_comp` VALUES ('1', null, '0', '2013-05-15 09:13:23', null, '0', '0', '<p>\r\n	&nbsp;\r\n</p>\r\n<p class=\"p0\" style=\"text-indent:28pt;\">\r\n	<span style=\"color:#2C2C2C;font-family:&quot;宋体&quot;;font-size:14pt;\">&nbsp;</span><span style=\"color:#2C2C2C;font-family:&quot;宋体&quot;;font-size:14pt;\">山西祁县果品</span><span style=\"font-family:&quot;宋体&quot;;font-size:14pt;\">有限公司成立于<span>1998</span><span>年</span><span>5</span><span>月</span><span>26</span><span>日，由</span></span><span style=\"font-family:&quot;宋体&quot;;font-size:14pt;\">。。。</span><span style=\"font-family:&quot;宋体&quot;;font-size:14pt;\">共同投资组建而成，注册总资本<span>21</span><span>万美元，注册地址：</span></span><span style=\"font-family:&quot;宋体&quot;;font-size:14pt;\">。。。</span><span style=\"font-family:&quot;宋体&quot;;font-size:14pt;\">工业园区。公司主要从事农副产品的精品加工出口业务，产品主要销往日本、澳大利亚、意大利、新西兰、菲律宾、埃及、非洲等国家和地区，年出口创汇能力达到<span>1500</span><span>万美元以上。</span><span>2006</span><span>年</span><span>1</span><span>月</span><span>24</span><span>日通过获得</span><span>ISO9001</span><span>质量管理体系认证证书，同年获得食品安全管理体系认证证书（</span><span>HACCP</span><span>）。公司多年形成了稳定的国际销售客户，产品出口量逐年增加，经过</span><span>10</span><span>多年&nbsp;努力奋斗，资金的不断积累，目前形成了冷库（储存量</span><span>6000</span><span>吨），加工车间（</span><span>200</span></span><span style=\"font-family:&quot;宋体&quot;;font-size:14pt;\">0㎡），办公楼等设施比较齐全的固定资产达1700万元的综合加工厂，深受国内外客户的一致好评。</span><span style=\"font-family:&quot;宋体&quot;;font-size:14pt;\"></span>\r\n</p>', '2013-08-29 08:24:05', '2');
INSERT INTO `t_comp` VALUES ('2', null, '0', null, null, '0', '0', '11', '2013-08-29 07:45:01', '2');
INSERT INTO `t_comp` VALUES ('3', null, '0', null, null, '0', '0', '1', '2013-08-29 07:44:55', '2');
INSERT INTO `t_comp` VALUES ('4', null, '0', null, null, '0', '0', '4', '2013-08-29 07:46:49', '2');
INSERT INTO `t_comp` VALUES ('5', null, '0', null, null, '0', '0', '5', '2013-08-29 07:46:43', '2');

-- ----------------------------
-- Table structure for `t_dict`
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES ('1', null, '0', '2013-06-06 20:40:48', '', '3', '0', '2013-06-06 20:40:48', '3', '水稻A', 'CPLB');
INSERT INTO `t_dict` VALUES ('2', null, '0', '2013-06-06 20:40:57', '', '3', '0', '2013-06-06 20:40:57', '3', '水稻B', 'CPLB');
INSERT INTO `t_dict` VALUES ('3', null, '0', '2013-06-06 20:41:03', '', '3', '0', '2013-06-06 20:41:03', '3', '玉米A', 'CPLB');
INSERT INTO `t_dict` VALUES ('4', null, '0', '2013-06-06 20:41:09', '', '3', '0', '2013-06-06 20:41:09', '3', '玉米B', 'CPLB');
INSERT INTO `t_dict` VALUES ('5', null, '0', '2013-06-06 20:41:15', '', '3', '0', '2013-06-06 20:41:15', '3', '小麦A', 'CPLB');
INSERT INTO `t_dict` VALUES ('6', null, '0', '2013-06-06 20:41:20', '', '3', '0', '2013-06-06 20:41:20', '3', '小麦B', 'CPLB');
INSERT INTO `t_dict` VALUES ('7', null, '0', '2013-06-06 20:41:26', '', '3', '0', '2013-06-06 20:41:26', '3', '高粱A', 'CPLB');
INSERT INTO `t_dict` VALUES ('8', null, '0', '2013-06-06 20:41:31', '', '3', '0', '2013-06-06 20:41:31', '3', '高粱B', 'CPLB');
INSERT INTO `t_dict` VALUES ('9', null, '0', '2013-06-06 20:41:49', '', '3', '0', '2013-06-06 20:41:49', '3', '插秧机', 'JXLB');
INSERT INTO `t_dict` VALUES ('10', null, '0', '2013-06-06 20:41:56', '', '3', '0', '2013-06-06 20:41:56', '3', '收割机', 'JXLB');
INSERT INTO `t_dict` VALUES ('11', null, '0', '2013-06-06 20:42:05', '', '3', '0', '2013-06-06 20:42:05', '3', '播种机', 'JXLB');
INSERT INTO `t_dict` VALUES ('15', null, '0', '2013-06-06 20:42:56', '', '3', '0', '2013-06-06 20:42:56', '3', '纯人工', 'SGFF');
INSERT INTO `t_dict` VALUES ('16', null, '0', '2013-06-06 20:43:04', '', '3', '0', '2013-06-06 20:43:04', '3', '半自动化', 'SGFF');
INSERT INTO `t_dict` VALUES ('17', null, '0', '2013-06-06 20:43:12', '', '3', '0', '2013-06-06 20:43:12', '3', '全自动化', 'SGFF');
INSERT INTO `t_dict` VALUES ('18', null, '0', '2013-06-06 20:48:51', '', '3', '0', '2013-06-06 20:48:51', '3', '方法1', 'SYFF');
INSERT INTO `t_dict` VALUES ('19', null, '0', '2013-06-06 20:48:57', '', '3', '0', '2013-06-06 20:48:57', '3', '方法2', 'SYFF');
INSERT INTO `t_dict` VALUES ('20', null, '0', '2013-06-06 20:49:05', '', '3', '0', '2013-06-06 20:49:05', '3', '局部', 'GGFS');
INSERT INTO `t_dict` VALUES ('21', null, '0', '2013-06-06 20:49:16', '', '3', '0', '2013-06-06 20:49:16', '3', '全', 'GGFS');
INSERT INTO `t_dict` VALUES ('22', '2013-08-29 08:44:26', '2', '2013-08-29 08:44:20', '', '2', '2', '2013-08-29 08:44:20', '2', '茶叶A', 'CPLB');

-- ----------------------------
-- Table structure for `t_disinfectant_instock`
-- ----------------------------
DROP TABLE IF EXISTS `t_disinfectant_instock`;
CREATE TABLE `t_disinfectant_instock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `element` varchar(60) DEFAULT NULL,
  `expirydate` datetime DEFAULT NULL,
  `indate` datetime DEFAULT NULL,
  `inuser_id` int(11) DEFAULT '0',
  `location` varchar(60) DEFAULT NULL,
  `stock_id` int(11) DEFAULT '0',
  `vendor` varchar(60) DEFAULT NULL,
  `wrap` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_disinfectant_instock
-- ----------------------------

-- ----------------------------
-- Table structure for `t_disinfectant_outstock`
-- ----------------------------
DROP TABLE IF EXISTS `t_disinfectant_outstock`;
CREATE TABLE `t_disinfectant_outstock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `outdate` datetime DEFAULT NULL,
  `outuser_id` int(11) DEFAULT '0',
  `register_id` int(11) DEFAULT '0',
  `stock_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_disinfectant_outstock
-- ----------------------------

-- ----------------------------
-- Table structure for `t_disinfectant_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_disinfectant_resource`;
CREATE TABLE `t_disinfectant_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_disinfectant_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `t_disinfectant_stock`
-- ----------------------------
DROP TABLE IF EXISTS `t_disinfectant_stock`;
CREATE TABLE `t_disinfectant_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_disinfectant_stock
-- ----------------------------

-- ----------------------------
-- Table structure for `t_feed_instock`
-- ----------------------------
DROP TABLE IF EXISTS `t_feed_instock`;
CREATE TABLE `t_feed_instock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `element` varchar(60) DEFAULT NULL,
  `expirydate` datetime DEFAULT NULL,
  `indate` datetime DEFAULT NULL,
  `inuser_id` int(11) DEFAULT '0',
  `location` varchar(60) DEFAULT NULL,
  `stock_id` int(11) DEFAULT '0',
  `vendor` varchar(60) DEFAULT NULL,
  `wrap` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_feed_instock
-- ----------------------------

-- ----------------------------
-- Table structure for `t_feed_outstock`
-- ----------------------------
DROP TABLE IF EXISTS `t_feed_outstock`;
CREATE TABLE `t_feed_outstock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `outdate` datetime DEFAULT NULL,
  `outuser_id` int(11) DEFAULT '0',
  `register_id` int(11) DEFAULT '0',
  `stock_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_feed_outstock
-- ----------------------------

-- ----------------------------
-- Table structure for `t_feed_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_feed_resource`;
CREATE TABLE `t_feed_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_feed_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `t_feed_stock`
-- ----------------------------
DROP TABLE IF EXISTS `t_feed_stock`;
CREATE TABLE `t_feed_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_feed_stock
-- ----------------------------

-- ----------------------------
-- Table structure for `t_grow_farm`
-- ----------------------------
DROP TABLE IF EXISTS `t_grow_farm`;
CREATE TABLE `t_grow_farm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `activitydate` datetime DEFAULT NULL,
  `cell_id` int(11) DEFAULT '0',
  `content` varchar(255) DEFAULT NULL,
  `manager` varchar(60) DEFAULT NULL,
  `persons` int(11) DEFAULT '0',
  `register_id` int(11) DEFAULT '0',
  `scale` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grow_farm
-- ----------------------------
INSERT INTO `t_grow_farm` VALUES ('1', null, '0', '2013-06-06 20:54:28', '', '3', '0', '2013-06-06 20:54:42', '3', '2013-06-02 00:00:00', '0', '除草', '张经理', '1', '1', '1.00');
INSERT INTO `t_grow_farm` VALUES ('2', null, '0', '2013-06-06 20:55:06', '', '3', '0', '2013-06-06 20:55:06', '3', '2013-06-02 00:00:00', '0', '施肥', 'GJIA', '2', '1', '2.00');
INSERT INTO `t_grow_farm` VALUES ('3', '2013-08-29 06:41:38', '2', '2013-08-29 06:41:33', '机械播种，1天完成', '2', '2', '2013-08-29 06:41:33', '2', '2013-08-29 00:00:00', '0', '播种', '王**', '20', '4', '500.00');
INSERT INTO `t_grow_farm` VALUES ('4', null, '0', '2013-08-29 06:41:58', '', '2', '0', '2013-08-29 06:41:58', '2', '2013-08-30 00:00:00', '0', '灌溉', '王', '3', '4', '500.00');
INSERT INTO `t_grow_farm` VALUES ('5', null, '0', '2013-08-29 06:42:20', '', '2', '0', '2013-08-29 06:42:20', '2', '2013-09-12 00:00:00', '0', '除草', '王', '20', '4', '500.00');

-- ----------------------------
-- Table structure for `t_grow_harvest`
-- ----------------------------
DROP TABLE IF EXISTS `t_grow_harvest`;
CREATE TABLE `t_grow_harvest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `method` varchar(60) DEFAULT NULL,
  `operatedate` datetime DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `register_id` int(11) DEFAULT '0',
  `respmanager` varchar(60) DEFAULT NULL,
  `scale` decimal(10,2) DEFAULT '0.00',
  `storage` varchar(60) DEFAULT NULL,
  `storemanager` varchar(60) DEFAULT NULL,
  `yield` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grow_harvest
-- ----------------------------
INSERT INTO `t_grow_harvest` VALUES ('1', '2013-08-29 07:00:17', '2', '2013-08-29 07:00:10', '', '2', '2', '2013-08-29 07:00:10', '2', '20130830', '0', '人工', '2013-08-30 00:00:00', '甜玉米', '4', '王', '500.00', 'A仓库', '李', '25.00');
INSERT INTO `t_grow_harvest` VALUES ('2', null, '0', '2013-08-29 07:00:47', '', '2', '0', '2013-08-29 07:00:47', '2', '20130831', '0', '人', '2013-08-31 00:00:00', '甜玉米', '4', 'B', '100.00', 'B', 'C', '5.00');

-- ----------------------------
-- Table structure for `t_grow_irrigate`
-- ----------------------------
DROP TABLE IF EXISTS `t_grow_irrigate`;
CREATE TABLE `t_grow_irrigate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `area` decimal(10,2) DEFAULT '0.00',
  `cell_id` int(11) DEFAULT '0',
  `date` datetime DEFAULT NULL,
  `manager` varchar(60) DEFAULT NULL,
  `quantum` decimal(10,2) DEFAULT '0.00',
  `register_id` int(11) DEFAULT '0',
  `way` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grow_irrigate
-- ----------------------------
INSERT INTO `t_grow_irrigate` VALUES ('1', null, '0', '2013-06-06 20:55:34', '', '3', '0', '2013-06-06 20:55:34', '3', '23.00', '0', '2013-05-27 00:00:00', 'ag', '2.00', '1', 'a');

-- ----------------------------
-- Table structure for `t_grow_manure`
-- ----------------------------
DROP TABLE IF EXISTS `t_grow_manure`;
CREATE TABLE `t_grow_manure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `isolation` decimal(10,2) DEFAULT '0.00',
  `machinecate` int(11) DEFAULT NULL,
  `method` int(11) DEFAULT NULL,
  `name_id` int(11) DEFAULT '0',
  `reason` varchar(100) DEFAULT NULL,
  `register_id` int(11) DEFAULT '0',
  `stock_id` int(11) DEFAULT '0',
  `tech` varchar(60) DEFAULT NULL,
  `usedate` datetime DEFAULT NULL,
  `useperson` varchar(60) DEFAULT NULL,
  `useqty` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grow_manure
-- ----------------------------
INSERT INTO `t_grow_manure` VALUES ('1', null, '0', '2013-06-06 20:55:54', null, '3', '0', '2013-06-06 20:55:54', '3', '0', '1.00', '9', '18', '1', '2ag', '1', '0', 'gn', '2013-06-04 00:00:00', 'ag', '23.00');
INSERT INTO `t_grow_manure` VALUES ('2', '2013-08-29 06:43:33', '2', '2013-08-29 06:43:28', null, '2', '2', '2013-08-29 06:43:28', '2', '0', '0.00', '11', '18', '1', '基肥', '4', '0', '李', '2013-08-29 00:00:00', '王', '500.00');
INSERT INTO `t_grow_manure` VALUES ('3', null, '0', '2013-08-29 06:44:01', null, '2', '0', '2013-08-29 06:44:01', '2', '0', '0.00', '9', '19', '20', '提供营养', '4', '0', '李', '2013-08-30 00:00:00', '王', '200.00');

-- ----------------------------
-- Table structure for `t_grow_pesticide`
-- ----------------------------
DROP TABLE IF EXISTS `t_grow_pesticide`;
CREATE TABLE `t_grow_pesticide` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `isolation` decimal(10,2) DEFAULT '0.00',
  `machinecate` int(11) DEFAULT NULL,
  `method` int(11) DEFAULT NULL,
  `name_id` int(11) DEFAULT '0',
  `reason` varchar(100) DEFAULT NULL,
  `register_id` int(11) DEFAULT '0',
  `stock_id` int(11) DEFAULT '0',
  `tech` varchar(60) DEFAULT NULL,
  `usedate` datetime DEFAULT NULL,
  `useperson` varchar(60) DEFAULT NULL,
  `useqty` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grow_pesticide
-- ----------------------------

-- ----------------------------
-- Table structure for `t_grow_register`
-- ----------------------------
DROP TABLE IF EXISTS `t_grow_register`;
CREATE TABLE `t_grow_register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `description` varchar(100) DEFAULT NULL,
  `growstatus` int(11) DEFAULT '0',
  `person` varchar(36) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `qrcode` longblob,
  `regdate` datetime DEFAULT NULL,
  `reguser_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grow_register
-- ----------------------------
INSERT INTO `t_grow_register` VALUES ('1', '2013-06-06 20:53:42', '3', '2013-06-06 20:51:26', '早稻', '3', '2', '2013-06-06 20:51:26', '3', '1', '早稻', '2', '张', '1', 0x89504E470D0A1A0A0000000D494844520000008B0000008B0802000000DE7BFDA8000003A24944415478DAEDDA599683300C4451F6BFE9F4027A88AD7A12A6F3F8CC08BE1C64AB7CBD3CCE3E2E87E019425776FCF0BBDFDEFAE35B5BBFBCF25FFC3041975C18558514528815AA9D77ED2243AADA6085AF84A7511855851452A849686B40B74E77AB44E1A35F2B75E12527A3AA90420A9D2944CD9BF1597BADD4D56E2F851452E81F0B85D3EE81153B45A590420A3D54082F1BB5F937EE5A6B860EF45C145248A119A1F0C1ED2BA72778BEA2D0A70A0DA4C5E1447C20BCA1CA6ACB5E1F85145228130A9FA1D4769981A7FC6BF0404E4C2185144284F0010D3F13F637A9C641186E858193420A29D42AD45751C27889CAAA6B30D41DB33E980A29A450B75038A5C69327AA6CE0B760F8EFF5CEA9420A29B42014EED8C39FC5E1D0509B87FA6ED3F54B5648218510A1BED0A536850DBB0C5493971AFD64A5A190420ACD0BE11FBEA5244C56DC243B5748218510217C9B0B9EEB505FC757087D537C851452A843E8909536D5A00CC79ADAD5940C9D420A2984085147D8030D27F46165A27E99FD1D85145208110A27ACD41E1D7C88A99C09DF2BB97EAA0A29A4102284B73EC3A9678DE1D83E48B2B5512185144284A81C3A7CEEE313683C29EF0BECC9AE8F420A29544AC16B1780D786308FA1226A3C1FFAED158514520811EACB86A90E42783EB5AE077E0F15EE60851452A85B089F4953A3D65717A95FDEFA56CB5E1F8514526861B67D6547DF60853D8E0B3AF01E87420A2934231446C26C46D291330DB43690615148218510A15A49A056FE8748F715A464F1A090420AB142D414160F9CFAECA95BB0A9E9AC90420A2142F8463D3C12A6EE98810E6CED54EBFB14145248A105A1B09B89978470D7CE64C083F72FEA099E420A29B420443D9DC36731D5CDEC9B6453A7FAF6330A29A4102214AE90A96D82F89FD67A9703B1FA7A09574821851021EA0C6E295A54647E4BDEBF3D53504821854A42E1927B2024EEEB8A52DD13EAEB0A29A4D08C10B554C657DAB5B0B9D6343921315248218558213CE408E7D6F87C178FD5F1CAA490420A7508850B6CBC12F48D759833CD374D145248A1B1D9765FC4D2D792C033F8BE25C76A82A790420A41196BDFAC142F3FB5B96C78A34C774E1552482148284C68D8E5F4EE131C27EF3B9F7A1D5248218520A1BEB6E6D638E26B782A8C1F687628A490424F170ADFA276FFE0593E5BFC145248A1A70885D35CE4999ED798BE7D45F7D7218514FA30A1DA954C362092681914AAF591374E4621851442850676D284AE78A50C237CEA8E59AD430A29A45049C8E3D843A1D38F2F798BE16FCA73CE0A0000000049454E44AE426082, '2013-06-03 00:00:00', '0');
INSERT INTO `t_grow_register` VALUES ('3', '2013-08-28 03:04:15', '2', '2013-08-28 03:03:54', '测试', '2', '2', '2013-08-28 03:03:54', '2', '3', '测试', '3', 'hans', '3', 0x89504E470D0A1A0A0000000D494844520000008B0000008B0802000000DE7BFDA8000003AE4944415478DAEDDD5172E3300C0451DFFFD2D903645316313D905C6E7D269645F2A5041060EDBE7EBC9E7DBD5C82CF107A65D77FBEF7D7AFAEDC7536F4BF1F71E5AED92C66E34956552185146285F035BAB222B3CFCC461802878F187CA1420A2954123A5AB5D9047A8B75F485E12CC260FC76A80A29A4D03385A8947A16F38E92EC300A1EAD8F420A29F4E9422127F54E3F2A1C841504851452E84385C2ED742F6F0EEBA447C0BD72C36D551F8514FA7A212A2BF5270FEDE0F91385BE5508BFA816F5EC33BD5A2A15A20E56522185142284A837EF2C97C57B2DBD72437862693077851452A82DB4101BF0338ED44944FCF6C11A2AA490428850185A7A393AF54E0F3FBC705448218514DA11A22640755FF0FC1B6FE7F41A570A29A4D08E10F57AEDAD48F8507C5F411DAC5448218540A170B166471BC3F4BD579208E74525E20A29A41028D4DB7BE355C8591E8FD74A288FE36C5B2185148284A8D042BDD3F13F82D02C1CFCF5312BA490428850B8C4E1DCF033D0BDBE0E5E53787BBB420A295412A2DA1E612A1C5610A873906C99E028AC2AA4904288D0660960B3314355197A4593B70F5548218558A1F03178524BB5B1C395A56A13401C52482185A05C2EBC36FB28E108F10244B8E5504821851A42D45679E1F80E5589088F1C51775DCDB6155248A14C282C7DE275C95E05013FD943ADCFFC9C82420A293412EABDF76701095FD95B8E1C0D0A190A29A41022D4DBB15377E17BF885AD0232658514520811A212C4DEEACF32E0B03C4ACD3D99B2420A29D4165AE888504102AF812E24F40A29A4D05D42BD0030FB0C2544D5647B47978E6BDB0A29A4D005A15E37083F4584778C7EA0ABF4CD0A29A4504968D6E4C02BA761145CF8551856DF4E5921851462851656046FCC500795DA35D0D31C5D218514AA0A21DF3E4E4F17AA99E1782869E09C82420A297422D42B5052C1A697D95351879556482185D684D824B25AA0EC35787AF1ECAFA72BA4904288103E6EBCD58D078985443CFC42851452A821D40B3FBD5223D5B9C74FED90D9B6420A2904ED58A9B0418DF2055DE1826E06D1ABB56D85145288CEB6C30A42C839AB56DCD2FC66B3768514520811C2DFF20B95883090500D1E6A3C95FE90420A2994FDBFE0E14B79B355833F22FC7B9DC7218514520812BA25390EDBE1780B9F324B8E0129A490428F12A22A8CD48E7DA1B68B5734AE66DB0A29A4D01D42E1B69C52C46B13BDAAC76D9982420A7DBD50585308DFCE7847F996222F72E4482185146285D8732A3FDCBF718077E5F1EC3FDC332C75C11552E85B85BC1E7B29F4F4EB1FCDBA9CDED7E5EBCE0000000049454E44AE426082, '2013-08-07 00:00:00', '0');
INSERT INTO `t_grow_register` VALUES ('4', '2013-08-29 06:39:48', '2', '2013-08-29 06:39:13', '生产期8月-10月', '2', '2', '2013-08-29 06:39:13', '2', '8', '甜玉米', '1', '王吉谭', '3', null, '2013-08-29 00:00:00', '0');
INSERT INTO `t_grow_register` VALUES ('5', null, '0', '2013-08-29 06:39:42', '', '2', '0', '2013-08-29 06:39:42', '2', '9', '冬小麦', '1', '王吉潭', '6', null, '2013-08-30 00:00:00', '0');

-- ----------------------------
-- Table structure for `t_grow_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_grow_resource`;
CREATE TABLE `t_grow_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `name` varchar(60) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grow_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `t_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_info`;
CREATE TABLE `t_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `content` text,
  `keyword` varchar(250) DEFAULT NULL,
  `title` varchar(250) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_info
-- ----------------------------
INSERT INTO `t_info` VALUES ('1', null, '0', '2013-05-15 00:44:01', 'GGagag', '0', '0', '<p class=\"MsoNormal\" style=\"font-style:normal;font-weight:normal;text-align:-webkit-auto;text-indent:0px;color:#555B6E;font-family:Arial;font-size:12px;background-color:#FFFFFF;\">\r\n	Iframe的更多的属性参考表10.2，引自CSDN论坛。\r\n</p>\r\n<p class=\"af\" style=\"font-style:normal;font-weight:normal;text-align:-webkit-auto;text-indent:0px;color:#555B6E;font-family:Arial;font-size:12px;background-color:#FFFFFF;\">\r\n	表10.2 Iframe属性参考值\r\n</p>\r\n<table class=\"MsoNormalTable\" style=\"border-collapse:collapse;\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\r\n	<tbody>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"af2\">\r\n					属 &nbsp;&nbsp; 性\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"af2\">\r\n					说&nbsp;&nbsp;&nbsp; 明\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					nRight\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的右边距宽度\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					margin-top marginTop\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的上边距宽度\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					overflow-x overflowX\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取当内容超出对象宽度时如何管理对象内容\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					overflow-y overflowY\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取当内容超出对象高度时如何管理对象内容\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					pixelBottom\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的下方位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					pixelHeight\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的高度\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					pixelLeft\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的左侧位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					pixelRight\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的右侧位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					pixelTop\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的上方位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					pixelWidth\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的宽度\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					posBottom\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取以bottom标签属性指定的单位的对象下方位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					posHeight\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取以height标签属性指定的单位的对象高度\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					position position\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象所使用的定位方式\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					posLeft\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取以left标签属性指定的单位的对象左侧位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n<p style=\"color:#000000;font-family:微软雅黑;font-size:18px;font-style:normal;font-weight:normal;text-indent:0px;\" align=\"right\">\r\n	<br />\r\n</p>\r\n<p style=\"color:#000000;font-family:微软雅黑;font-size:18px;font-style:normal;font-weight:normal;text-indent:0px;\" align=\"right\">\r\n	<br />\r\n</p>\r\n<table class=\"MsoNormalTable\" style=\"border-collapse:collapse;\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\">\r\n	<tbody>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"af2\">\r\n					属&nbsp;&nbsp;&nbsp; 性\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"af2\">\r\n					说&nbsp;&nbsp;&nbsp; 明\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					posRight\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取以right标签属性指定的单位的对象右侧位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					posTop\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取以top标签属性指定的单位的对象上方位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					posWidth\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取以width标签属性指定的单位的对象宽度\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					right right\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象相对于文档层次中下个已定位对象的右边界的位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					float styleFloat\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取文本要绕排到对象的哪一侧\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					text-autospace textAutospace\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取自动留空和文本的窄空间宽度调整\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					top top\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象相对于文档层次中下个定位对象的上边界的位置\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					visibility visibility\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的内容是否显示\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					z-index z-index\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取定位对象的堆叠次序\r\n				</p>\r\n			</td>\r\n		</tr>\r\n		<tr>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"179\">\r\n				<p class=\"ae\" style=\"text-indent:7.2pt;\">\r\n					zoom zoom\r\n				</p>\r\n			</td>\r\n			<td style=\"font-size:12px;\" valign=\"top\" width=\"440\">\r\n				<p class=\"ae\" style=\"text-indent:29.6pt;\">\r\n					设置或获取对象的放大比例\r\n				</p>\r\n			</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n<p>\r\n	<br />\r\n</p>', '关于2013年春节放假安排的...', '关于2013年春节放假安排的...', 'TZGG', '2013-08-27 13:44:59', '2');
INSERT INTO `t_info` VALUES ('2', null, '0', '2013-05-15 23:04:52', null, '0', '0', '关于2013年春节期间证书邮...', '关于2013年春节期间证书邮...', '关于2013年春节期间证书邮...', 'TZGG', null, '0');
INSERT INTO `t_info` VALUES ('3', null, '0', '2013-05-15 23:05:03', null, '0', '0', '财政部 发展改革委关于调整...', '财政部 发展改革委关于调整...', '财政部 发展改革委关于调整...', 'TZGG', null, '0');
INSERT INTO `t_info` VALUES ('4', null, '0', '2013-05-15 23:05:13', null, '0', '0', '2013年有机产品认证获证企...', '2013年有机产品认证获证企...', '2013年有机产品认证获证企...', 'TZGG', null, '0');
INSERT INTO `t_info` VALUES ('5', null, '0', '2013-05-15 23:05:21', null, '0', '0', '良好农业规范认证获证企业...', '良好农业规范认证获证企业...', '良好农业规范认证获证企业...', 'TZGG', null, '0');
INSERT INTO `t_info` VALUES ('6', null, '0', '2013-05-15 23:05:31', null, '0', '0', '信息安全管理体系认证获证...', '信息安全管理体系认证获证...', '信息安全管理体系认证获证...', 'TZGG', null, '0');
INSERT INTO `t_info` VALUES ('7', null, '0', '2013-05-15 23:05:43', null, '0', '0', '关于2004年和2009年获证...', '关于2004年和2009年获证...', '关于2004年和2009年获证...', 'TZGG', null, '0');
INSERT INTO `t_info` VALUES ('8', null, '0', '2013-05-15 23:07:27', null, '0', '0', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('9', null, '0', '2013-05-15 23:07:38', null, '0', '0', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('10', null, '0', '2013-05-15 23:07:46', null, '0', '0', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('11', null, '0', '2013-05-15 23:07:54', null, '0', '0', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('12', null, '0', '2013-05-15 23:08:04', null, '0', '0', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('13', null, '0', '2013-05-15 23:08:14', null, '0', '0', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('14', null, '0', '2013-05-15 23:08:25', null, '0', '0', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('15', null, '0', '2013-05-15 23:08:35', null, '0', '0', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('16', null, '0', '2013-05-15 23:08:47', null, '0', '0', '<h2>\r\n	中心与天祥公证行有限公司签订CCC认...\r\n</h2>', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('17', null, '0', '2013-05-15 23:08:56', null, '0', '0', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('18', null, '0', '2013-05-15 23:09:04', null, '0', '0', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('19', null, '0', '2013-05-15 23:09:13', null, '0', '0', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('20', null, '0', '2013-05-15 23:09:24', null, '0', '0', '中心派员参加IQnet亚洲成员机构会..', '中心派员参加IQnet亚洲成员机构会..', '中心派员参加IQnet亚洲成员机构会..', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('21', null, '0', '2013-05-15 23:09:35', null, '0', '0', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('22', null, '0', '2013-05-15 23:09:50', null, '0', '0', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('23', null, '0', '2013-05-15 23:10:02', null, '0', '0', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('24', null, '0', '2013-05-15 23:10:15', null, '0', '0', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('25', null, '0', '2013-05-15 23:10:27', null, '0', '0', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('26', null, '0', '2013-05-15 23:10:36', null, '0', '0', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('27', null, '0', '2013-05-15 23:10:45', null, '0', '0', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', 'QYXXH', null, '0');
INSERT INTO `t_info` VALUES ('28', null, '0', '2013-05-15 23:10:59', null, '0', '0', '关于2013年春节放假安排年春节放假安...', '关于2013年春节放假安排年春节放假安...', '关于2013年春节放假安排年春节放假安...', 'QYXW', null, '0');
INSERT INTO `t_info` VALUES ('29', null, '0', '2013-05-15 23:11:13', null, '0', '0', '关于2013年春节期间证书邮...', '关于2013年春节期间证书邮...', '关于2013年春节期间证书邮...', 'QYXW', null, '0');
INSERT INTO `t_info` VALUES ('30', null, '0', '2013-05-15 23:11:22', null, '0', '0', '财政部 发展改革委关于调整..', '财政部 发展改革委关于调整..', '财政部 发展改革委关于调整..', 'QYXW', null, '0');
INSERT INTO `t_info` VALUES ('31', null, '0', '2013-05-15 23:11:34', null, '0', '0', '2013年有机产品认证获证企...', '2013年有机产品认证获证企...', '2013年有机产品认证获证企...', 'QYXW', null, '0');
INSERT INTO `t_info` VALUES ('32', null, '0', '2013-05-15 23:11:42', null, '0', '0', '良好农业规范认证获证企业...', '良好农业规范认证获证企业...', '良好农业规范认证获证企业...', 'QYXW', null, '0');
INSERT INTO `t_info` VALUES ('33', null, '0', '2013-05-15 23:11:51', null, '0', '0', '信息安全管理体系认证获证..', '信息安全管理体系认证获证..', '信息安全管理体系认证获证..', 'QYXW', null, '0');
INSERT INTO `t_info` VALUES ('34', null, '0', '2013-05-15 23:12:00', null, '0', '0', '关于2013年春节放假安排的...', '关于2013年春节放假安排的...', '关于2013年春节放假安排的...', 'QYXW', null, '0');

-- ----------------------------
-- Table structure for `t_manure_instock`
-- ----------------------------
DROP TABLE IF EXISTS `t_manure_instock`;
CREATE TABLE `t_manure_instock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `element` varchar(60) DEFAULT NULL,
  `expirydate` datetime DEFAULT NULL,
  `indate` datetime DEFAULT NULL,
  `inuser_id` int(11) DEFAULT '0',
  `location` varchar(60) DEFAULT NULL,
  `stock_id` int(11) DEFAULT '0',
  `vendor` varchar(60) DEFAULT NULL,
  `wrap` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manure_instock
-- ----------------------------
INSERT INTO `t_manure_instock` VALUES ('1', null, '0', '2013-06-06 20:53:11', '', '3', '2', '2013-06-06 20:53:11', '3', '3', '5', '1', '4', '123.00', '2', '', '2013-06-10 00:00:00', '2013-05-27 00:00:00', '3', '', '1', '吖', '');
INSERT INTO `t_manure_instock` VALUES ('2', null, '0', '2013-08-27 13:39:16', '', '2', '0', '2013-08-27 13:39:16', '2', '3', '5', '1', '4', '33.00', '2', 's', '2013-08-31 00:00:00', '2013-08-27 00:00:00', '2', 'Te', '0', 'Tes', 'gg');
INSERT INTO `t_manure_instock` VALUES ('3', null, '0', '2013-08-29 06:15:10', '', '2', '2', '2013-08-29 06:15:10', '2', '16', '5', '1', '4', '5000.00', '18', '磷酸二氢钾', '2013-11-29 00:00:00', '2013-08-29 00:00:00', '2', '北京', '2', '中化化肥有限公司', '塑料');
INSERT INTO `t_manure_instock` VALUES ('4', null, '0', '2013-08-29 06:16:17', '', '2', '2', '2013-08-29 06:16:17', '2', '3', '6', '20', '10', '1000.00', '2', '', '2013-11-14 00:00:00', '2013-08-21 00:00:00', '2', '', '3', '', '');

-- ----------------------------
-- Table structure for `t_manure_outstock`
-- ----------------------------
DROP TABLE IF EXISTS `t_manure_outstock`;
CREATE TABLE `t_manure_outstock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `outdate` datetime DEFAULT NULL,
  `outuser_id` int(11) DEFAULT '0',
  `register_id` int(11) DEFAULT '0',
  `stock_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manure_outstock
-- ----------------------------
INSERT INTO `t_manure_outstock` VALUES ('1', '2013-08-29 06:23:10', '2', '2013-08-29 06:23:01', '', '0', '2', null, '0', '16', '0', '1', '4', '100.00', '18', '3', '2013-08-29 00:00:00', '2', '3', '2');
INSERT INTO `t_manure_outstock` VALUES ('2', null, '0', '2013-08-29 06:23:31', '', '0', '0', null, '0', '3', '0', '20', '10', '300.00', '2', '3', '2013-08-29 00:00:00', '2', '3', '3');

-- ----------------------------
-- Table structure for `t_manure_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_manure_resource`;
CREATE TABLE `t_manure_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manure_resource
-- ----------------------------
INSERT INTO `t_manure_resource` VALUES ('1', null, '0', '2013-06-06 20:51:58', '', '3', '0', '2013-08-29 06:12:44', '2', '磷酸二氢钾', 'PM');
INSERT INTO `t_manure_resource` VALUES ('2', null, '0', '2013-06-06 20:52:33', '', '3', '0', '2013-08-29 06:12:01', '2', '40kg', 'GG');
INSERT INTO `t_manure_resource` VALUES ('3', null, '0', '2013-06-06 20:52:44', '', '3', '0', '2013-08-29 06:11:16', '2', '20130821', 'SCPH');
INSERT INTO `t_manure_resource` VALUES ('4', null, '0', '2013-06-06 20:52:49', '', '3', '0', '2013-08-29 06:09:50', '2', '中化化肥有限公司', 'SCS');
INSERT INTO `t_manure_resource` VALUES ('5', null, '0', '2013-06-06 20:52:55', '', '3', '0', '2013-08-29 06:13:17', '2', '磷肥', 'ZL');
INSERT INTO `t_manure_resource` VALUES ('6', null, '0', '2013-08-29 06:09:12', '', '2', '0', '2013-08-29 06:13:24', '2', '氮肥', 'ZL');
INSERT INTO `t_manure_resource` VALUES ('7', null, '0', '2013-08-29 06:09:25', '', '2', '0', '2013-08-29 06:13:30', '2', '钾肥', 'ZL');
INSERT INTO `t_manure_resource` VALUES ('8', null, '0', '2013-08-29 06:09:36', '', '2', '0', '2013-08-29 06:13:39', '2', '矿物质', 'ZL');
INSERT INTO `t_manure_resource` VALUES ('9', null, '0', '2013-08-29 06:10:20', '', '2', '0', '2013-08-29 06:10:20', '2', '湖北宜化集团有限责任公司 ', 'SCS');
INSERT INTO `t_manure_resource` VALUES ('10', null, '0', '2013-08-29 06:10:29', '', '2', '0', '2013-08-29 06:10:29', '2', '山东鲁北企业集团总公司', 'SCS');
INSERT INTO `t_manure_resource` VALUES ('11', null, '0', '2013-08-29 06:10:38', '', '2', '0', '2013-08-29 06:10:38', '2', '云南煤化工集团有限公司', 'SCS');
INSERT INTO `t_manure_resource` VALUES ('12', null, '0', '2013-08-29 06:10:50', '', '2', '0', '2013-08-29 06:10:50', '2', '青海盐湖工业集团股份有限公司', 'SCS');
INSERT INTO `t_manure_resource` VALUES ('13', null, '0', '2013-08-29 06:10:52', '', '2', '0', '2013-08-29 06:10:52', '2', '青海盐湖工业集团股份有限公司', 'SCS');
INSERT INTO `t_manure_resource` VALUES ('14', null, '0', '2013-08-29 06:11:26', '', '2', '0', '2013-08-29 06:11:26', '2', '20130625', 'SCPH');
INSERT INTO `t_manure_resource` VALUES ('15', null, '0', '2013-08-29 06:11:34', '', '2', '0', '2013-08-29 06:11:39', '2', '20130518', 'SCPH');
INSERT INTO `t_manure_resource` VALUES ('16', null, '0', '2013-08-29 06:11:45', '', '2', '0', '2013-08-29 06:11:45', '2', '20130829', 'SCPH');
INSERT INTO `t_manure_resource` VALUES ('17', null, '0', '2013-08-29 06:12:08', '', '2', '0', '2013-08-29 06:12:08', '2', '2kg', 'GG');
INSERT INTO `t_manure_resource` VALUES ('18', null, '0', '2013-08-29 06:12:14', '', '2', '0', '2013-08-29 06:12:14', '2', '50kg', 'GG');
INSERT INTO `t_manure_resource` VALUES ('19', null, '0', '2013-08-29 06:12:22', '', '2', '0', '2013-08-29 06:12:22', '2', '10kg', 'GG');
INSERT INTO `t_manure_resource` VALUES ('20', null, '0', '2013-08-29 06:12:53', '', '2', '0', '2013-08-29 06:12:53', '2', '二铵', 'PM');
INSERT INTO `t_manure_resource` VALUES ('21', null, '0', '2013-08-29 06:12:58', '', '2', '0', '2013-08-29 06:12:58', '2', '磷肥', 'PM');
INSERT INTO `t_manure_resource` VALUES ('22', null, '0', '2013-08-29 06:13:07', '', '2', '0', '2013-08-29 06:13:07', '2', '叶面肥', 'PM');

-- ----------------------------
-- Table structure for `t_manure_stock`
-- ----------------------------
DROP TABLE IF EXISTS `t_manure_stock`;
CREATE TABLE `t_manure_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manure_stock
-- ----------------------------
INSERT INTO `t_manure_stock` VALUES ('1', null, '0', '2013-06-06 20:53:14', null, '0', '0', null, '0', '3', '0', '1', '4', '123.00', '2');
INSERT INTO `t_manure_stock` VALUES ('2', null, '0', '2013-08-29 06:15:31', null, '0', '0', null, '0', '16', '0', '1', '4', '4900.00', '18');
INSERT INTO `t_manure_stock` VALUES ('3', null, '0', '2013-08-29 06:17:09', null, '0', '0', null, '0', '3', '0', '20', '10', '700.00', '2');

-- ----------------------------
-- Table structure for `t_medicine_instock`
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine_instock`;
CREATE TABLE `t_medicine_instock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `element` varchar(60) DEFAULT NULL,
  `expirydate` datetime DEFAULT NULL,
  `indate` datetime DEFAULT NULL,
  `inuser_id` int(11) DEFAULT '0',
  `location` varchar(60) DEFAULT NULL,
  `stock_id` int(11) DEFAULT '0',
  `vendor` varchar(60) DEFAULT NULL,
  `wrap` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine_instock
-- ----------------------------

-- ----------------------------
-- Table structure for `t_medicine_outstock`
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine_outstock`;
CREATE TABLE `t_medicine_outstock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `outdate` datetime DEFAULT NULL,
  `outuser_id` int(11) DEFAULT '0',
  `register_id` int(11) DEFAULT '0',
  `stock_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine_outstock
-- ----------------------------

-- ----------------------------
-- Table structure for `t_medicine_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine_resource`;
CREATE TABLE `t_medicine_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `t_medicine_stock`
-- ----------------------------
DROP TABLE IF EXISTS `t_medicine_stock`;
CREATE TABLE `t_medicine_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_medicine_stock
-- ----------------------------

-- ----------------------------
-- Table structure for `t_nurture_farm`
-- ----------------------------
DROP TABLE IF EXISTS `t_nurture_farm`;
CREATE TABLE `t_nurture_farm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `activitydate` datetime DEFAULT NULL,
  `cell_id` int(11) DEFAULT '0',
  `content` varchar(255) DEFAULT NULL,
  `manager` varchar(60) DEFAULT NULL,
  `persons` int(11) DEFAULT '0',
  `register_id` int(11) DEFAULT '0',
  `scale` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_nurture_farm
-- ----------------------------

-- ----------------------------
-- Table structure for `t_nurture_harvest`
-- ----------------------------
DROP TABLE IF EXISTS `t_nurture_harvest`;
CREATE TABLE `t_nurture_harvest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `method` varchar(60) DEFAULT NULL,
  `operatedate` datetime DEFAULT NULL,
  `product` varchar(100) DEFAULT NULL,
  `register_id` int(11) DEFAULT '0',
  `respmanager` varchar(60) DEFAULT NULL,
  `scale` decimal(10,2) DEFAULT '0.00',
  `storage` varchar(60) DEFAULT NULL,
  `storemanager` varchar(60) DEFAULT NULL,
  `yield` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_nurture_harvest
-- ----------------------------

-- ----------------------------
-- Table structure for `t_nurture_irrigate`
-- ----------------------------
DROP TABLE IF EXISTS `t_nurture_irrigate`;
CREATE TABLE `t_nurture_irrigate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `area` decimal(10,2) DEFAULT '0.00',
  `cell_id` int(11) DEFAULT '0',
  `date` datetime DEFAULT NULL,
  `manager` varchar(60) DEFAULT NULL,
  `quantum` decimal(10,2) DEFAULT '0.00',
  `register_id` int(11) DEFAULT '0',
  `way` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_nurture_irrigate
-- ----------------------------

-- ----------------------------
-- Table structure for `t_nurture_manure`
-- ----------------------------
DROP TABLE IF EXISTS `t_nurture_manure`;
CREATE TABLE `t_nurture_manure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `isolation` decimal(10,2) DEFAULT '0.00',
  `machinecate` int(11) DEFAULT NULL,
  `method` int(11) DEFAULT NULL,
  `name_id` int(11) DEFAULT '0',
  `reason` varchar(100) DEFAULT NULL,
  `register_id` int(11) DEFAULT '0',
  `stock_id` int(11) DEFAULT '0',
  `tech` varchar(60) DEFAULT NULL,
  `usedate` datetime DEFAULT NULL,
  `useperson` varchar(60) DEFAULT NULL,
  `useqty` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_nurture_manure
-- ----------------------------

-- ----------------------------
-- Table structure for `t_nurture_pesticide`
-- ----------------------------
DROP TABLE IF EXISTS `t_nurture_pesticide`;
CREATE TABLE `t_nurture_pesticide` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `isolation` decimal(10,2) DEFAULT '0.00',
  `machinecate` int(11) DEFAULT NULL,
  `method` int(11) DEFAULT NULL,
  `name_id` int(11) DEFAULT '0',
  `reason` varchar(100) DEFAULT NULL,
  `register_id` int(11) DEFAULT '0',
  `stock_id` int(11) DEFAULT '0',
  `tech` varchar(60) DEFAULT NULL,
  `usedate` datetime DEFAULT NULL,
  `useperson` varchar(60) DEFAULT NULL,
  `useqty` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_nurture_pesticide
-- ----------------------------

-- ----------------------------
-- Table structure for `t_nurture_register`
-- ----------------------------
DROP TABLE IF EXISTS `t_nurture_register`;
CREATE TABLE `t_nurture_register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `description` varchar(100) DEFAULT NULL,
  `nurturestatus` int(11) DEFAULT '0',
  `person` varchar(36) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `qrcode` longblob,
  `regdate` datetime DEFAULT NULL,
  `reguser_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_nurture_register
-- ----------------------------

-- ----------------------------
-- Table structure for `t_pesticide_instock`
-- ----------------------------
DROP TABLE IF EXISTS `t_pesticide_instock`;
CREATE TABLE `t_pesticide_instock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `element` varchar(60) DEFAULT NULL,
  `expirydate` datetime DEFAULT NULL,
  `indate` datetime DEFAULT NULL,
  `inuser_id` int(11) DEFAULT '0',
  `location` varchar(60) DEFAULT NULL,
  `stock_id` int(11) DEFAULT '0',
  `vendor` varchar(60) DEFAULT NULL,
  `wrap` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pesticide_instock
-- ----------------------------
INSERT INTO `t_pesticide_instock` VALUES ('1', null, '0', '2013-08-29 06:54:00', '', '2', '2', '2013-08-29 06:54:00', '2', '7', '1', '12', '5', '500.00', '9', '', '2014-08-29 00:00:00', '2013-08-29 00:00:00', '2', '', '1', '', '');
INSERT INTO `t_pesticide_instock` VALUES ('2', null, '0', '2013-08-29 06:54:37', '', '2', '2', '2013-08-29 06:54:37', '2', '8', '3', '13', '5', '200.00', '9', '', '2013-09-26 00:00:00', '2013-08-29 00:00:00', '2', '', '2', '', '');
INSERT INTO `t_pesticide_instock` VALUES ('3', null, '0', '2013-08-29 06:55:13', '', '2', '0', '2013-08-29 06:55:13', '2', '7', '4', '14', '6', '50.00', '11', '', '2013-08-30 00:00:00', '2013-08-23 00:00:00', '2', '', '0', '', '');

-- ----------------------------
-- Table structure for `t_pesticide_outstock`
-- ----------------------------
DROP TABLE IF EXISTS `t_pesticide_outstock`;
CREATE TABLE `t_pesticide_outstock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  `cell_id` int(11) DEFAULT '0',
  `outdate` datetime DEFAULT NULL,
  `outuser_id` int(11) DEFAULT '0',
  `register_id` int(11) DEFAULT '0',
  `stock_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pesticide_outstock
-- ----------------------------
INSERT INTO `t_pesticide_outstock` VALUES ('1', '2013-08-29 06:56:01', '2', '2013-08-29 06:55:43', '', '0', '2', null, '0', '7', '0', '12', '5', '50.00', '9', '3', '2013-08-30 00:00:00', '2', '3', '1');
INSERT INTO `t_pesticide_outstock` VALUES ('2', null, '0', '2013-08-29 06:55:58', '', '0', '0', null, '0', '8', '0', '13', '5', '100.00', '9', '3', '2013-08-31 00:00:00', '2', '3', '2');

-- ----------------------------
-- Table structure for `t_pesticide_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_pesticide_resource`;
CREATE TABLE `t_pesticide_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pesticide_resource
-- ----------------------------
INSERT INTO `t_pesticide_resource` VALUES ('1', null, '0', '2013-08-29 06:47:24', '', '2', '0', '2013-08-29 06:47:24', '2', '杀虫剂', 'ZL');
INSERT INTO `t_pesticide_resource` VALUES ('2', null, '0', '2013-08-29 06:47:33', '', '2', '0', '2013-08-29 06:47:33', '2', '除草剂', 'ZL');
INSERT INTO `t_pesticide_resource` VALUES ('3', null, '0', '2013-08-29 06:47:47', '', '2', '0', '2013-08-29 06:47:47', '2', '杀菌剂', 'ZL');
INSERT INTO `t_pesticide_resource` VALUES ('4', null, '0', '2013-08-29 06:48:03', '', '2', '0', '2013-08-29 06:48:03', '2', '营养调和剂', 'ZL');
INSERT INTO `t_pesticide_resource` VALUES ('5', '2013-08-29 06:48:44', '2', '2013-08-29 06:48:25', '', '2', '2', '2013-08-29 06:48:25', '2', '中化生物农药有限公司', 'SCS');
INSERT INTO `t_pesticide_resource` VALUES ('6', null, '0', '2013-08-29 06:48:41', '', '2', '0', '2013-08-29 06:48:41', '2', '江西生物农药有限公司', 'SCS');
INSERT INTO `t_pesticide_resource` VALUES ('7', '2013-08-29 06:49:06', '2', '2013-08-29 06:48:55', '', '2', '2', '2013-08-29 06:48:55', '2', '20130821', 'SCPH');
INSERT INTO `t_pesticide_resource` VALUES ('8', null, '0', '2013-08-29 06:49:02', '', '2', '0', '2013-08-29 06:49:02', '2', '20130829', 'SCPH');
INSERT INTO `t_pesticide_resource` VALUES ('9', '2013-08-29 06:49:29', '2', '2013-08-29 06:49:15', '', '2', '2', '2013-08-29 06:49:15', '2', '10kg', 'GG');
INSERT INTO `t_pesticide_resource` VALUES ('10', '2013-08-29 06:49:31', '2', '2013-08-29 06:49:21', '', '2', '2', '2013-08-29 06:49:21', '2', '2kg', 'GG');
INSERT INTO `t_pesticide_resource` VALUES ('11', null, '0', '2013-08-29 06:49:26', '', '2', '0', '2013-08-29 06:49:26', '2', '500g', 'GG');
INSERT INTO `t_pesticide_resource` VALUES ('12', '2013-08-29 06:50:19', '2', '2013-08-29 06:49:47', '', '2', '2', '2013-08-29 06:49:47', '2', '杀虫双', 'PM');
INSERT INTO `t_pesticide_resource` VALUES ('13', '2013-08-29 06:50:23', '2', '2013-08-29 06:49:59', '', '2', '2', '2013-08-29 06:49:59', '2', '辛硫磷', 'PM');
INSERT INTO `t_pesticide_resource` VALUES ('14', null, '0', '2013-08-29 06:50:08', '', '2', '0', '2013-08-29 06:50:08', '2', '石硫合剂', 'PM');
INSERT INTO `t_pesticide_resource` VALUES ('15', null, '0', '2013-08-29 06:50:15', '', '2', '0', '2013-08-29 06:50:15', '2', '叶面宝', 'PM');
INSERT INTO `t_pesticide_resource` VALUES ('16', null, '0', '2013-08-29 06:50:50', '', '2', '0', '2013-08-29 06:50:50', '2', '甲基硫菌灵', 'PM');
INSERT INTO `t_pesticide_resource` VALUES ('17', null, '0', '2013-08-29 06:51:04', '', '2', '0', '2013-08-29 06:51:04', '2', '宝成', 'PM');
INSERT INTO `t_pesticide_resource` VALUES ('18', null, '0', '2013-08-29 06:51:52', '', '2', '0', '2013-08-29 06:51:52', '2', '银法利', 'PM');
INSERT INTO `t_pesticide_resource` VALUES ('19', null, '0', '2013-08-29 06:52:06', '', '2', '0', '2013-08-29 06:52:06', '2', '氟吡菌胺', 'PM');
INSERT INTO `t_pesticide_resource` VALUES ('20', null, '0', '2013-08-29 06:52:18', '', '2', '0', '2013-08-29 06:52:18', '2', '高效氯氟氰菊酯', 'PM');
INSERT INTO `t_pesticide_resource` VALUES ('21', null, '0', '2013-08-29 06:52:35', '', '2', '0', '2013-08-29 06:52:35', '2', '噻虫嗪', 'PM');

-- ----------------------------
-- Table structure for `t_pesticide_stock`
-- ----------------------------
DROP TABLE IF EXISTS `t_pesticide_stock`;
CREATE TABLE `t_pesticide_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pesticide_stock
-- ----------------------------
INSERT INTO `t_pesticide_stock` VALUES ('1', null, '0', '2013-08-29 06:54:06', null, '0', '0', null, '0', '7', '0', '12', '5', '450.00', '9');
INSERT INTO `t_pesticide_stock` VALUES ('2', null, '0', '2013-08-29 06:54:41', null, '0', '0', null, '0', '8', '0', '13', '5', '100.00', '9');

-- ----------------------------
-- Table structure for `t_production_cell`
-- ----------------------------
DROP TABLE IF EXISTS `t_production_cell`;
CREATE TABLE `t_production_cell` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `area` decimal(10,2) DEFAULT '0.00',
  `builddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `usestatus` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_production_cell
-- ----------------------------
INSERT INTO `t_production_cell` VALUES ('1', '2013-06-06 20:40:08', '3', '2013-06-06 20:39:08', null, '3', '2', '2013-06-06 20:51:26', '3', '1001.00', '2013-06-02 00:00:00', '单元A', '东方', '1');
INSERT INTO `t_production_cell` VALUES ('2', '2013-08-29 06:37:18', '2', '2013-06-06 20:39:25', null, '3', '2', '2013-06-06 20:39:25', '3', '1002.00', '2013-06-02 00:00:00', '单元B', '南方', '0');
INSERT INTO `t_production_cell` VALUES ('3', '2013-06-06 20:40:14', '3', '2013-06-06 20:39:42', null, '3', '2', '2013-08-29 07:01:23', '2', '1003.00', '2013-05-26 00:00:00', '单元C', '西方', '0');
INSERT INTO `t_production_cell` VALUES ('4', '2013-08-29 06:37:21', '2', '2013-06-06 20:39:56', null, '3', '2', '2013-06-06 20:39:56', '3', '1004.00', '2013-05-30 00:00:00', '单元D', '北方', '0');
INSERT INTO `t_production_cell` VALUES ('5', '2013-08-27 13:37:21', '2', '2013-08-27 13:37:16', null, '2', '2', '2013-08-27 13:38:18', '2', '123.00', '2013-08-07 00:00:00', 'TEST1', 'test1', '0');
INSERT INTO `t_production_cell` VALUES ('6', '2013-08-29 01:03:59', '2', '2013-08-29 01:03:23', null, '2', '2', '2013-08-29 01:03:53', '2', '1000.00', '2013-07-28 00:00:00', '单元E', '西南1', '0');
INSERT INTO `t_production_cell` VALUES ('7', null, '0', '2013-08-29 06:32:51', null, '2', '0', '2013-08-29 06:32:51', '2', '500.00', '2013-08-29 00:00:00', 'CQC-A', '南四环西路1号楼', '0');
INSERT INTO `t_production_cell` VALUES ('8', '2013-08-29 06:37:15', '2', '2013-08-29 06:33:16', null, '2', '2', '2013-08-29 06:39:13', '2', '500.00', '2013-08-29 00:00:00', 'CQC-B', '2号楼', '1');
INSERT INTO `t_production_cell` VALUES ('9', '2013-08-29 06:37:11', '2', '2013-08-29 06:33:40', null, '2', '2', '2013-08-29 06:39:42', '2', '500.00', '2013-08-29 00:00:00', 'CQC-C', '3号楼', '1');
INSERT INTO `t_production_cell` VALUES ('10', '2013-08-29 06:37:08', '2', '2013-08-29 06:34:13', null, '2', '2', '2013-08-29 06:34:13', '2', '500.00', '2013-08-30 00:00:00', 'CQC-D', '4号楼', '0');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adate` datetime DEFAULT NULL,
  `auser_id` int(11) DEFAULT '0',
  `cdate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `cuser_id` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `udate` datetime DEFAULT NULL,
  `uuser_id` int(11) DEFAULT '0',
  `pass_word` varchar(20) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `user_name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', null, '0', '2013-06-06 20:22:39', null, '0', '0', '2013-06-06 20:22:39', '0', 'admin', 'admin', '超级管理员');
INSERT INTO `t_user` VALUES ('3', null, '0', '2013-06-06 20:34:59', null, '2', '0', '2013-06-06 20:34:59', '2', 'test', 'test', '测试员');
INSERT INTO `t_user` VALUES ('4', null, '0', '2013-08-27 13:46:49', null, '2', '0', '2013-08-27 13:46:49', '2', 'T', 'T', 'T');
