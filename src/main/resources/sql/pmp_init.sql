/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : pmp

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 08/05/2022 09:10:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_relationship
-- ----------------------------
DROP TABLE IF EXISTS `base_relationship`;
CREATE TABLE `base_relationship`  (
                                      `id` int(11) NOT NULL AUTO_INCREMENT,
                                      `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关系',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础关系表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `total` double(255, 2) NULL DEFAULT NULL,
  `consumer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `consume_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `operator` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
                           `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
                           `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
                           `status` int(1) NULL DEFAULT NULL COMMENT '状态（1-登录中，2-未登录，3-已锁定）',
                           `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '上次登录时间',
                           `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
                           `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                           `update_user` int(100) NULL DEFAULT NULL COMMENT '修改人',
                           `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
                           `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标识',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个人信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for person_archive
-- ----------------------------
DROP TABLE IF EXISTS `person_archive`;
CREATE TABLE `person_archive`  (
                                   `id` int(11) NOT NULL AUTO_INCREMENT,
                                   `person_id` int(11) NULL DEFAULT NULL COMMENT '个人ID',
                                   `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '照片文件路径',
                                   `mobile_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
                                   `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
                                   `sex` int(1) NULL DEFAULT NULL COMMENT '性别（1-男，2-女）',
                                   `birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
                                   `death_day` datetime(0) NULL DEFAULT NULL COMMENT '死亡日期',
                                   `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
                                   `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
                                   `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                                   `update_user` int(100) NULL DEFAULT NULL COMMENT '修改人',
                                   `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
                                   `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标识',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个人档案表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for person_relationship
-- ----------------------------
DROP TABLE IF EXISTS `person_relationship`;
CREATE TABLE `person_relationship`  (
                                        `id` int(11) NOT NULL AUTO_INCREMENT,
                                        `person_id` int(11) NOT NULL COMMENT '个人ID',
                                        `relation_id` int(11) NOT NULL COMMENT '关系',
                                        `relation_person_id` int(11) NOT NULL COMMENT '关系人ID',
                                        `create_user` int(11) NULL DEFAULT NULL COMMENT '创建人',
                                        `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                                        `update_user` int(11) NULL DEFAULT NULL COMMENT '修改人',
                                        `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
                                        `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标识',
                                        PRIMARY KEY (`id`) USING BTREE,
                                        INDEX `IDX_PERSION`(`person_id`, `relation_person_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个人关系表' ROW_FORMAT = DYNAMIC;

INSERT INTO `pmp`.`base_relationship`(`id`, `name`) VALUES (1, '父亲');
INSERT INTO `pmp`.`base_relationship`(`id`, `name`) VALUES (2, '母亲');
INSERT INTO `pmp`.`base_relationship`(`id`, `name`) VALUES (3, '儿子');
INSERT INTO `pmp`.`base_relationship`(`id`, `name`) VALUES (4, '女儿');
INSERT INTO `pmp`.`base_relationship`(`id`, `name`) VALUES (5, '妻子');
INSERT INTO `pmp`.`base_relationship`(`id`, `name`) VALUES (6, '丈夫');

SET FOREIGN_KEY_CHECKS = 1;