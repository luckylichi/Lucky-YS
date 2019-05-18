/*
Navicat MySQL Data Transfer

Source Server         : tanng
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : ludaka

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2019-05-18 22:40:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) NOT NULL,
  `psw` varchar(20) NOT NULL,
  `rank` varchar(13) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for changuse
-- ----------------------------
DROP TABLE IF EXISTS `changuse`;
CREATE TABLE `changuse` (
  `adminid` int(4) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) NOT NULL,
  `rank` varchar(13) NOT NULL,
  `chang` varchar(13) NOT NULL,
  `empid` int(4) DEFAULT NULL,
  `changtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `age` int(3) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `job` varchar(20) NOT NULL,
  `salary` double(7,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for emphis
-- ----------------------------
DROP TABLE IF EXISTS `emphis`;
CREATE TABLE `emphis` (
  `id` int(4) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(3) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `job` varchar(20) NOT NULL,
  `salary` double(7,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
