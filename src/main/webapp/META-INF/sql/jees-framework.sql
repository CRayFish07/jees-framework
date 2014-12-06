/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : jees-framework

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2014-12-06 13:46:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `jees_big_test`
-- ----------------------------
DROP TABLE IF EXISTS `jees_big_test`;
CREATE TABLE `jees_big_test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `update_time` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1408186705232 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jees_big_test
-- ----------------------------
INSERT INTO `jees_big_test` VALUES ('1408186705230', 'BIGINT主键支持测试', '内容1417844783236', '0', '1408186705230', '1417844783236');
INSERT INTO `jees_big_test` VALUES ('1408186705231', '标题1417844707074', '内容', '0', '1417844707074', '1417844707074');

-- ----------------------------
-- Table structure for `jees_test`
-- ----------------------------
DROP TABLE IF EXISTS `jees_test`;
CREATE TABLE `jees_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) NOT NULL DEFAULT '',
  `content` text NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `create_time` bigint(20) NOT NULL DEFAULT '0',
  `update_time` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jees_test
-- ----------------------------
INSERT INTO `jees_test` VALUES ('1', '标题1408186705230', '内容1417844696312', '0', '1408186705230', '1417844696312');
INSERT INTO `jees_test` VALUES ('2', '标题1408186711875', '内容1408586510520', '0', '1408186711875', '1408586510520');
INSERT INTO `jees_test` VALUES ('3', '标题1408586492732', '内容', '0', '1408586492732', '1408586492732');
INSERT INTO `jees_test` VALUES ('4', '标题1409217877603', '内容', '0', '1409217877603', '1409217877603');
INSERT INTO `jees_test` VALUES ('5', '标题1417844695495', '内容', '0', '1417844695495', '1417844695495');
