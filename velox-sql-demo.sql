/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50623
 Source Host           : localhost:3307
 Source Schema         : velox-sql-demo

 Target Server Type    : MySQL
 Target Server Version : 50623
 File Encoding         : 65001

 Date: 05/06/2024 20:55:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `rights` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` tinyint(255) NULL DEFAULT NULL,
  `last_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `a`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3060986 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (29, 'myuser1', '123456', 'test', 'admin', '{1,2,7,0}', '/www/wwwroot/image/i.icon', 1, '2023-09-11 11:19:12');
INSERT INTO `tb_user` VALUES (30, 'myuser1', '123456', 'test', 'admin', '{1,2,7,0}', '/www/wwwroot/image/i.icon', 1, '2023-09-11 11:19:12');