/*
Navicat MySQL Data Transfer

Source Server         : localhost_root_root
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : gap

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2013-05-15 23:37:57
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dict
-- ----------------------------

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
  `name` varchar(60) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
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
  `name` varchar(60) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
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
-- Records of t_grow_farm
-- ----------------------------

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
-- Records of t_grow_harvest
-- ----------------------------

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
-- Records of t_grow_irrigate
-- ----------------------------

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
-- Records of t_grow_manure
-- ----------------------------

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
  `cell_id` int(11) DEFAULT '0',
  `description` varchar(100) DEFAULT NULL,
  `growstatus` int(11) DEFAULT '0',
  `person` varchar(36) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `qrcode` longblob,
  `regdate` datetime DEFAULT NULL,
  `reguser_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grow_register
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_info
-- ----------------------------
INSERT INTO `t_info` VALUES ('1', null, '0', '2013-05-15 00:44:01', 'GGagag', '0', '0', '关于2013年春节放假安排的...', '关于2013年春节放假安排的...', '关于2013年春节放假安排的...', 'TZGG');
INSERT INTO `t_info` VALUES ('2', null, '0', '2013-05-15 23:04:52', null, '0', '0', '关于2013年春节期间证书邮...', '关于2013年春节期间证书邮...', '关于2013年春节期间证书邮...', 'TZGG');
INSERT INTO `t_info` VALUES ('3', null, '0', '2013-05-15 23:05:03', null, '0', '0', '财政部 发展改革委关于调整...', '财政部 发展改革委关于调整...', '财政部 发展改革委关于调整...', 'TZGG');
INSERT INTO `t_info` VALUES ('4', null, '0', '2013-05-15 23:05:13', null, '0', '0', '2013年有机产品认证获证企...', '2013年有机产品认证获证企...', '2013年有机产品认证获证企...', 'TZGG');
INSERT INTO `t_info` VALUES ('5', null, '0', '2013-05-15 23:05:21', null, '0', '0', '良好农业规范认证获证企业...', '良好农业规范认证获证企业...', '良好农业规范认证获证企业...', 'TZGG');
INSERT INTO `t_info` VALUES ('6', null, '0', '2013-05-15 23:05:31', null, '0', '0', '信息安全管理体系认证获证...', '信息安全管理体系认证获证...', '信息安全管理体系认证获证...', 'TZGG');
INSERT INTO `t_info` VALUES ('7', null, '0', '2013-05-15 23:05:43', null, '0', '0', '关于2004年和2009年获证...', '关于2004年和2009年获证...', '关于2004年和2009年获证...', 'TZGG');
INSERT INTO `t_info` VALUES ('8', null, '0', '2013-05-15 23:07:27', null, '0', '0', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', 'QYXXH');
INSERT INTO `t_info` VALUES ('9', null, '0', '2013-05-15 23:07:38', null, '0', '0', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', 'QYXXH');
INSERT INTO `t_info` VALUES ('10', null, '0', '2013-05-15 23:07:46', null, '0', '0', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', 'QYXXH');
INSERT INTO `t_info` VALUES ('11', null, '0', '2013-05-15 23:07:54', null, '0', '0', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', 'QYXXH');
INSERT INTO `t_info` VALUES ('12', null, '0', '2013-05-15 23:08:04', null, '0', '0', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', 'QYXXH');
INSERT INTO `t_info` VALUES ('13', null, '0', '2013-05-15 23:08:14', null, '0', '0', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', 'QYXXH');
INSERT INTO `t_info` VALUES ('14', null, '0', '2013-05-15 23:08:25', null, '0', '0', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', 'QYXXH');
INSERT INTO `t_info` VALUES ('15', null, '0', '2013-05-15 23:08:35', null, '0', '0', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', 'QYXXH');
INSERT INTO `t_info` VALUES ('16', null, '0', '2013-05-15 23:08:47', null, '0', '0', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', 'QYXXH');
INSERT INTO `t_info` VALUES ('17', null, '0', '2013-05-15 23:08:56', null, '0', '0', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', 'QYXXH');
INSERT INTO `t_info` VALUES ('18', null, '0', '2013-05-15 23:09:04', null, '0', '0', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', 'QYXXH');
INSERT INTO `t_info` VALUES ('19', null, '0', '2013-05-15 23:09:13', null, '0', '0', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', 'QYXXH');
INSERT INTO `t_info` VALUES ('20', null, '0', '2013-05-15 23:09:24', null, '0', '0', '中心派员参加IQnet亚洲成员机构会..', '中心派员参加IQnet亚洲成员机构会..', '中心派员参加IQnet亚洲成员机构会..', 'QYXXH');
INSERT INTO `t_info` VALUES ('21', null, '0', '2013-05-15 23:09:35', null, '0', '0', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', 'QYXXH');
INSERT INTO `t_info` VALUES ('22', null, '0', '2013-05-15 23:09:50', null, '0', '0', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', '中心与天祥公证行有限公司签订CCC认..', 'QYXXH');
INSERT INTO `t_info` VALUES ('23', null, '0', '2013-05-15 23:10:02', null, '0', '0', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', '广州分中心低碳工作获得广东省发改委认...', 'QYXXH');
INSERT INTO `t_info` VALUES ('24', null, '0', '2013-05-15 23:10:15', null, '0', '0', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', '王克娇主任到广州调研工作', 'QYXXH');
INSERT INTO `t_info` VALUES ('25', null, '0', '2013-05-15 23:10:27', null, '0', '0', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', '中心积极做好节能产品惠民工程相关工作', 'QYXXH');
INSERT INTO `t_info` VALUES ('26', null, '0', '2013-05-15 23:10:36', null, '0', '0', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', '中心派员参加IQnet亚洲成员机构会...', 'QYXXH');
INSERT INTO `t_info` VALUES ('27', null, '0', '2013-05-15 23:10:45', null, '0', '0', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', '中心与天祥公证行有限公司签订CCC认...', 'QYXXH');
INSERT INTO `t_info` VALUES ('28', null, '0', '2013-05-15 23:10:59', null, '0', '0', '关于2013年春节放假安排年春节放假安...', '关于2013年春节放假安排年春节放假安...', '关于2013年春节放假安排年春节放假安...', 'QYXW');
INSERT INTO `t_info` VALUES ('29', null, '0', '2013-05-15 23:11:13', null, '0', '0', '关于2013年春节期间证书邮...', '关于2013年春节期间证书邮...', '关于2013年春节期间证书邮...', 'QYXW');
INSERT INTO `t_info` VALUES ('30', null, '0', '2013-05-15 23:11:22', null, '0', '0', '财政部 发展改革委关于调整..', '财政部 发展改革委关于调整..', '财政部 发展改革委关于调整..', 'QYXW');
INSERT INTO `t_info` VALUES ('31', null, '0', '2013-05-15 23:11:34', null, '0', '0', '2013年有机产品认证获证企...', '2013年有机产品认证获证企...', '2013年有机产品认证获证企...', 'QYXW');
INSERT INTO `t_info` VALUES ('32', null, '0', '2013-05-15 23:11:42', null, '0', '0', '良好农业规范认证获证企业...', '良好农业规范认证获证企业...', '良好农业规范认证获证企业...', 'QYXW');
INSERT INTO `t_info` VALUES ('33', null, '0', '2013-05-15 23:11:51', null, '0', '0', '信息安全管理体系认证获证..', '信息安全管理体系认证获证..', '信息安全管理体系认证获证..', 'QYXW');
INSERT INTO `t_info` VALUES ('34', null, '0', '2013-05-15 23:12:00', null, '0', '0', '关于2013年春节放假安排的...', '关于2013年春节放假安排的...', '关于2013年春节放假安排的...', 'QYXW');

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
-- Records of t_manure_instock
-- ----------------------------

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
-- Records of t_manure_outstock
-- ----------------------------

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
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manure_resource
-- ----------------------------

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
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_manure_stock
-- ----------------------------

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
  `name` varchar(60) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
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
  `cell_id` int(11) DEFAULT '0',
  `isolation` decimal(10,2) DEFAULT '0.00',
  `machinecate` varchar(100) DEFAULT NULL,
  `method` varchar(100) DEFAULT NULL,
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
  `cell_id` int(11) DEFAULT '0',
  `isolation` decimal(10,2) DEFAULT '0.00',
  `machinecate` varchar(100) DEFAULT NULL,
  `method` varchar(100) DEFAULT NULL,
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
  `cell_id` int(11) DEFAULT '0',
  `description` varchar(100) DEFAULT NULL,
  `nurturestatus` int(11) DEFAULT '0',
  `person` varchar(36) DEFAULT NULL,
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
-- Records of t_pesticide_instock
-- ----------------------------

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
-- Records of t_pesticide_outstock
-- ----------------------------

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
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pesticide_resource
-- ----------------------------

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
  `batch_id` int(11) DEFAULT '0',
  `kind_id` int(11) DEFAULT '0',
  `name_id` int(11) DEFAULT '0',
  `producer_id` int(11) DEFAULT '0',
  `quantity` decimal(10,2) DEFAULT '0.00',
  `spec_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pesticide_stock
-- ----------------------------

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
  `area` decimal(10,2) DEFAULT '0.00',
  `builddate` datetime DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `usestatus` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_production_cell
-- ----------------------------

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
  `pass_word` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
