/*
Navicat MySQL Data Transfer

Source Server         : rds675xa0pzl8p5fuksv.mysql.rds.aliyuncs.com_3306
Source Server Version : 50518
Source Host           : rds675xa0pzl8p5fuksv.mysql.rds.aliyuncs.com:3306
Source Database       : rt9457v4vy

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-08-14 20:17:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for depts
-- ----------------------------
DROP TABLE IF EXISTS `depts`;
CREATE TABLE `depts` (
  `dept_name` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depts
-- ----------------------------
INSERT INTO `depts` VALUES ('IT部', '1');
INSERT INTO `depts` VALUES ('市场部', '2');
INSERT INTO `depts` VALUES ('营销部', '3');
