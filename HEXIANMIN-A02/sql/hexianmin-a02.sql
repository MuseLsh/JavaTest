/*
Navicat MySQL Data Transfer

Source Server         : homework-a02
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : hexianmin-a02

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-07-20 19:40:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ipdomain
-- ----------------------------
DROP TABLE IF EXISTS `ipdomain`;
CREATE TABLE `ipdomain` (
  `domain` varchar(255) NOT NULL,
  `ip` varchar(255) NOT NULL,
  `tag` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ipdomain
-- ----------------------------
INSERT INTO `ipdomain` VALUES ('socket1.bt.com(百田1)', '192.168.1.5', '1');
INSERT INTO `ipdomain` VALUES ('socket1.bt.com(百田2)', '192.168.1.6', '0');

-- ----------------------------
-- Table structure for zonesinfo
-- ----------------------------
DROP TABLE IF EXISTS `zonesinfo`;
CREATE TABLE `zonesinfo` (
  `zonename` varchar(255) NOT NULL,
  `zoneip` varchar(255) NOT NULL,
  `zoneport` varchar(255) NOT NULL,
  `nownum` int(11) NOT NULL,
  `maxnum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zonesinfo
-- ----------------------------
INSERT INTO `zonesinfo` VALUES ('阿尔岛', '192.168.1.5', '8000', '20', '300');
INSERT INTO `zonesinfo` VALUES ('可可岛', '192.168.1.5', '8000', '60', '400');
INSERT INTO `zonesinfo` VALUES ('奥比岛', '192.168.1.5', '8000', '90', '300');
INSERT INTO `zonesinfo` VALUES ('波比岛', '192.168.1.6', '8000', '60', '300');
INSERT INTO `zonesinfo` VALUES ('奥拉岛', '192.168.1.6', '8000', '70', '300');
INSERT INTO `zonesinfo` VALUES ('奥奇岛', '95.63.1.100', '8003', '50', '300');
INSERT INTO `zonesinfo` VALUES ('奥雅岛', '95.68.31.115', '8001', '180', '300');
INSERT INTO `zonesinfo` VALUES ('$test', '95.68.31.115', '8003', '1', '300');
