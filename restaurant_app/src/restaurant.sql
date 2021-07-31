/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:8889
 Source Schema         : restaurant

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 31/07/2021 13:46:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for guest
-- ----------------------------
DROP TABLE IF EXISTS `guest`;
CREATE TABLE `guest` (
  `id_guest` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_guest`),
  UNIQUE KEY `uq_guest_username` (`username`),
  KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of guest
-- ----------------------------
BEGIN;
INSERT INTO `guest` VALUES (1, 'guest01', 'gost01');
INSERT INTO `guest` VALUES (2, 'guest02', 'gost02');
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id_menu` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `calories` int(10) unsigned NOT NULL,
  `price` decimal(10,2) unsigned NOT NULL,
  PRIMARY KEY (`id_menu`),
  UNIQUE KEY `uq_menu_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, 'Pizza', 1500, 300.00);
INSERT INTO `menu` VALUES (2, 'Pancakes', 1300, 150.00);
INSERT INTO `menu` VALUES (3, 'Cake', 3400, 700.00);
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id_order` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `guest_username` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `id_menu` int(10) unsigned NOT NULL,
  `name_menu` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `portion_number` int(255) unsigned NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `fk_order_guest_username` (`guest_username`),
  KEY `fk_order_id_menu` (`id_menu`),
  CONSTRAINT `fk_order_guest_username` FOREIGN KEY (`guest_username`) REFERENCES `guest` (`username`) ON UPDATE CASCADE,
  CONSTRAINT `fk_order_id_menu` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES (1, 'guest01', 2, 'Pancakes', 3);
COMMIT;

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `id_worker` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_worker`),
  UNIQUE KEY `uq_worker_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of worker
-- ----------------------------
BEGIN;
INSERT INTO `worker` VALUES (1, 'worker01', 'radnik01');
INSERT INTO `worker` VALUES (2, 'worker02', 'radnik02');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
