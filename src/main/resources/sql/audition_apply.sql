/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : quest_data

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2017-07-09 16:02:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for audition_apply
-- ----------------------------
DROP TABLE IF EXISTS `audition_apply`;
CREATE TABLE `audition_apply` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '孩子的名字',
  `age` int(2) NOT NULL DEFAULT '3' COMMENT '3~16岁',
  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号',
  `contacted` int(2) NOT NULL DEFAULT '0' COMMENT '是否联系过（0：未联系，1：联系过）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_mobile` (`mobile`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
