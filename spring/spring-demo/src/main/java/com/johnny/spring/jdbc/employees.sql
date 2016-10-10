/*
Navicat MySQL Data Transfer

Source Server         : rds675xa0pzl8p5fuksv.mysql.rds.aliyuncs.com_3306
Source Server Version : 50518
Source Host           : rds675xa0pzl8p5fuksv.mysql.rds.aliyuncs.com:3306
Source Database       : rt9457v4vy

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-08-14 20:16:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `last_name` varchar(255) DEFAULT NULL,
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `dept_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('hfq', '1', 'hfq@qq.com', '1');
INSERT INTO `employees` VALUES ('hll', '2', 'lll@qq.com', '2');
INSERT INTO `employees` VALUES ('johnnty', '3', 'johnny@qq.com', '3');
