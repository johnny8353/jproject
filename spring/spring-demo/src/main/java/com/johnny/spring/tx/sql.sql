/*
Navicat MySQL Data Transfer

Source Server         : rds675xa0pzl8p5fuksv.mysql.rds.aliyuncs.com_3306
Source Server Version : 50518
Source Host           : rds675xa0pzl8p5fuksv.mysql.rds.aliyuncs.com:3306
Source Database       : rt9457v4vy

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-08-14 22:25:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `balance` decimal(30,0) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1000', 'hfq');


-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `isbn` varchar(255) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book


-- ----------------------------
-- Table structure for book_stock
-- ----------------------------
DROP TABLE IF EXISTS `book_stock`;
CREATE TABLE `book_stock` (
  `isbn` varchar(255) NOT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_stock
-- ----------------------------
INSERT INTO `book_stock` VALUES ('001', '600');

-- ----------------------------
INSERT INTO `book` VALUES ('001', 'java编程思想', '65');

