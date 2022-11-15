/*
 Navicat MySQL Data Transfer

 Source Server         : 00本地
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : pmp

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 15/11/2022 19:22:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父ID',
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
) ENGINE = InnoDB AUTO_INCREMENT = 207 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个人信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (2, 0, 'wanyanfuqing', '123456', '完颜富清', 2, NULL, NULL, '2022-11-08 19:37:43', NULL, '2022-11-08 19:37:43', b'0');
INSERT INTO `person` VALUES (3, 2, 'wanyanguiting', '123456', '完颜贵廷', 2, NULL, NULL, '2022-11-08 19:52:09', NULL, '2022-11-08 19:52:09', b'0');
INSERT INTO `person` VALUES (4, 2, 'wanyanzhongting', '123456', '完颜中廷', 2, NULL, NULL, '2022-11-08 19:52:26', NULL, '2022-11-08 19:52:26', b'0');
INSERT INTO `person` VALUES (5, 2, 'wanyanyunting', '123456', '完颜允廷', 2, NULL, NULL, '2022-11-08 19:52:36', NULL, '2022-11-08 19:52:36', b'0');
INSERT INTO `person` VALUES (6, 3, 'wanyanxuemeng', '123456', '完颜学孟', 2, NULL, NULL, '2022-11-08 19:53:06', NULL, '2022-11-08 19:53:06', b'0');
INSERT INTO `person` VALUES (7, 3, 'wanyanxueyan', '123456', '完颜学言', 2, NULL, NULL, '2022-11-08 19:53:18', NULL, '2022-11-08 19:53:18', b'0');
INSERT INTO `person` VALUES (8, 3, 'wanyanxuesi', '123456', '完颜学思', 2, NULL, NULL, '2022-11-08 19:53:28', NULL, '2022-11-08 19:53:28', b'0');
INSERT INTO `person` VALUES (9, 4, 'wanyanxuekong', '123456', '完颜学孔', 2, NULL, NULL, '2022-11-08 19:53:50', NULL, '2022-11-08 19:53:50', b'0');
INSERT INTO `person` VALUES (10, 4, 'wanyanxueli', '123456', '完颜学礼', 2, NULL, NULL, '2022-11-08 19:54:03', NULL, '2022-11-08 19:54:03', b'0');
INSERT INTO `person` VALUES (11, 4, 'wanyanxuedian', '123456', '完颜学典', 2, NULL, NULL, '2022-11-08 19:54:12', NULL, '2022-11-08 19:54:12', b'0');
INSERT INTO `person` VALUES (12, 5, 'wanyanxuezeng', '123456', '完颜学增', 2, NULL, NULL, '2022-11-08 19:55:35', NULL, '2022-11-08 19:55:35', b'0');
INSERT INTO `person` VALUES (13, 5, 'laobaye', '123456', '完颜老八', 2, NULL, NULL, '2022-11-08 19:55:57', NULL, '2022-11-08 20:33:15', b'0');
INSERT INTO `person` VALUES (14, 6, 'wanyanmao', '123456', '完颜冒', 2, NULL, NULL, '2022-11-08 19:56:27', NULL, '2022-11-08 19:56:27', b'0');
INSERT INTO `person` VALUES (15, 6, 'wanyanbo', '123456', '完颜伯', 2, NULL, NULL, '2022-11-08 19:56:42', NULL, '2022-11-08 19:56:42', b'0');
INSERT INTO `person` VALUES (16, 6, 'wanyanchang', '123456', '完颜昌', 2, NULL, NULL, '2022-11-08 19:56:52', NULL, '2022-11-08 19:56:52', b'0');
INSERT INTO `person` VALUES (17, 7, 'wanyancai', '123456', '完颜彩', 2, NULL, NULL, '2022-11-08 19:57:29', NULL, '2022-11-08 19:57:29', b'0');
INSERT INTO `person` VALUES (18, 9, 'wanyanzhen', '123456', '完颜贞', 2, NULL, NULL, '2022-11-08 20:04:27', NULL, '2022-11-08 20:04:27', b'0');
INSERT INTO `person` VALUES (19, 9, 'wanyanhuai', '123456', '完颜怀', 2, NULL, NULL, '2022-11-08 20:04:39', NULL, '2022-11-08 20:04:39', b'0');
INSERT INTO `person` VALUES (20, 9, 'wanyanhuai', '123456', '完颜德', 2, NULL, NULL, '2022-11-08 20:04:45', NULL, '2022-11-08 20:04:45', b'0');
INSERT INTO `person` VALUES (21, 9, 'wanyanlu', '123456', '完颜鲁', 2, NULL, NULL, '2022-11-08 20:04:59', NULL, '2022-11-08 20:04:59', b'0');
INSERT INTO `person` VALUES (22, 10, 'wanyanju', '123456', '完颜聚', 2, NULL, NULL, '2022-11-08 20:05:23', NULL, '2022-11-08 20:05:23', b'0');
INSERT INTO `person` VALUES (23, 10, 'wanyanshan', '123456', '完颜山', 2, NULL, NULL, '2022-11-08 20:05:33', NULL, '2022-11-08 20:05:33', b'0');
INSERT INTO `person` VALUES (24, 11, 'wanyanxin', '123456', '完颜新', 2, NULL, NULL, '2022-11-08 20:05:58', NULL, '2022-11-08 20:05:58', b'0');
INSERT INTO `person` VALUES (25, 11, 'wanyancai', '123456', '完颜才', 2, NULL, NULL, '2022-11-08 20:06:04', NULL, '2022-11-08 20:06:04', b'0');
INSERT INTO `person` VALUES (26, 11, 'wanyansan', '123456', '完颜三', 2, NULL, NULL, '2022-11-08 20:06:45', NULL, '2022-11-08 20:06:45', b'0');
INSERT INTO `person` VALUES (27, 12, 'wanyanzhu', '123456', '完颜柱', 2, NULL, NULL, '2022-11-08 20:07:11', NULL, '2022-11-08 20:07:11', b'0');
INSERT INTO `person` VALUES (28, 12, 'wanyanyi', '123456', '完颜意', 2, NULL, NULL, '2022-11-08 20:07:21', NULL, '2022-11-08 20:07:21', b'0');
INSERT INTO `person` VALUES (29, 13, 'wanyanqingfu', '123456', '完颜庆福', 2, NULL, NULL, '2022-11-08 20:07:56', NULL, '2022-11-08 20:07:56', b'0');
INSERT INTO `person` VALUES (30, 16, 'wanyanjinyi', '123456', '完颜进一', 2, NULL, NULL, '2022-11-08 20:11:58', NULL, '2022-11-08 20:11:58', b'0');
INSERT INTO `person` VALUES (31, 16, 'wanyanxingyi', '123456', '完颜性一', 2, NULL, NULL, '2022-11-08 20:12:33', NULL, '2022-11-08 20:12:33', b'0');
INSERT INTO `person` VALUES (32, 16, 'wanyanxiuyi', '123456', '完颜修一', 2, NULL, NULL, '2022-11-08 20:12:39', NULL, '2022-11-08 20:12:39', b'0');
INSERT INTO `person` VALUES (33, 17, 'wanyannaoyi', '123456', '完颜闹一', 2, NULL, NULL, '2022-11-08 20:13:16', NULL, '2022-11-08 20:13:16', b'0');
INSERT INTO `person` VALUES (34, 17, 'wanyan', '123456', '完颜守一', 2, NULL, NULL, '2022-11-08 20:13:38', NULL, '2022-11-08 20:13:38', b'0');
INSERT INTO `person` VALUES (35, 17, 'wanyan', '123456', '完颜存一', 2, NULL, NULL, '2022-11-08 20:13:43', NULL, '2022-11-08 20:13:43', b'0');
INSERT INTO `person` VALUES (36, 18, 'wanyan', '123456', '完颜奎一', 2, NULL, NULL, '2022-11-08 20:13:58', NULL, '2022-11-08 20:13:58', b'0');
INSERT INTO `person` VALUES (37, 18, 'wanyan', '123456', '完颜精一', 2, NULL, NULL, '2022-11-08 20:14:01', NULL, '2022-11-08 20:14:01', b'0');
INSERT INTO `person` VALUES (38, 18, 'wanyan', '123456', '完颜成一', 2, NULL, NULL, '2022-11-08 20:14:04', NULL, '2022-11-08 20:14:04', b'0');
INSERT INTO `person` VALUES (39, 18, 'wanyan', '123456', '完颜静一', 2, NULL, NULL, '2022-11-08 20:14:08', NULL, '2022-11-08 20:14:08', b'0');
INSERT INTO `person` VALUES (40, 18, 'wanyan', '123456', '完颜群一', 2, NULL, NULL, '2022-11-08 20:14:12', NULL, '2022-11-08 20:14:12', b'0');
INSERT INTO `person` VALUES (41, 20, 'wanyan', '123456', '完颜明一', 2, NULL, NULL, '2022-11-08 20:14:48', NULL, '2022-11-08 20:14:48', b'0');
INSERT INTO `person` VALUES (42, 20, 'wanyan', '123456', '完颜俊一', 2, NULL, NULL, '2022-11-08 20:14:52', NULL, '2022-11-08 20:14:52', b'0');
INSERT INTO `person` VALUES (43, 20, 'wanyan', '123456', '完颜军一', 2, NULL, NULL, '2022-11-08 20:14:58', NULL, '2022-11-08 20:14:58', b'0');
INSERT INTO `person` VALUES (44, 20, 'wanyan', '123456', '完颜同一', 2, NULL, NULL, '2022-11-08 20:15:01', NULL, '2022-11-08 20:15:01', b'0');
INSERT INTO `person` VALUES (45, 21, 'wanyan', '123456', '完颜纯一', 2, NULL, NULL, '2022-11-08 20:15:15', NULL, '2022-11-08 20:15:15', b'0');
INSERT INTO `person` VALUES (46, 21, 'wanyan', '123456', '完颜化一', 2, NULL, NULL, '2022-11-08 20:15:18', NULL, '2022-11-08 20:15:18', b'0');
INSERT INTO `person` VALUES (47, 22, 'wanyan', '123456', '完颜备一', 2, NULL, NULL, '2022-11-08 20:15:39', NULL, '2022-11-08 20:15:39', b'0');
INSERT INTO `person` VALUES (48, 23, 'wanyan', '123456', '完颜敬一', 2, NULL, NULL, '2022-11-08 20:16:01', NULL, '2022-11-08 20:16:01', b'0');
INSERT INTO `person` VALUES (49, 24, 'wanyan', '123456', '完颜德一', 2, NULL, NULL, '2022-11-08 20:16:13', NULL, '2022-11-08 20:16:13', b'0');
INSERT INTO `person` VALUES (50, 25, 'wanyan', '123456', '完颜本一', 2, NULL, NULL, '2022-11-08 20:16:30', NULL, '2022-11-08 20:16:30', b'0');
INSERT INTO `person` VALUES (51, 27, 'wanyan', '123456', '完颜刘妮', 2, NULL, NULL, '2022-11-08 20:17:18', NULL, '2022-11-08 20:33:02', b'0');
INSERT INTO `person` VALUES (52, 28, 'wanyan', '123456', '完颜猴七', 2, NULL, NULL, '2022-11-08 20:17:42', NULL, '2022-11-08 20:33:06', b'0');
INSERT INTO `person` VALUES (53, 30, 'wanyan', '123456', '完颜有郡', 2, NULL, NULL, '2022-11-08 20:18:34', NULL, '2022-11-08 20:18:34', b'0');
INSERT INTO `person` VALUES (54, 30, 'wanyan', '123456', '完颜有领', 2, NULL, NULL, '2022-11-08 20:18:39', NULL, '2022-11-08 20:18:39', b'0');
INSERT INTO `person` VALUES (55, 31, 'wanyan', '123456', '完颜有杰', 2, NULL, NULL, '2022-11-08 20:18:55', NULL, '2022-11-08 20:18:55', b'0');
INSERT INTO `person` VALUES (56, 31, 'wanyan', '123456', '完颜有德', 2, NULL, NULL, '2022-11-08 20:18:58', NULL, '2022-11-08 20:18:58', b'0');
INSERT INTO `person` VALUES (57, 31, 'wanyan', '123456', '完颜有良', 2, NULL, NULL, '2022-11-08 20:19:02', NULL, '2022-11-08 20:19:02', b'0');
INSERT INTO `person` VALUES (58, 32, 'wanyan', '123456', '完颜有营', 2, NULL, NULL, '2022-11-08 20:19:22', NULL, '2022-11-08 20:19:22', b'0');
INSERT INTO `person` VALUES (59, 32, 'wanyan', '123456', '完颜有印', 2, NULL, NULL, '2022-11-08 20:19:27', NULL, '2022-11-08 20:19:27', b'0');
INSERT INTO `person` VALUES (60, 34, 'wanyan', '123456', '完颜有富', 2, NULL, NULL, '2022-11-08 20:19:52', NULL, '2022-11-08 20:19:52', b'0');
INSERT INTO `person` VALUES (61, 35, 'wanyan', '123456', '完颜有太', 2, NULL, NULL, '2022-11-08 20:20:08', NULL, '2022-11-08 20:20:08', b'0');
INSERT INTO `person` VALUES (62, 35, 'wanyan', '123456', '完颜有周', 2, NULL, NULL, '2022-11-08 20:20:12', NULL, '2022-11-08 20:20:12', b'0');
INSERT INTO `person` VALUES (63, 35, 'wanyan', '123456', '完颜有臣', 2, NULL, NULL, '2022-11-08 20:20:17', NULL, '2022-11-08 20:20:17', b'0');
INSERT INTO `person` VALUES (64, 35, 'wanyan', '123456', '完颜有扣', 2, NULL, NULL, '2022-11-08 20:20:23', NULL, '2022-11-08 20:20:23', b'0');
INSERT INTO `person` VALUES (65, 36, 'wanyan', '123456', '完颜有贤', 2, NULL, NULL, '2022-11-08 20:20:52', NULL, '2022-11-08 20:20:52', b'0');
INSERT INTO `person` VALUES (66, 37, 'wanyan', '123456', '完颜有举', 2, NULL, NULL, '2022-11-08 20:21:58', NULL, '2022-11-08 20:21:58', b'0');
INSERT INTO `person` VALUES (67, 37, 'wanyan', '123456', '完颜有丁', 2, NULL, NULL, '2022-11-08 20:22:04', NULL, '2022-11-08 20:22:04', b'0');
INSERT INTO `person` VALUES (68, 37, 'wanyan', '123456', '完颜有信', 2, NULL, NULL, '2022-11-08 20:22:07', NULL, '2022-11-08 20:22:07', b'0');
INSERT INTO `person` VALUES (69, 38, 'wanyan', '123456', '完颜有文', 2, NULL, NULL, '2022-11-08 20:22:24', NULL, '2022-11-08 20:22:24', b'0');
INSERT INTO `person` VALUES (70, 38, 'wanyan', '123456', '完颜有田', 2, NULL, NULL, '2022-11-08 20:22:27', NULL, '2022-11-08 20:22:27', b'0');
INSERT INTO `person` VALUES (71, 38, 'wanyan', '123456', '完颜有林', 2, NULL, NULL, '2022-11-08 20:22:32', NULL, '2022-11-08 20:22:32', b'0');
INSERT INTO `person` VALUES (72, 39, 'wanyan', '123456', '完颜有章', 2, NULL, NULL, '2022-11-08 20:23:03', NULL, '2022-11-08 20:23:03', b'0');
INSERT INTO `person` VALUES (73, 40, 'wanyan', '123456', '完颜有亮', 2, NULL, NULL, '2022-11-08 20:23:24', NULL, '2022-11-08 20:23:24', b'0');
INSERT INTO `person` VALUES (74, 40, 'wanyan', '123456', '完颜有仁', 2, NULL, NULL, '2022-11-08 20:23:28', NULL, '2022-11-08 20:23:28', b'0');
INSERT INTO `person` VALUES (75, 40, 'wanyan', '123456', '完颜有福', 2, NULL, NULL, '2022-11-08 20:23:34', NULL, '2022-11-08 20:23:34', b'0');
INSERT INTO `person` VALUES (76, 40, 'wanyan', '123456', '完颜有训', 2, NULL, NULL, '2022-11-08 20:23:37', NULL, '2022-11-08 20:23:37', b'0');
INSERT INTO `person` VALUES (77, 40, 'wanyan', '123456', '完颜有江', 2, NULL, NULL, '2022-11-08 20:23:42', NULL, '2022-11-08 20:23:42', b'0');
INSERT INTO `person` VALUES (78, 41, 'wanyan', '123456', '完颜有阁', 2, NULL, NULL, '2022-11-08 20:24:06', NULL, '2022-11-08 20:24:06', b'0');
INSERT INTO `person` VALUES (79, 42, 'wanyan', '123456', '完颜有奎', 2, NULL, NULL, '2022-11-08 20:24:22', NULL, '2022-11-08 20:24:22', b'0');
INSERT INTO `person` VALUES (80, 42, 'wanyan', '123456', '完颜有记', 2, NULL, NULL, '2022-11-08 20:24:26', NULL, '2022-11-08 20:24:26', b'0');
INSERT INTO `person` VALUES (81, 43, 'wanyan', '123456', '完颜有民', 2, NULL, NULL, '2022-11-08 20:24:43', NULL, '2022-11-08 20:24:43', b'0');
INSERT INTO `person` VALUES (82, 44, 'wanyan', '123456', '完颜有朋', 2, NULL, NULL, '2022-11-08 20:25:14', NULL, '2022-11-08 20:25:14', b'0');
INSERT INTO `person` VALUES (83, 44, 'wanyan', '123456', '完颜有东', 2, NULL, NULL, '2022-11-08 20:25:19', NULL, '2022-11-08 20:25:19', b'0');
INSERT INTO `person` VALUES (84, 44, 'wanyan', '123456', '完颜有泉', 2, NULL, NULL, '2022-11-08 20:25:25', NULL, '2022-11-08 20:25:25', b'0');
INSERT INTO `person` VALUES (85, 45, 'wanyan', '123456', '完颜有功', 2, NULL, NULL, '2022-11-08 20:25:42', NULL, '2022-11-08 20:25:42', b'0');
INSERT INTO `person` VALUES (86, 45, 'wanyan', '123456', '完颜有成', 2, NULL, NULL, '2022-11-08 20:25:47', NULL, '2022-11-08 20:25:47', b'0');
INSERT INTO `person` VALUES (87, 46, 'wanyan', '123456', '完颜有乾', 2, NULL, NULL, '2022-11-08 20:26:16', NULL, '2022-11-08 20:26:16', b'0');
INSERT INTO `person` VALUES (88, 46, 'wanyan', '123456', '完颜有志', 2, NULL, NULL, '2022-11-08 20:26:20', NULL, '2022-11-08 20:26:20', b'0');
INSERT INTO `person` VALUES (89, 46, 'wanyan', '123456', '完颜有啟', 2, NULL, NULL, '2022-11-08 20:26:50', NULL, '2022-11-08 20:26:50', b'0');
INSERT INTO `person` VALUES (90, 46, 'wanyan', '123456', '完颜有勇', 2, NULL, NULL, '2022-11-08 20:26:54', NULL, '2022-11-08 20:26:54', b'0');
INSERT INTO `person` VALUES (91, 46, 'wanyan', '123456', '完颜有见', 2, NULL, NULL, '2022-11-08 20:26:58', NULL, '2022-11-08 20:26:58', b'0');
INSERT INTO `person` VALUES (92, 46, 'wanyan', '123456', '完颜有固', 2, NULL, NULL, '2022-11-08 20:27:03', NULL, '2022-11-08 20:27:03', b'0');
INSERT INTO `person` VALUES (93, 47, 'wanyan', '123456', '完颜有辉', 2, NULL, NULL, '2022-11-08 20:27:39', NULL, '2022-11-08 20:27:39', b'0');
INSERT INTO `person` VALUES (94, 48, 'wanyan', '123456', '完颜秀荣', 2, NULL, NULL, '2022-11-08 20:28:05', NULL, '2022-11-08 20:28:05', b'0');
INSERT INTO `person` VALUES (95, 48, 'wanyan', '123456', '完颜秀真', 2, NULL, NULL, '2022-11-08 20:28:09', NULL, '2022-11-08 20:28:09', b'0');
INSERT INTO `person` VALUES (96, 48, 'wanyan', '123456', '完颜淑琴', 2, NULL, NULL, '2022-11-08 20:28:19', NULL, '2022-11-08 20:28:19', b'0');
INSERT INTO `person` VALUES (97, 48, 'wanyan', '123456', '完颜淑华', 2, NULL, NULL, '2022-11-08 20:28:27', NULL, '2022-11-08 20:28:27', b'0');
INSERT INTO `person` VALUES (98, 49, 'wanyan', '123456', '完颜有斌', 2, NULL, NULL, '2022-11-08 20:32:13', NULL, '2022-11-08 20:32:13', b'0');
INSERT INTO `person` VALUES (99, 49, 'wanyan', '123456', '完颜有山', 2, NULL, NULL, '2022-11-08 20:32:16', NULL, '2022-11-08 20:32:16', b'0');
INSERT INTO `person` VALUES (100, 50, 'wanyan', '123456', '完颜有范', 2, NULL, NULL, '2022-11-08 20:32:35', NULL, '2022-11-08 20:32:35', b'0');
INSERT INTO `person` VALUES (101, 50, 'wanyan', '123456', '完颜有锋', 2, NULL, NULL, '2022-11-08 20:32:41', NULL, '2022-11-08 20:32:41', b'0');
INSERT INTO `person` VALUES (102, 53, 'wanyan', '123456', '完颜成风', 2, NULL, NULL, '2022-11-08 20:34:03', NULL, '2022-11-08 20:34:03', b'0');
INSERT INTO `person` VALUES (103, 53, 'wanyan', '123456', '完颜成国', 2, NULL, NULL, '2022-11-08 20:34:05', NULL, '2022-11-08 20:34:05', b'0');
INSERT INTO `person` VALUES (104, 53, 'wanyan', '123456', '完颜成芳', 2, NULL, NULL, '2022-11-08 20:34:10', NULL, '2022-11-08 20:34:10', b'0');
INSERT INTO `person` VALUES (105, 55, 'wanyan', '123456', '完颜化允', 2, NULL, NULL, '2022-11-08 20:34:27', NULL, '2022-11-08 20:34:53', b'0');
INSERT INTO `person` VALUES (106, 56, 'wanyan', '123456', '完颜刘坤', 2, NULL, NULL, '2022-11-08 20:35:22', NULL, '2022-11-08 20:35:22', b'0');
INSERT INTO `person` VALUES (107, 57, 'wanyan', '123456', '完颜亚磊', 2, NULL, NULL, '2022-11-08 20:35:37', NULL, '2022-11-08 20:35:37', b'0');
INSERT INTO `person` VALUES (108, 58, 'wanyan', '123456', '完颜伟伟', 2, NULL, NULL, '2022-11-08 20:35:50', NULL, '2022-11-08 20:35:50', b'0');
INSERT INTO `person` VALUES (109, 58, 'wanyan', '123456', '完颜宏伟', 2, NULL, NULL, '2022-11-08 20:35:54', NULL, '2022-11-08 20:35:54', b'0');
INSERT INTO `person` VALUES (110, 59, 'wanyan', '123456', '完颜路路', 2, NULL, NULL, '2022-11-08 20:36:09', NULL, '2022-11-08 20:36:09', b'0');
INSERT INTO `person` VALUES (111, 60, 'wanyan', '123456', '完颜建华', 2, NULL, NULL, '2022-11-08 20:36:26', NULL, '2022-11-08 20:36:26', b'0');
INSERT INTO `person` VALUES (112, 60, 'wanyan', '123456', '完颜玉华', 2, NULL, NULL, '2022-11-08 20:36:31', NULL, '2022-11-08 20:36:31', b'0');
INSERT INTO `person` VALUES (113, 60, 'wanyan', '123456', '完颜国华', 2, NULL, NULL, '2022-11-08 20:36:35', NULL, '2022-11-08 20:36:35', b'0');
INSERT INTO `person` VALUES (114, 61, 'wanyan', '123456', '完焰', 2, NULL, NULL, '2022-11-08 20:37:38', NULL, '2022-11-08 20:37:38', b'0');
INSERT INTO `person` VALUES (115, 61, 'wanyan', '123456', '完铮', 2, NULL, NULL, '2022-11-08 20:37:48', NULL, '2022-11-08 20:37:48', b'0');
INSERT INTO `person` VALUES (116, 61, 'wanyan', '123456', '完石', 2, NULL, NULL, '2022-11-08 20:37:52', NULL, '2022-11-08 20:37:52', b'0');
INSERT INTO `person` VALUES (117, 62, 'wanyan', '123456', '完颜成杰', 2, NULL, NULL, '2022-11-08 20:38:52', NULL, '2022-11-08 20:38:52', b'0');
INSERT INTO `person` VALUES (118, 63, 'wanyan', '123456', '完颜成林', 2, NULL, NULL, '2022-11-08 20:39:06', NULL, '2022-11-08 20:39:06', b'0');
INSERT INTO `person` VALUES (119, 63, 'wanyan', '123456', '完颜成典', 2, NULL, NULL, '2022-11-08 20:39:12', NULL, '2022-11-08 20:39:12', b'0');
INSERT INTO `person` VALUES (120, 65, 'wanyan', '123456', '完颜成良', 2, NULL, NULL, '2022-11-08 20:39:40', NULL, '2022-11-08 20:39:40', b'0');
INSERT INTO `person` VALUES (121, 65, 'wanyan', '123456', '完颜自华', 2, NULL, NULL, '2022-11-08 20:39:46', NULL, '2022-11-08 20:39:46', b'0');
INSERT INTO `person` VALUES (122, 68, 'wanyan', '123456', '完颜成修', 2, NULL, NULL, '2022-11-08 20:40:17', NULL, '2022-11-08 20:40:17', b'0');
INSERT INTO `person` VALUES (123, 68, 'wanyan', '123456', '完颜成中', 2, NULL, NULL, '2022-11-08 20:40:20', NULL, '2022-11-08 20:40:20', b'0');
INSERT INTO `person` VALUES (124, 70, 'wanyan', '123456', '完颜成功', 2, NULL, NULL, '2022-11-08 20:40:39', NULL, '2022-11-08 20:40:39', b'0');
INSERT INTO `person` VALUES (125, 70, 'wanyan', '123456', '完颜成志', 2, NULL, NULL, '2022-11-08 20:40:42', NULL, '2022-11-08 20:40:42', b'0');
INSERT INTO `person` VALUES (126, 71, 'wanyan', '123456', '完颜自然', 2, NULL, NULL, '2022-11-08 20:41:29', NULL, '2022-11-08 20:41:29', b'0');
INSERT INTO `person` VALUES (127, 71, 'wanyan', '123456', '完颜成鑫', 2, NULL, NULL, '2022-11-08 20:41:38', NULL, '2022-11-08 20:41:38', b'0');
INSERT INTO `person` VALUES (128, 71, 'wanyan', '123456', '完颜成超', 2, NULL, NULL, '2022-11-08 20:41:42', NULL, '2022-11-08 20:41:42', b'0');
INSERT INTO `person` VALUES (129, 72, 'wanyan', '123456', '完颜成珍', 2, NULL, NULL, '2022-11-08 20:42:08', NULL, '2022-11-08 20:42:08', b'0');
INSERT INTO `person` VALUES (130, 72, 'wanyan', '123456', '完颜成立', 2, NULL, NULL, '2022-11-08 20:42:13', NULL, '2022-11-08 20:42:13', b'0');
INSERT INTO `person` VALUES (131, 72, 'wanyan', '123456', '完颜成玉', 2, NULL, NULL, '2022-11-08 20:42:24', NULL, '2022-11-08 20:42:24', b'0');
INSERT INTO `person` VALUES (132, 73, 'wanyan', '123456', '完颜成彬', 2, NULL, NULL, '2022-11-08 20:42:57', NULL, '2022-11-08 20:42:57', b'0');
INSERT INTO `person` VALUES (133, 73, 'wanyan', '123456', '完颜成河', 2, NULL, NULL, '2022-11-08 20:43:03', NULL, '2022-11-08 20:43:03', b'0');
INSERT INTO `person` VALUES (134, 73, 'wanyan', '123456', '完颜国强', 2, NULL, NULL, '2022-11-08 20:43:07', NULL, '2022-11-09 10:58:36', b'0');
INSERT INTO `person` VALUES (135, 73, 'wanyan', '123456', '完颜国振', 2, NULL, NULL, '2022-11-08 20:43:21', NULL, '2022-11-08 20:43:21', b'0');
INSERT INTO `person` VALUES (136, 74, 'wanyan', '123456', '完颜自栋', 2, NULL, NULL, '2022-11-08 20:43:48', NULL, '2022-11-08 20:43:48', b'0');
INSERT INTO `person` VALUES (137, 74, 'wanyan', '123456', '完颜成生', 2, NULL, NULL, '2022-11-08 20:43:54', NULL, '2022-11-08 20:43:54', b'0');
INSERT INTO `person` VALUES (138, 74, 'wanyan', '123456', '完颜卫东', 2, NULL, NULL, '2022-11-08 20:43:58', NULL, '2022-11-08 20:43:58', b'0');
INSERT INTO `person` VALUES (139, 74, 'wanyan', '123456', '完颜卫国', 2, NULL, NULL, '2022-11-08 20:44:03', NULL, '2022-11-08 20:44:03', b'0');
INSERT INTO `person` VALUES (140, 74, 'wanyan', '123456', '完颜露梅', 2, NULL, NULL, '2022-11-08 20:44:45', NULL, '2022-11-08 20:44:45', b'0');
INSERT INTO `person` VALUES (141, 75, 'wanyan', '123456', '完颜振华', 2, NULL, NULL, '2022-11-08 20:45:00', NULL, '2022-11-08 20:45:00', b'0');
INSERT INTO `person` VALUES (142, 76, 'wanyan', '123456', '完颜自新', 2, NULL, NULL, '2022-11-08 20:45:25', NULL, '2022-11-09 11:01:24', b'0');
INSERT INTO `person` VALUES (143, 76, 'wanyan', '123456', '完颜成璟', 2, NULL, NULL, '2022-11-08 20:45:34', NULL, '2022-11-08 20:45:34', b'0');
INSERT INTO `person` VALUES (144, 76, 'wanyan', '123456', '完颜成君', 2, NULL, NULL, '2022-11-08 20:45:39', NULL, '2022-11-08 20:45:39', b'0');
INSERT INTO `person` VALUES (145, 77, 'wanyan', '123456', '完颜成会', 2, NULL, NULL, '2022-11-08 20:46:01', NULL, '2022-11-09 11:02:55', b'0');
INSERT INTO `person` VALUES (146, 77, 'wanyan', '123456', '完颜成兴', 2, NULL, NULL, '2022-11-08 20:46:07', NULL, '2022-11-08 20:46:07', b'0');
INSERT INTO `person` VALUES (147, 77, 'wanyan', '123456', '完颜国营', 2, NULL, NULL, '2022-11-08 20:46:13', NULL, '2022-11-09 11:03:21', b'0');
INSERT INTO `person` VALUES (148, 77, 'wanyan', '123456', '完颜莹莹', 2, NULL, NULL, '2022-11-08 20:46:23', NULL, '2022-11-08 20:46:23', b'0');
INSERT INTO `person` VALUES (149, 78, 'wanyan', '123456', '完颜祥雨', 2, NULL, NULL, '2022-11-08 20:46:55', NULL, '2022-11-08 20:46:55', b'0');
INSERT INTO `person` VALUES (150, 78, 'wanyan', '123456', '完颜祥龙', 2, NULL, NULL, '2022-11-08 20:46:58', NULL, '2022-11-08 20:46:58', b'0');
INSERT INTO `person` VALUES (151, 79, 'wanyan', '123456', '完颜祥华', 2, NULL, NULL, '2022-11-08 20:47:16', NULL, '2022-11-08 20:47:16', b'0');
INSERT INTO `person` VALUES (152, 80, 'wanyan', '123456', '完颜成帅', 2, NULL, NULL, '2022-11-08 20:47:39', NULL, '2022-11-08 20:47:39', b'0');
INSERT INTO `person` VALUES (153, 80, 'wanyan', '123456', '完颜成伦', 2, NULL, NULL, '2022-11-08 20:47:44', NULL, '2022-11-08 20:47:44', b'0');
INSERT INTO `person` VALUES (154, 81, 'wanyan', '123456', '完颜华宣', 2, NULL, NULL, '2022-11-08 20:48:05', NULL, '2022-11-08 20:48:05', b'0');
INSERT INTO `person` VALUES (155, 82, 'wanyan', '123456', '完颜进京', 2, NULL, NULL, '2022-11-08 20:48:19', NULL, '2022-11-08 20:48:19', b'0');
INSERT INTO `person` VALUES (156, 82, 'wanyan', '123456', '完颜进朝', 2, NULL, NULL, '2022-11-08 20:48:23', NULL, '2022-11-08 20:48:23', b'0');
INSERT INTO `person` VALUES (157, 83, 'wanyan', '123456', '完颜爽爽', 2, NULL, NULL, '2022-11-08 20:48:47', NULL, '2022-11-08 20:48:47', b'0');
INSERT INTO `person` VALUES (158, 83, 'wanyan', '123456', '完颜玉帅', 2, NULL, NULL, '2022-11-08 20:48:53', NULL, '2022-11-08 20:48:53', b'0');
INSERT INTO `person` VALUES (159, 84, 'wanyan', '123456', '完颜祥峰', 2, NULL, NULL, '2022-11-08 20:49:13', NULL, '2022-11-08 20:49:13', b'0');
INSERT INTO `person` VALUES (160, 85, 'wanyan', '123456', '完颜自星', 2, NULL, NULL, '2022-11-08 20:49:40', NULL, '2022-11-08 20:49:40', b'0');
INSERT INTO `person` VALUES (161, 85, 'wanyan', '123456', '完颜国党', 2, NULL, NULL, '2022-11-08 20:49:46', NULL, '2022-11-08 20:49:46', b'0');
INSERT INTO `person` VALUES (162, 85, 'wanyan', '123456', '完颜建党', 2, NULL, NULL, '2022-11-08 20:49:50', NULL, '2022-11-08 20:49:50', b'0');
INSERT INTO `person` VALUES (163, 86, 'wanyan', '123456', '完颜成辉', 2, NULL, NULL, '2022-11-08 20:50:08', NULL, '2022-11-08 20:50:08', b'0');
INSERT INTO `person` VALUES (164, 87, 'wanyan', '123456', '完颜成慧', 2, NULL, NULL, '2022-11-08 20:50:29', NULL, '2022-11-08 20:50:29', b'0');
INSERT INTO `person` VALUES (165, 87, 'wanyan', '123456', '完颜成学', 2, NULL, NULL, '2022-11-08 20:50:33', NULL, '2022-11-08 20:50:33', b'0');
INSERT INTO `person` VALUES (166, 88, 'wanyan', '123456', '完颜成海', 2, NULL, NULL, '2022-11-08 20:51:19', NULL, '2022-11-08 20:51:19', b'0');
INSERT INTO `person` VALUES (167, 88, 'wanyan', '123456', '完颜成金', 2, NULL, NULL, '2022-11-08 20:51:24', NULL, '2022-11-08 20:51:24', b'0');
INSERT INTO `person` VALUES (168, 90, 'wanyan', '123456', '完颜黎超', 2, NULL, NULL, '2022-11-08 20:52:03', NULL, '2022-11-08 20:52:03', b'0');
INSERT INTO `person` VALUES (169, 98, 'wanyan', '123456', '完颜成杰', 2, NULL, NULL, '2022-11-08 20:53:18', NULL, '2022-11-08 20:53:18', b'0');
INSERT INTO `person` VALUES (170, 99, 'wanyan', '123456', '完颜志强', 2, NULL, NULL, '2022-11-08 20:53:36', NULL, '2022-11-08 20:53:36', b'0');
INSERT INTO `person` VALUES (171, 99, 'wanyan', '123456', '完颜小娃', 2, NULL, NULL, '2022-11-08 20:53:41', NULL, '2022-11-08 20:53:41', b'0');
INSERT INTO `person` VALUES (172, 100, 'wanyan', '123456', '完颜成标', 2, NULL, NULL, '2022-11-08 20:53:56', NULL, '2022-11-08 20:53:56', b'0');
INSERT INTO `person` VALUES (173, 101, 'wanyan', '123456', '完颜留洋', 2, NULL, NULL, '2022-11-08 20:54:15', NULL, '2022-11-08 20:54:15', b'0');
INSERT INTO `person` VALUES (174, 102, 'wanyan', '123456', '完颜瑞猛', 2, NULL, NULL, '2022-11-09 10:48:22', NULL, '2022-11-09 10:48:22', b'0');
INSERT INTO `person` VALUES (175, 102, 'wanyan', '123456', '完颜春猛', 2, NULL, NULL, '2022-11-09 10:48:43', NULL, '2022-11-09 10:48:43', b'0');
INSERT INTO `person` VALUES (176, 102, 'wanyan', '123456', '完颜秋猛', 2, NULL, NULL, '2022-11-09 10:48:46', NULL, '2022-11-09 10:48:46', b'0');
INSERT INTO `person` VALUES (177, 103, 'wanyan', '123456', '完颜雪猛', 2, NULL, NULL, '2022-11-09 10:49:09', NULL, '2022-11-09 10:49:09', b'0');
INSERT INTO `person` VALUES (178, 111, 'wanyan', '123456', '完颜瑞光', 2, NULL, NULL, '2022-11-09 10:49:44', NULL, '2022-11-09 10:49:44', b'0');
INSERT INTO `person` VALUES (179, 111, 'wanyan', '123456', '完颜瑞红', 2, NULL, NULL, '2022-11-09 10:49:46', NULL, '2022-11-09 10:49:46', b'0');
INSERT INTO `person` VALUES (180, 114, 'wanyan', '123456', '完颜子甲', 2, NULL, NULL, '2022-11-09 10:50:16', NULL, '2022-11-09 10:50:16', b'0');
INSERT INTO `person` VALUES (181, 115, 'wanyan', '123456', '完颜子鹄', 2, NULL, NULL, '2022-11-09 10:50:55', NULL, '2022-11-09 10:50:55', b'0');
INSERT INTO `person` VALUES (182, 116, 'wanyan', '123456', '完颜子菁', 2, NULL, NULL, '2022-11-09 10:51:35', NULL, '2022-11-09 10:51:35', b'0');
INSERT INTO `person` VALUES (183, 120, 'wanyan', '123456', '完颜超奇', 2, NULL, NULL, '2022-11-09 10:52:08', NULL, '2022-11-09 10:52:08', b'0');
INSERT INTO `person` VALUES (184, 120, 'wanyan', '123456', '完颜付奇', 2, NULL, NULL, '2022-11-09 10:52:13', NULL, '2022-11-09 10:52:13', b'0');
INSERT INTO `person` VALUES (185, 122, 'wanyan', '123456', '完颜鹿奇', 2, NULL, NULL, '2022-11-09 10:52:46', NULL, '2022-11-09 10:52:46', b'0');
INSERT INTO `person` VALUES (186, 122, 'wanyan', '123456', '完颜站奇', 2, NULL, NULL, '2022-11-09 10:52:51', NULL, '2022-11-09 10:52:51', b'0');
INSERT INTO `person` VALUES (187, 122, 'wanyan', '123456', '完颜国奇', 2, NULL, NULL, '2022-11-09 10:52:53', NULL, '2022-11-09 10:52:53', b'0');
INSERT INTO `person` VALUES (188, 123, 'wanyan', '123456', '完颜双见', 2, NULL, NULL, '2022-11-09 10:53:23', NULL, '2022-11-09 10:53:23', b'0');
INSERT INTO `person` VALUES (189, 123, 'wanyan', '123456', '完颜环珍', 2, NULL, NULL, '2022-11-09 10:53:40', NULL, '2022-11-09 10:53:40', b'0');
INSERT INTO `person` VALUES (190, 125, 'wanyan', '123456', '完颜瑞见', 2, NULL, NULL, '2022-11-09 10:54:39', NULL, '2022-11-09 10:54:39', b'0');
INSERT INTO `person` VALUES (191, 125, 'wanyan', '123456', '完颜瑞芳', 2, NULL, NULL, '2022-11-09 10:54:42', NULL, '2022-11-09 10:54:42', b'0');
INSERT INTO `person` VALUES (192, 129, 'wanyan', '123456', '完颜迎宾', 2, NULL, NULL, '2022-11-09 10:55:27', NULL, '2022-11-09 10:55:27', b'0');
INSERT INTO `person` VALUES (193, 129, 'wanyan', '123456', '完颜贺宾', 2, NULL, NULL, '2022-11-09 10:55:36', NULL, '2022-11-09 10:55:36', b'0');
INSERT INTO `person` VALUES (194, 130, 'wanyan', '123456', '完颜县宾', 2, NULL, NULL, '2022-11-09 10:56:03', NULL, '2022-11-09 10:56:03', b'0');
INSERT INTO `person` VALUES (195, 130, 'wanyan', '123456', '完颜艳宾', 2, NULL, NULL, '2022-11-09 10:56:11', NULL, '2022-11-09 10:56:11', b'0');
INSERT INTO `person` VALUES (196, 131, 'wanyan', '123456', '完颜瑞宾', 2, NULL, NULL, '2022-11-09 10:56:54', NULL, '2022-11-09 10:56:54', b'0');
INSERT INTO `person` VALUES (197, 132, 'wanyan', '123456', '完颜艳辉', 2, NULL, NULL, '2022-11-09 10:57:19', NULL, '2022-11-09 10:57:19', b'0');
INSERT INTO `person` VALUES (198, 133, 'wanyan', '123456', '完颜青辉', 2, NULL, NULL, '2022-11-09 10:57:38', NULL, '2022-11-09 10:57:38', b'0');
INSERT INTO `person` VALUES (199, 134, 'wanyan', '123456', '完颜艳青', 2, NULL, NULL, '2022-11-09 10:58:08', NULL, '2022-11-09 10:58:08', b'0');
INSERT INTO `person` VALUES (200, 135, 'wanyan', '123456', '完颜予宋', 2, NULL, NULL, '2022-11-09 10:59:21', NULL, '2022-11-09 10:59:21', b'0');
INSERT INTO `person` VALUES (201, 136, 'wanyan', '123456', '完颜洪芳', 2, NULL, NULL, '2022-11-09 10:59:46', NULL, '2022-11-09 10:59:46', b'0');
INSERT INTO `person` VALUES (202, 137, 'wanyan', '123456', '完颜春芳', 2, NULL, NULL, '2022-11-09 11:00:03', NULL, '2022-11-09 11:00:03', b'0');
INSERT INTO `person` VALUES (203, 141, 'wanyan', '123456', '完颜亚亚', 2, NULL, NULL, '2022-11-09 11:00:26', NULL, '2022-11-09 11:00:26', b'0');
INSERT INTO `person` VALUES (204, 142, 'wanyan', '123456', '完颜亚辉', 2, NULL, NULL, '2022-11-09 11:02:18', NULL, '2022-11-09 11:02:18', b'0');
INSERT INTO `person` VALUES (205, 142, 'wanyan', '123456', '完颜光辉', 2, NULL, NULL, '2022-11-09 11:02:21', NULL, '2022-11-09 11:02:21', b'0');
INSERT INTO `person` VALUES (206, 161, 'wanyan', '123456', '完颜陈陈', 2, NULL, NULL, '2022-11-09 11:05:06', NULL, '2022-11-09 11:05:06', b'0');

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
) ENGINE = InnoDB AUTO_INCREMENT = 223 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个人档案表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person_archive
-- ----------------------------
INSERT INTO `person_archive` VALUES (18, 2, '', '', NULL, 1, NULL, NULL, NULL, NULL, '2022-11-08 19:37:43', NULL, '2022-11-08 19:37:43', b'0');
INSERT INTO `person_archive` VALUES (19, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:52:09', NULL, '2022-11-08 19:52:09', b'0');
INSERT INTO `person_archive` VALUES (20, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:52:26', NULL, '2022-11-08 19:52:26', b'0');
INSERT INTO `person_archive` VALUES (21, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:52:36', NULL, '2022-11-08 19:52:36', b'0');
INSERT INTO `person_archive` VALUES (22, 6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:53:06', NULL, '2022-11-08 19:53:06', b'0');
INSERT INTO `person_archive` VALUES (23, 7, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:53:18', NULL, '2022-11-08 19:53:18', b'0');
INSERT INTO `person_archive` VALUES (24, 8, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:53:28', NULL, '2022-11-08 19:53:28', b'0');
INSERT INTO `person_archive` VALUES (25, 9, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:53:50', NULL, '2022-11-08 19:53:50', b'0');
INSERT INTO `person_archive` VALUES (26, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:54:03', NULL, '2022-11-08 19:54:03', b'0');
INSERT INTO `person_archive` VALUES (27, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:54:12', NULL, '2022-11-08 19:54:12', b'0');
INSERT INTO `person_archive` VALUES (28, 12, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:55:35', NULL, '2022-11-08 19:55:35', b'0');
INSERT INTO `person_archive` VALUES (29, 13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:55:57', NULL, '2022-11-08 19:55:57', b'0');
INSERT INTO `person_archive` VALUES (30, 14, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:56:27', NULL, '2022-11-08 19:56:27', b'0');
INSERT INTO `person_archive` VALUES (31, 15, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:56:42', NULL, '2022-11-08 19:56:42', b'0');
INSERT INTO `person_archive` VALUES (32, 16, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:56:52', NULL, '2022-11-08 19:56:52', b'0');
INSERT INTO `person_archive` VALUES (33, 17, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 19:57:29', NULL, '2022-11-08 19:57:29', b'0');
INSERT INTO `person_archive` VALUES (34, 18, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:04:27', NULL, '2022-11-08 20:04:27', b'0');
INSERT INTO `person_archive` VALUES (35, 19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:04:39', NULL, '2022-11-08 20:04:39', b'0');
INSERT INTO `person_archive` VALUES (36, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:04:45', NULL, '2022-11-08 20:04:45', b'0');
INSERT INTO `person_archive` VALUES (37, 21, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:04:59', NULL, '2022-11-08 20:04:59', b'0');
INSERT INTO `person_archive` VALUES (38, 22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:05:23', NULL, '2022-11-08 20:05:23', b'0');
INSERT INTO `person_archive` VALUES (39, 23, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:05:33', NULL, '2022-11-08 20:05:33', b'0');
INSERT INTO `person_archive` VALUES (40, 24, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:05:58', NULL, '2022-11-08 20:05:58', b'0');
INSERT INTO `person_archive` VALUES (41, 25, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:06:04', NULL, '2022-11-08 20:06:04', b'0');
INSERT INTO `person_archive` VALUES (42, 26, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:06:45', NULL, '2022-11-08 20:06:45', b'0');
INSERT INTO `person_archive` VALUES (43, 27, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:07:11', NULL, '2022-11-08 20:07:11', b'0');
INSERT INTO `person_archive` VALUES (44, 28, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:07:21', NULL, '2022-11-08 20:07:21', b'0');
INSERT INTO `person_archive` VALUES (45, 29, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:07:56', NULL, '2022-11-08 20:07:56', b'0');
INSERT INTO `person_archive` VALUES (46, 30, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:11:58', NULL, '2022-11-08 20:11:58', b'0');
INSERT INTO `person_archive` VALUES (47, 31, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:12:33', NULL, '2022-11-08 20:12:33', b'0');
INSERT INTO `person_archive` VALUES (48, 32, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:12:39', NULL, '2022-11-08 20:12:39', b'0');
INSERT INTO `person_archive` VALUES (49, 33, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:13:16', NULL, '2022-11-08 20:13:16', b'0');
INSERT INTO `person_archive` VALUES (50, 34, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:13:38', NULL, '2022-11-08 20:13:38', b'0');
INSERT INTO `person_archive` VALUES (51, 35, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:13:43', NULL, '2022-11-08 20:13:43', b'0');
INSERT INTO `person_archive` VALUES (52, 36, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:13:58', NULL, '2022-11-08 20:13:58', b'0');
INSERT INTO `person_archive` VALUES (53, 37, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:14:01', NULL, '2022-11-08 20:14:01', b'0');
INSERT INTO `person_archive` VALUES (54, 38, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:14:04', NULL, '2022-11-08 20:14:04', b'0');
INSERT INTO `person_archive` VALUES (55, 39, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:14:08', NULL, '2022-11-08 20:14:08', b'0');
INSERT INTO `person_archive` VALUES (56, 40, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:14:12', NULL, '2022-11-08 20:14:12', b'0');
INSERT INTO `person_archive` VALUES (57, 41, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:14:48', NULL, '2022-11-08 20:14:48', b'0');
INSERT INTO `person_archive` VALUES (58, 42, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:14:52', NULL, '2022-11-08 20:14:52', b'0');
INSERT INTO `person_archive` VALUES (59, 43, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:14:58', NULL, '2022-11-08 20:14:58', b'0');
INSERT INTO `person_archive` VALUES (60, 44, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:15:01', NULL, '2022-11-08 20:15:01', b'0');
INSERT INTO `person_archive` VALUES (61, 45, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:15:15', NULL, '2022-11-08 20:15:15', b'0');
INSERT INTO `person_archive` VALUES (62, 46, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:15:18', NULL, '2022-11-08 20:15:18', b'0');
INSERT INTO `person_archive` VALUES (63, 47, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:15:39', NULL, '2022-11-08 20:15:39', b'0');
INSERT INTO `person_archive` VALUES (64, 48, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:16:01', NULL, '2022-11-08 20:16:01', b'0');
INSERT INTO `person_archive` VALUES (65, 49, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:16:13', NULL, '2022-11-08 20:16:13', b'0');
INSERT INTO `person_archive` VALUES (66, 50, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:16:30', NULL, '2022-11-08 20:16:30', b'0');
INSERT INTO `person_archive` VALUES (67, 51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:17:18', NULL, '2022-11-08 20:17:18', b'0');
INSERT INTO `person_archive` VALUES (68, 52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:17:42', NULL, '2022-11-08 20:17:42', b'0');
INSERT INTO `person_archive` VALUES (69, 53, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:18:34', NULL, '2022-11-08 20:18:34', b'0');
INSERT INTO `person_archive` VALUES (70, 54, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:18:39', NULL, '2022-11-08 20:18:39', b'0');
INSERT INTO `person_archive` VALUES (71, 55, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:18:55', NULL, '2022-11-08 20:18:55', b'0');
INSERT INTO `person_archive` VALUES (72, 56, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:18:58', NULL, '2022-11-08 20:18:58', b'0');
INSERT INTO `person_archive` VALUES (73, 57, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:19:02', NULL, '2022-11-08 20:19:02', b'0');
INSERT INTO `person_archive` VALUES (74, 58, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:19:22', NULL, '2022-11-08 20:19:22', b'0');
INSERT INTO `person_archive` VALUES (75, 59, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:19:27', NULL, '2022-11-08 20:19:27', b'0');
INSERT INTO `person_archive` VALUES (76, 60, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:19:52', NULL, '2022-11-08 20:19:52', b'0');
INSERT INTO `person_archive` VALUES (77, 61, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:20:08', NULL, '2022-11-08 20:20:08', b'0');
INSERT INTO `person_archive` VALUES (78, 62, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:20:12', NULL, '2022-11-08 20:20:12', b'0');
INSERT INTO `person_archive` VALUES (79, 63, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:20:17', NULL, '2022-11-08 20:20:17', b'0');
INSERT INTO `person_archive` VALUES (80, 64, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:20:23', NULL, '2022-11-08 20:20:23', b'0');
INSERT INTO `person_archive` VALUES (81, 65, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:20:52', NULL, '2022-11-08 20:20:52', b'0');
INSERT INTO `person_archive` VALUES (82, 66, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:21:58', NULL, '2022-11-08 20:21:58', b'0');
INSERT INTO `person_archive` VALUES (83, 67, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:22:04', NULL, '2022-11-08 20:22:04', b'0');
INSERT INTO `person_archive` VALUES (84, 68, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:22:07', NULL, '2022-11-08 20:22:07', b'0');
INSERT INTO `person_archive` VALUES (85, 69, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:22:24', NULL, '2022-11-08 20:22:24', b'0');
INSERT INTO `person_archive` VALUES (86, 70, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:22:27', NULL, '2022-11-08 20:22:27', b'0');
INSERT INTO `person_archive` VALUES (87, 71, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:22:32', NULL, '2022-11-08 20:22:32', b'0');
INSERT INTO `person_archive` VALUES (88, 72, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:23:03', NULL, '2022-11-08 20:23:03', b'0');
INSERT INTO `person_archive` VALUES (89, 73, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:23:24', NULL, '2022-11-08 20:23:24', b'0');
INSERT INTO `person_archive` VALUES (90, 74, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:23:28', NULL, '2022-11-08 20:23:28', b'0');
INSERT INTO `person_archive` VALUES (91, 75, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:23:34', NULL, '2022-11-08 20:23:34', b'0');
INSERT INTO `person_archive` VALUES (92, 76, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:23:37', NULL, '2022-11-08 20:23:37', b'0');
INSERT INTO `person_archive` VALUES (93, 77, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:23:42', NULL, '2022-11-08 20:23:42', b'0');
INSERT INTO `person_archive` VALUES (94, 78, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:24:06', NULL, '2022-11-08 20:24:06', b'0');
INSERT INTO `person_archive` VALUES (95, 79, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:24:22', NULL, '2022-11-08 20:24:22', b'0');
INSERT INTO `person_archive` VALUES (96, 80, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:24:26', NULL, '2022-11-08 20:24:26', b'0');
INSERT INTO `person_archive` VALUES (97, 81, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:24:43', NULL, '2022-11-08 20:24:43', b'0');
INSERT INTO `person_archive` VALUES (98, 82, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:25:14', NULL, '2022-11-08 20:25:14', b'0');
INSERT INTO `person_archive` VALUES (99, 83, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:25:19', NULL, '2022-11-08 20:25:19', b'0');
INSERT INTO `person_archive` VALUES (100, 84, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:25:25', NULL, '2022-11-08 20:25:25', b'0');
INSERT INTO `person_archive` VALUES (101, 85, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:25:42', NULL, '2022-11-08 20:25:42', b'0');
INSERT INTO `person_archive` VALUES (102, 86, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:25:47', NULL, '2022-11-08 20:25:47', b'0');
INSERT INTO `person_archive` VALUES (103, 87, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:26:16', NULL, '2022-11-08 20:26:16', b'0');
INSERT INTO `person_archive` VALUES (104, 88, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:26:20', NULL, '2022-11-08 20:26:20', b'0');
INSERT INTO `person_archive` VALUES (105, 89, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:26:50', NULL, '2022-11-08 20:26:50', b'0');
INSERT INTO `person_archive` VALUES (106, 90, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:26:54', NULL, '2022-11-08 20:26:54', b'0');
INSERT INTO `person_archive` VALUES (107, 91, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:26:58', NULL, '2022-11-08 20:26:58', b'0');
INSERT INTO `person_archive` VALUES (108, 92, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:27:03', NULL, '2022-11-08 20:27:03', b'0');
INSERT INTO `person_archive` VALUES (109, 93, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:27:39', NULL, '2022-11-08 20:27:39', b'0');
INSERT INTO `person_archive` VALUES (110, 94, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:28:05', NULL, '2022-11-08 20:28:05', b'0');
INSERT INTO `person_archive` VALUES (111, 95, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:28:09', NULL, '2022-11-08 20:28:09', b'0');
INSERT INTO `person_archive` VALUES (112, 96, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:28:19', NULL, '2022-11-08 20:28:19', b'0');
INSERT INTO `person_archive` VALUES (113, 97, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:28:27', NULL, '2022-11-08 20:28:27', b'0');
INSERT INTO `person_archive` VALUES (114, 98, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:32:13', NULL, '2022-11-08 20:32:13', b'0');
INSERT INTO `person_archive` VALUES (115, 99, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:32:16', NULL, '2022-11-08 20:32:16', b'0');
INSERT INTO `person_archive` VALUES (116, 100, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:32:35', NULL, '2022-11-08 20:32:35', b'0');
INSERT INTO `person_archive` VALUES (117, 101, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:32:41', NULL, '2022-11-08 20:32:41', b'0');
INSERT INTO `person_archive` VALUES (118, 102, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:34:03', NULL, '2022-11-08 20:34:03', b'0');
INSERT INTO `person_archive` VALUES (119, 103, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:34:05', NULL, '2022-11-08 20:34:05', b'0');
INSERT INTO `person_archive` VALUES (120, 104, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:34:10', NULL, '2022-11-08 20:34:10', b'0');
INSERT INTO `person_archive` VALUES (121, 105, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:34:27', NULL, '2022-11-08 20:34:27', b'0');
INSERT INTO `person_archive` VALUES (122, 106, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:35:22', NULL, '2022-11-08 20:35:22', b'0');
INSERT INTO `person_archive` VALUES (123, 107, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:35:37', NULL, '2022-11-08 20:35:37', b'0');
INSERT INTO `person_archive` VALUES (124, 108, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:35:50', NULL, '2022-11-08 20:35:50', b'0');
INSERT INTO `person_archive` VALUES (125, 109, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:35:54', NULL, '2022-11-08 20:35:54', b'0');
INSERT INTO `person_archive` VALUES (126, 110, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:36:09', NULL, '2022-11-08 20:36:09', b'0');
INSERT INTO `person_archive` VALUES (127, 111, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:36:26', NULL, '2022-11-08 20:36:26', b'0');
INSERT INTO `person_archive` VALUES (128, 112, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:36:31', NULL, '2022-11-08 20:36:31', b'0');
INSERT INTO `person_archive` VALUES (129, 113, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:36:35', NULL, '2022-11-08 20:36:35', b'0');
INSERT INTO `person_archive` VALUES (130, 114, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:37:38', NULL, '2022-11-08 20:37:38', b'0');
INSERT INTO `person_archive` VALUES (131, 115, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:37:48', NULL, '2022-11-08 20:37:48', b'0');
INSERT INTO `person_archive` VALUES (132, 116, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:37:52', NULL, '2022-11-08 20:37:52', b'0');
INSERT INTO `person_archive` VALUES (133, 117, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:38:52', NULL, '2022-11-08 20:38:52', b'0');
INSERT INTO `person_archive` VALUES (134, 118, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:39:06', NULL, '2022-11-08 20:39:06', b'0');
INSERT INTO `person_archive` VALUES (135, 119, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:39:12', NULL, '2022-11-08 20:39:12', b'0');
INSERT INTO `person_archive` VALUES (136, 120, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:39:40', NULL, '2022-11-08 20:39:40', b'0');
INSERT INTO `person_archive` VALUES (137, 121, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:39:46', NULL, '2022-11-08 20:39:46', b'0');
INSERT INTO `person_archive` VALUES (138, 122, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:40:17', NULL, '2022-11-08 20:40:17', b'0');
INSERT INTO `person_archive` VALUES (139, 123, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:40:20', NULL, '2022-11-08 20:40:20', b'0');
INSERT INTO `person_archive` VALUES (140, 124, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:40:39', NULL, '2022-11-08 20:40:39', b'0');
INSERT INTO `person_archive` VALUES (141, 125, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:40:42', NULL, '2022-11-08 20:40:42', b'0');
INSERT INTO `person_archive` VALUES (142, 126, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:41:29', NULL, '2022-11-08 20:41:29', b'0');
INSERT INTO `person_archive` VALUES (143, 127, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:41:38', NULL, '2022-11-08 20:41:38', b'0');
INSERT INTO `person_archive` VALUES (144, 128, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:41:42', NULL, '2022-11-08 20:41:42', b'0');
INSERT INTO `person_archive` VALUES (145, 129, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:42:08', NULL, '2022-11-08 20:42:08', b'0');
INSERT INTO `person_archive` VALUES (146, 130, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:42:13', NULL, '2022-11-08 20:42:13', b'0');
INSERT INTO `person_archive` VALUES (147, 131, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:42:24', NULL, '2022-11-08 20:42:24', b'0');
INSERT INTO `person_archive` VALUES (148, 132, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:42:57', NULL, '2022-11-08 20:42:57', b'0');
INSERT INTO `person_archive` VALUES (149, 133, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:43:03', NULL, '2022-11-08 20:43:03', b'0');
INSERT INTO `person_archive` VALUES (150, 134, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:43:07', NULL, '2022-11-08 20:43:07', b'0');
INSERT INTO `person_archive` VALUES (151, 135, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:43:21', NULL, '2022-11-08 20:43:21', b'0');
INSERT INTO `person_archive` VALUES (152, 136, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:43:48', NULL, '2022-11-08 20:43:48', b'0');
INSERT INTO `person_archive` VALUES (153, 137, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:43:54', NULL, '2022-11-08 20:43:54', b'0');
INSERT INTO `person_archive` VALUES (154, 138, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:43:58', NULL, '2022-11-08 20:43:58', b'0');
INSERT INTO `person_archive` VALUES (155, 139, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:44:03', NULL, '2022-11-08 20:44:03', b'0');
INSERT INTO `person_archive` VALUES (156, 140, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:44:45', NULL, '2022-11-08 20:44:45', b'0');
INSERT INTO `person_archive` VALUES (157, 141, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:45:00', NULL, '2022-11-08 20:45:00', b'0');
INSERT INTO `person_archive` VALUES (158, 142, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:45:25', NULL, '2022-11-08 20:45:25', b'0');
INSERT INTO `person_archive` VALUES (159, 143, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:45:34', NULL, '2022-11-08 20:45:34', b'0');
INSERT INTO `person_archive` VALUES (160, 144, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:45:39', NULL, '2022-11-08 20:45:39', b'0');
INSERT INTO `person_archive` VALUES (161, 145, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:46:01', NULL, '2022-11-08 20:46:01', b'0');
INSERT INTO `person_archive` VALUES (162, 146, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:46:07', NULL, '2022-11-08 20:46:07', b'0');
INSERT INTO `person_archive` VALUES (163, 147, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:46:13', NULL, '2022-11-08 20:46:13', b'0');
INSERT INTO `person_archive` VALUES (164, 148, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:46:23', NULL, '2022-11-08 20:46:23', b'0');
INSERT INTO `person_archive` VALUES (165, 149, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:46:55', NULL, '2022-11-08 20:46:55', b'0');
INSERT INTO `person_archive` VALUES (166, 150, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:46:58', NULL, '2022-11-08 20:46:58', b'0');
INSERT INTO `person_archive` VALUES (167, 151, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:47:16', NULL, '2022-11-08 20:47:16', b'0');
INSERT INTO `person_archive` VALUES (168, 152, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:47:39', NULL, '2022-11-08 20:47:39', b'0');
INSERT INTO `person_archive` VALUES (169, 153, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:47:44', NULL, '2022-11-08 20:47:44', b'0');
INSERT INTO `person_archive` VALUES (170, 154, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:48:05', NULL, '2022-11-08 20:48:05', b'0');
INSERT INTO `person_archive` VALUES (171, 155, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:48:19', NULL, '2022-11-08 20:48:19', b'0');
INSERT INTO `person_archive` VALUES (172, 156, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:48:23', NULL, '2022-11-08 20:48:23', b'0');
INSERT INTO `person_archive` VALUES (173, 157, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:48:47', NULL, '2022-11-08 20:48:47', b'0');
INSERT INTO `person_archive` VALUES (174, 158, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:48:53', NULL, '2022-11-08 20:48:53', b'0');
INSERT INTO `person_archive` VALUES (175, 159, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:49:13', NULL, '2022-11-08 20:49:13', b'0');
INSERT INTO `person_archive` VALUES (176, 160, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:49:40', NULL, '2022-11-08 20:49:40', b'0');
INSERT INTO `person_archive` VALUES (177, 161, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:49:46', NULL, '2022-11-08 20:49:46', b'0');
INSERT INTO `person_archive` VALUES (178, 162, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:49:50', NULL, '2022-11-08 20:49:50', b'0');
INSERT INTO `person_archive` VALUES (179, 163, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:50:08', NULL, '2022-11-08 20:50:08', b'0');
INSERT INTO `person_archive` VALUES (180, 164, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:50:29', NULL, '2022-11-08 20:50:29', b'0');
INSERT INTO `person_archive` VALUES (181, 165, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:50:33', NULL, '2022-11-08 20:50:33', b'0');
INSERT INTO `person_archive` VALUES (182, 166, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:51:19', NULL, '2022-11-08 20:51:19', b'0');
INSERT INTO `person_archive` VALUES (183, 167, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:51:24', NULL, '2022-11-08 20:51:24', b'0');
INSERT INTO `person_archive` VALUES (184, 168, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:52:03', NULL, '2022-11-08 20:52:03', b'0');
INSERT INTO `person_archive` VALUES (185, 169, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:53:18', NULL, '2022-11-08 20:53:18', b'0');
INSERT INTO `person_archive` VALUES (186, 170, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:53:36', NULL, '2022-11-08 20:53:36', b'0');
INSERT INTO `person_archive` VALUES (187, 171, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:53:41', NULL, '2022-11-08 20:53:41', b'0');
INSERT INTO `person_archive` VALUES (188, 172, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:53:56', NULL, '2022-11-08 20:53:56', b'0');
INSERT INTO `person_archive` VALUES (189, 173, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-08 20:54:15', NULL, '2022-11-08 20:54:15', b'0');
INSERT INTO `person_archive` VALUES (190, 174, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:48:22', NULL, '2022-11-09 10:48:22', b'0');
INSERT INTO `person_archive` VALUES (191, 175, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:48:43', NULL, '2022-11-09 10:48:43', b'0');
INSERT INTO `person_archive` VALUES (192, 176, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:48:46', NULL, '2022-11-09 10:48:46', b'0');
INSERT INTO `person_archive` VALUES (193, 177, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:49:09', NULL, '2022-11-09 10:49:09', b'0');
INSERT INTO `person_archive` VALUES (194, 178, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:49:44', NULL, '2022-11-09 10:49:44', b'0');
INSERT INTO `person_archive` VALUES (195, 179, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:49:46', NULL, '2022-11-09 10:49:46', b'0');
INSERT INTO `person_archive` VALUES (196, 180, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:50:16', NULL, '2022-11-09 10:50:16', b'0');
INSERT INTO `person_archive` VALUES (197, 181, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:50:55', NULL, '2022-11-09 10:50:55', b'0');
INSERT INTO `person_archive` VALUES (198, 182, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:51:35', NULL, '2022-11-09 10:51:35', b'0');
INSERT INTO `person_archive` VALUES (199, 183, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:52:08', NULL, '2022-11-09 10:52:08', b'0');
INSERT INTO `person_archive` VALUES (200, 184, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:52:13', NULL, '2022-11-09 10:52:13', b'0');
INSERT INTO `person_archive` VALUES (201, 185, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:52:46', NULL, '2022-11-09 10:52:46', b'0');
INSERT INTO `person_archive` VALUES (202, 186, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:52:51', NULL, '2022-11-09 10:52:51', b'0');
INSERT INTO `person_archive` VALUES (203, 187, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:52:53', NULL, '2022-11-09 10:52:53', b'0');
INSERT INTO `person_archive` VALUES (204, 188, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:53:23', NULL, '2022-11-09 10:53:23', b'0');
INSERT INTO `person_archive` VALUES (205, 189, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:53:40', NULL, '2022-11-09 10:53:40', b'0');
INSERT INTO `person_archive` VALUES (206, 190, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:54:39', NULL, '2022-11-09 10:54:39', b'0');
INSERT INTO `person_archive` VALUES (207, 191, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:54:42', NULL, '2022-11-09 10:54:42', b'0');
INSERT INTO `person_archive` VALUES (208, 192, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:55:27', NULL, '2022-11-09 10:55:27', b'0');
INSERT INTO `person_archive` VALUES (209, 193, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:55:36', NULL, '2022-11-09 10:55:36', b'0');
INSERT INTO `person_archive` VALUES (210, 194, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:56:03', NULL, '2022-11-09 10:56:03', b'0');
INSERT INTO `person_archive` VALUES (211, 195, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:56:11', NULL, '2022-11-09 10:56:11', b'0');
INSERT INTO `person_archive` VALUES (212, 196, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:56:54', NULL, '2022-11-09 10:56:54', b'0');
INSERT INTO `person_archive` VALUES (213, 197, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:57:19', NULL, '2022-11-09 10:57:19', b'0');
INSERT INTO `person_archive` VALUES (214, 198, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:57:38', NULL, '2022-11-09 10:57:38', b'0');
INSERT INTO `person_archive` VALUES (215, 199, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:58:08', NULL, '2022-11-09 10:58:08', b'0');
INSERT INTO `person_archive` VALUES (216, 200, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:59:21', NULL, '2022-11-09 10:59:21', b'0');
INSERT INTO `person_archive` VALUES (217, 201, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 10:59:46', NULL, '2022-11-09 10:59:46', b'0');
INSERT INTO `person_archive` VALUES (218, 202, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 11:00:03', NULL, '2022-11-09 11:00:03', b'0');
INSERT INTO `person_archive` VALUES (219, 203, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 11:00:26', NULL, '2022-11-09 11:00:26', b'0');
INSERT INTO `person_archive` VALUES (220, 204, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 11:02:18', NULL, '2022-11-09 11:02:18', b'0');
INSERT INTO `person_archive` VALUES (221, 205, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 11:02:21', NULL, '2022-11-09 11:02:21', b'0');
INSERT INTO `person_archive` VALUES (222, 206, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2022-11-09 11:05:06', NULL, '2022-11-09 11:05:06', b'0');

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
) ENGINE = InnoDB AUTO_INCREMENT = 205 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个人关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person_relationship
-- ----------------------------
INSERT INTO `person_relationship` VALUES (1, 2, 3, 3, NULL, '2022-11-08 19:52:09', NULL, '2022-11-08 19:52:09', b'0');
INSERT INTO `person_relationship` VALUES (2, 2, 3, 4, NULL, '2022-11-08 19:52:26', NULL, '2022-11-08 19:52:26', b'0');
INSERT INTO `person_relationship` VALUES (3, 2, 3, 5, NULL, '2022-11-08 19:52:36', NULL, '2022-11-08 19:52:36', b'0');
INSERT INTO `person_relationship` VALUES (4, 3, 3, 6, NULL, '2022-11-08 19:53:06', NULL, '2022-11-08 19:53:06', b'0');
INSERT INTO `person_relationship` VALUES (5, 3, 3, 7, NULL, '2022-11-08 19:53:18', NULL, '2022-11-08 19:53:18', b'0');
INSERT INTO `person_relationship` VALUES (6, 3, 3, 8, NULL, '2022-11-08 19:53:28', NULL, '2022-11-08 19:53:28', b'0');
INSERT INTO `person_relationship` VALUES (7, 4, 3, 9, NULL, '2022-11-08 19:53:50', NULL, '2022-11-08 19:53:50', b'0');
INSERT INTO `person_relationship` VALUES (8, 4, 3, 10, NULL, '2022-11-08 19:54:03', NULL, '2022-11-08 19:54:03', b'0');
INSERT INTO `person_relationship` VALUES (9, 4, 3, 11, NULL, '2022-11-08 19:54:12', NULL, '2022-11-08 19:54:12', b'0');
INSERT INTO `person_relationship` VALUES (10, 5, 3, 12, NULL, '2022-11-08 19:55:35', NULL, '2022-11-08 19:55:35', b'0');
INSERT INTO `person_relationship` VALUES (11, 5, 3, 13, NULL, '2022-11-08 19:55:57', NULL, '2022-11-08 19:55:57', b'0');
INSERT INTO `person_relationship` VALUES (12, 6, 3, 14, NULL, '2022-11-08 19:56:27', NULL, '2022-11-08 19:56:27', b'0');
INSERT INTO `person_relationship` VALUES (13, 6, 3, 15, NULL, '2022-11-08 19:56:42', NULL, '2022-11-08 19:56:42', b'0');
INSERT INTO `person_relationship` VALUES (14, 6, 3, 16, NULL, '2022-11-08 19:56:52', NULL, '2022-11-08 19:56:52', b'0');
INSERT INTO `person_relationship` VALUES (15, 7, 3, 17, NULL, '2022-11-08 19:57:29', NULL, '2022-11-08 19:57:29', b'0');
INSERT INTO `person_relationship` VALUES (16, 9, 3, 18, NULL, '2022-11-08 20:04:27', NULL, '2022-11-08 20:04:27', b'0');
INSERT INTO `person_relationship` VALUES (17, 9, 3, 19, NULL, '2022-11-08 20:04:39', NULL, '2022-11-08 20:04:39', b'0');
INSERT INTO `person_relationship` VALUES (18, 9, 3, 20, NULL, '2022-11-08 20:04:45', NULL, '2022-11-08 20:04:45', b'0');
INSERT INTO `person_relationship` VALUES (19, 9, 3, 21, NULL, '2022-11-08 20:04:59', NULL, '2022-11-08 20:04:59', b'0');
INSERT INTO `person_relationship` VALUES (20, 10, 3, 22, NULL, '2022-11-08 20:05:23', NULL, '2022-11-08 20:05:23', b'0');
INSERT INTO `person_relationship` VALUES (21, 10, 3, 23, NULL, '2022-11-08 20:05:33', NULL, '2022-11-08 20:05:33', b'0');
INSERT INTO `person_relationship` VALUES (22, 11, 3, 24, NULL, '2022-11-08 20:05:58', NULL, '2022-11-08 20:05:58', b'0');
INSERT INTO `person_relationship` VALUES (23, 11, 3, 25, NULL, '2022-11-08 20:06:04', NULL, '2022-11-08 20:06:04', b'0');
INSERT INTO `person_relationship` VALUES (24, 11, 3, 26, NULL, '2022-11-08 20:06:45', NULL, '2022-11-08 20:06:45', b'0');
INSERT INTO `person_relationship` VALUES (25, 12, 3, 27, NULL, '2022-11-08 20:07:11', NULL, '2022-11-08 20:07:11', b'0');
INSERT INTO `person_relationship` VALUES (26, 12, 3, 28, NULL, '2022-11-08 20:07:21', NULL, '2022-11-08 20:07:21', b'0');
INSERT INTO `person_relationship` VALUES (27, 13, 3, 29, NULL, '2022-11-08 20:07:56', NULL, '2022-11-08 20:07:56', b'0');
INSERT INTO `person_relationship` VALUES (28, 16, 3, 30, NULL, '2022-11-08 20:11:58', NULL, '2022-11-08 20:11:58', b'0');
INSERT INTO `person_relationship` VALUES (29, 16, 3, 31, NULL, '2022-11-08 20:12:33', NULL, '2022-11-08 20:12:33', b'0');
INSERT INTO `person_relationship` VALUES (30, 16, 3, 32, NULL, '2022-11-08 20:12:39', NULL, '2022-11-08 20:12:39', b'0');
INSERT INTO `person_relationship` VALUES (31, 17, 3, 33, NULL, '2022-11-08 20:13:16', NULL, '2022-11-08 20:13:16', b'0');
INSERT INTO `person_relationship` VALUES (32, 17, 3, 34, NULL, '2022-11-08 20:13:38', NULL, '2022-11-08 20:13:38', b'0');
INSERT INTO `person_relationship` VALUES (33, 17, 3, 35, NULL, '2022-11-08 20:13:43', NULL, '2022-11-08 20:13:43', b'0');
INSERT INTO `person_relationship` VALUES (34, 18, 3, 36, NULL, '2022-11-08 20:13:58', NULL, '2022-11-08 20:13:58', b'0');
INSERT INTO `person_relationship` VALUES (35, 18, 3, 37, NULL, '2022-11-08 20:14:01', NULL, '2022-11-08 20:14:01', b'0');
INSERT INTO `person_relationship` VALUES (36, 18, 3, 38, NULL, '2022-11-08 20:14:04', NULL, '2022-11-08 20:14:04', b'0');
INSERT INTO `person_relationship` VALUES (37, 18, 3, 39, NULL, '2022-11-08 20:14:08', NULL, '2022-11-08 20:14:08', b'0');
INSERT INTO `person_relationship` VALUES (38, 18, 3, 40, NULL, '2022-11-08 20:14:12', NULL, '2022-11-08 20:14:12', b'0');
INSERT INTO `person_relationship` VALUES (39, 20, 3, 41, NULL, '2022-11-08 20:14:48', NULL, '2022-11-08 20:14:48', b'0');
INSERT INTO `person_relationship` VALUES (40, 20, 3, 42, NULL, '2022-11-08 20:14:52', NULL, '2022-11-08 20:14:52', b'0');
INSERT INTO `person_relationship` VALUES (41, 20, 3, 43, NULL, '2022-11-08 20:14:58', NULL, '2022-11-08 20:14:58', b'0');
INSERT INTO `person_relationship` VALUES (42, 20, 3, 44, NULL, '2022-11-08 20:15:01', NULL, '2022-11-08 20:15:01', b'0');
INSERT INTO `person_relationship` VALUES (43, 21, 3, 45, NULL, '2022-11-08 20:15:15', NULL, '2022-11-08 20:15:15', b'0');
INSERT INTO `person_relationship` VALUES (44, 21, 3, 46, NULL, '2022-11-08 20:15:18', NULL, '2022-11-08 20:15:18', b'0');
INSERT INTO `person_relationship` VALUES (45, 22, 3, 47, NULL, '2022-11-08 20:15:39', NULL, '2022-11-08 20:15:39', b'0');
INSERT INTO `person_relationship` VALUES (46, 23, 3, 48, NULL, '2022-11-08 20:16:01', NULL, '2022-11-08 20:16:01', b'0');
INSERT INTO `person_relationship` VALUES (47, 24, 3, 49, NULL, '2022-11-08 20:16:13', NULL, '2022-11-08 20:16:13', b'0');
INSERT INTO `person_relationship` VALUES (48, 25, 3, 50, NULL, '2022-11-08 20:16:30', NULL, '2022-11-08 20:16:30', b'0');
INSERT INTO `person_relationship` VALUES (49, 27, 3, 51, NULL, '2022-11-08 20:17:18', NULL, '2022-11-08 20:17:18', b'0');
INSERT INTO `person_relationship` VALUES (50, 28, 3, 52, NULL, '2022-11-08 20:17:42', NULL, '2022-11-08 20:17:42', b'0');
INSERT INTO `person_relationship` VALUES (51, 30, 3, 53, NULL, '2022-11-08 20:18:34', NULL, '2022-11-08 20:18:34', b'0');
INSERT INTO `person_relationship` VALUES (52, 30, 3, 54, NULL, '2022-11-08 20:18:39', NULL, '2022-11-08 20:18:39', b'0');
INSERT INTO `person_relationship` VALUES (53, 31, 3, 55, NULL, '2022-11-08 20:18:55', NULL, '2022-11-08 20:18:55', b'0');
INSERT INTO `person_relationship` VALUES (54, 31, 3, 56, NULL, '2022-11-08 20:18:58', NULL, '2022-11-08 20:18:58', b'0');
INSERT INTO `person_relationship` VALUES (55, 31, 3, 57, NULL, '2022-11-08 20:19:02', NULL, '2022-11-08 20:19:02', b'0');
INSERT INTO `person_relationship` VALUES (56, 32, 3, 58, NULL, '2022-11-08 20:19:22', NULL, '2022-11-08 20:19:22', b'0');
INSERT INTO `person_relationship` VALUES (57, 32, 3, 59, NULL, '2022-11-08 20:19:27', NULL, '2022-11-08 20:19:27', b'0');
INSERT INTO `person_relationship` VALUES (58, 34, 3, 60, NULL, '2022-11-08 20:19:52', NULL, '2022-11-08 20:19:52', b'0');
INSERT INTO `person_relationship` VALUES (59, 35, 3, 61, NULL, '2022-11-08 20:20:08', NULL, '2022-11-08 20:20:08', b'0');
INSERT INTO `person_relationship` VALUES (60, 35, 3, 62, NULL, '2022-11-08 20:20:12', NULL, '2022-11-08 20:20:12', b'0');
INSERT INTO `person_relationship` VALUES (61, 35, 3, 63, NULL, '2022-11-08 20:20:17', NULL, '2022-11-08 20:20:17', b'0');
INSERT INTO `person_relationship` VALUES (62, 35, 3, 64, NULL, '2022-11-08 20:20:23', NULL, '2022-11-08 20:20:23', b'0');
INSERT INTO `person_relationship` VALUES (63, 36, 3, 65, NULL, '2022-11-08 20:20:52', NULL, '2022-11-08 20:20:52', b'0');
INSERT INTO `person_relationship` VALUES (64, 37, 3, 66, NULL, '2022-11-08 20:21:58', NULL, '2022-11-08 20:21:58', b'0');
INSERT INTO `person_relationship` VALUES (65, 37, 3, 67, NULL, '2022-11-08 20:22:04', NULL, '2022-11-08 20:22:04', b'0');
INSERT INTO `person_relationship` VALUES (66, 37, 3, 68, NULL, '2022-11-08 20:22:07', NULL, '2022-11-08 20:22:07', b'0');
INSERT INTO `person_relationship` VALUES (67, 38, 3, 69, NULL, '2022-11-08 20:22:24', NULL, '2022-11-08 20:22:24', b'0');
INSERT INTO `person_relationship` VALUES (68, 38, 3, 70, NULL, '2022-11-08 20:22:27', NULL, '2022-11-08 20:22:27', b'0');
INSERT INTO `person_relationship` VALUES (69, 38, 3, 71, NULL, '2022-11-08 20:22:32', NULL, '2022-11-08 20:22:32', b'0');
INSERT INTO `person_relationship` VALUES (70, 39, 3, 72, NULL, '2022-11-08 20:23:03', NULL, '2022-11-08 20:23:03', b'0');
INSERT INTO `person_relationship` VALUES (71, 40, 3, 73, NULL, '2022-11-08 20:23:24', NULL, '2022-11-08 20:23:24', b'0');
INSERT INTO `person_relationship` VALUES (72, 40, 3, 74, NULL, '2022-11-08 20:23:28', NULL, '2022-11-08 20:23:28', b'0');
INSERT INTO `person_relationship` VALUES (73, 40, 3, 75, NULL, '2022-11-08 20:23:34', NULL, '2022-11-08 20:23:34', b'0');
INSERT INTO `person_relationship` VALUES (74, 40, 3, 76, NULL, '2022-11-08 20:23:37', NULL, '2022-11-08 20:23:37', b'0');
INSERT INTO `person_relationship` VALUES (75, 40, 3, 77, NULL, '2022-11-08 20:23:42', NULL, '2022-11-08 20:23:42', b'0');
INSERT INTO `person_relationship` VALUES (76, 41, 3, 78, NULL, '2022-11-08 20:24:06', NULL, '2022-11-08 20:24:06', b'0');
INSERT INTO `person_relationship` VALUES (77, 42, 3, 79, NULL, '2022-11-08 20:24:22', NULL, '2022-11-08 20:24:22', b'0');
INSERT INTO `person_relationship` VALUES (78, 42, 3, 80, NULL, '2022-11-08 20:24:26', NULL, '2022-11-08 20:24:26', b'0');
INSERT INTO `person_relationship` VALUES (79, 43, 3, 81, NULL, '2022-11-08 20:24:43', NULL, '2022-11-08 20:24:43', b'0');
INSERT INTO `person_relationship` VALUES (80, 44, 3, 82, NULL, '2022-11-08 20:25:14', NULL, '2022-11-08 20:25:14', b'0');
INSERT INTO `person_relationship` VALUES (81, 44, 3, 83, NULL, '2022-11-08 20:25:19', NULL, '2022-11-08 20:25:19', b'0');
INSERT INTO `person_relationship` VALUES (82, 44, 3, 84, NULL, '2022-11-08 20:25:25', NULL, '2022-11-08 20:25:25', b'0');
INSERT INTO `person_relationship` VALUES (83, 45, 3, 85, NULL, '2022-11-08 20:25:42', NULL, '2022-11-08 20:25:42', b'0');
INSERT INTO `person_relationship` VALUES (84, 45, 3, 86, NULL, '2022-11-08 20:25:47', NULL, '2022-11-08 20:25:47', b'0');
INSERT INTO `person_relationship` VALUES (85, 46, 3, 87, NULL, '2022-11-08 20:26:16', NULL, '2022-11-08 20:26:16', b'0');
INSERT INTO `person_relationship` VALUES (86, 46, 3, 88, NULL, '2022-11-08 20:26:20', NULL, '2022-11-08 20:26:20', b'0');
INSERT INTO `person_relationship` VALUES (87, 46, 3, 89, NULL, '2022-11-08 20:26:50', NULL, '2022-11-08 20:26:50', b'0');
INSERT INTO `person_relationship` VALUES (88, 46, 3, 90, NULL, '2022-11-08 20:26:54', NULL, '2022-11-08 20:26:54', b'0');
INSERT INTO `person_relationship` VALUES (89, 46, 3, 91, NULL, '2022-11-08 20:26:58', NULL, '2022-11-08 20:26:58', b'0');
INSERT INTO `person_relationship` VALUES (90, 46, 3, 92, NULL, '2022-11-08 20:27:03', NULL, '2022-11-08 20:27:03', b'0');
INSERT INTO `person_relationship` VALUES (91, 47, 3, 93, NULL, '2022-11-08 20:27:39', NULL, '2022-11-08 20:27:39', b'0');
INSERT INTO `person_relationship` VALUES (92, 48, 4, 94, NULL, '2022-11-08 20:28:05', NULL, '2022-11-08 20:30:04', b'0');
INSERT INTO `person_relationship` VALUES (93, 48, 4, 95, NULL, '2022-11-08 20:28:09', NULL, '2022-11-08 20:30:04', b'0');
INSERT INTO `person_relationship` VALUES (94, 48, 4, 96, NULL, '2022-11-08 20:28:19', NULL, '2022-11-08 20:30:04', b'0');
INSERT INTO `person_relationship` VALUES (95, 48, 4, 97, NULL, '2022-11-08 20:28:27', NULL, '2022-11-08 20:30:04', b'0');
INSERT INTO `person_relationship` VALUES (96, 49, 3, 98, NULL, '2022-11-08 20:32:13', NULL, '2022-11-08 20:32:13', b'0');
INSERT INTO `person_relationship` VALUES (97, 49, 3, 99, NULL, '2022-11-08 20:32:16', NULL, '2022-11-08 20:32:16', b'0');
INSERT INTO `person_relationship` VALUES (98, 50, 3, 100, NULL, '2022-11-08 20:32:35', NULL, '2022-11-08 20:32:35', b'0');
INSERT INTO `person_relationship` VALUES (99, 50, 3, 101, NULL, '2022-11-08 20:32:41', NULL, '2022-11-08 20:32:41', b'0');
INSERT INTO `person_relationship` VALUES (100, 53, 3, 102, NULL, '2022-11-08 20:34:03', NULL, '2022-11-08 20:34:03', b'0');
INSERT INTO `person_relationship` VALUES (101, 53, 3, 103, NULL, '2022-11-08 20:34:05', NULL, '2022-11-08 20:34:05', b'0');
INSERT INTO `person_relationship` VALUES (102, 53, 3, 104, NULL, '2022-11-08 20:34:10', NULL, '2022-11-08 20:34:10', b'0');
INSERT INTO `person_relationship` VALUES (103, 55, 3, 105, NULL, '2022-11-08 20:34:27', NULL, '2022-11-08 20:34:27', b'0');
INSERT INTO `person_relationship` VALUES (104, 56, 3, 106, NULL, '2022-11-08 20:35:22', NULL, '2022-11-08 20:35:22', b'0');
INSERT INTO `person_relationship` VALUES (105, 57, 3, 107, NULL, '2022-11-08 20:35:37', NULL, '2022-11-08 20:35:37', b'0');
INSERT INTO `person_relationship` VALUES (106, 58, 3, 108, NULL, '2022-11-08 20:35:50', NULL, '2022-11-08 20:35:50', b'0');
INSERT INTO `person_relationship` VALUES (107, 58, 3, 109, NULL, '2022-11-08 20:35:54', NULL, '2022-11-08 20:35:54', b'0');
INSERT INTO `person_relationship` VALUES (108, 59, 3, 110, NULL, '2022-11-08 20:36:09', NULL, '2022-11-08 20:36:09', b'0');
INSERT INTO `person_relationship` VALUES (109, 60, 3, 111, NULL, '2022-11-08 20:36:26', NULL, '2022-11-08 20:36:26', b'0');
INSERT INTO `person_relationship` VALUES (110, 60, 3, 112, NULL, '2022-11-08 20:36:31', NULL, '2022-11-08 20:36:31', b'0');
INSERT INTO `person_relationship` VALUES (111, 60, 3, 113, NULL, '2022-11-08 20:36:35', NULL, '2022-11-08 20:36:35', b'0');
INSERT INTO `person_relationship` VALUES (112, 61, 3, 114, NULL, '2022-11-08 20:37:38', NULL, '2022-11-08 20:37:38', b'0');
INSERT INTO `person_relationship` VALUES (113, 61, 3, 115, NULL, '2022-11-08 20:37:48', NULL, '2022-11-08 20:37:48', b'0');
INSERT INTO `person_relationship` VALUES (114, 61, 3, 116, NULL, '2022-11-08 20:37:52', NULL, '2022-11-08 20:37:52', b'0');
INSERT INTO `person_relationship` VALUES (115, 62, 3, 117, NULL, '2022-11-08 20:38:52', NULL, '2022-11-08 20:38:52', b'0');
INSERT INTO `person_relationship` VALUES (116, 63, 3, 118, NULL, '2022-11-08 20:39:06', NULL, '2022-11-08 20:39:06', b'0');
INSERT INTO `person_relationship` VALUES (117, 63, 3, 119, NULL, '2022-11-08 20:39:12', NULL, '2022-11-08 20:39:12', b'0');
INSERT INTO `person_relationship` VALUES (118, 65, 3, 120, NULL, '2022-11-08 20:39:40', NULL, '2022-11-08 20:39:40', b'0');
INSERT INTO `person_relationship` VALUES (119, 65, 3, 121, NULL, '2022-11-08 20:39:46', NULL, '2022-11-08 20:39:46', b'0');
INSERT INTO `person_relationship` VALUES (120, 68, 3, 122, NULL, '2022-11-08 20:40:17', NULL, '2022-11-08 20:40:17', b'0');
INSERT INTO `person_relationship` VALUES (121, 68, 3, 123, NULL, '2022-11-08 20:40:20', NULL, '2022-11-08 20:40:20', b'0');
INSERT INTO `person_relationship` VALUES (122, 70, 3, 124, NULL, '2022-11-08 20:40:39', NULL, '2022-11-08 20:40:39', b'0');
INSERT INTO `person_relationship` VALUES (123, 70, 3, 125, NULL, '2022-11-08 20:40:42', NULL, '2022-11-08 20:40:42', b'0');
INSERT INTO `person_relationship` VALUES (124, 71, 3, 126, NULL, '2022-11-08 20:41:29', NULL, '2022-11-08 20:41:29', b'0');
INSERT INTO `person_relationship` VALUES (125, 71, 3, 127, NULL, '2022-11-08 20:41:38', NULL, '2022-11-08 20:41:38', b'0');
INSERT INTO `person_relationship` VALUES (126, 71, 3, 128, NULL, '2022-11-08 20:41:42', NULL, '2022-11-08 20:41:42', b'0');
INSERT INTO `person_relationship` VALUES (127, 72, 3, 129, NULL, '2022-11-08 20:42:08', NULL, '2022-11-08 20:42:08', b'0');
INSERT INTO `person_relationship` VALUES (128, 72, 3, 130, NULL, '2022-11-08 20:42:13', NULL, '2022-11-08 20:42:13', b'0');
INSERT INTO `person_relationship` VALUES (129, 72, 3, 131, NULL, '2022-11-08 20:42:24', NULL, '2022-11-08 20:42:24', b'0');
INSERT INTO `person_relationship` VALUES (130, 73, 3, 132, NULL, '2022-11-08 20:42:57', NULL, '2022-11-08 20:42:57', b'0');
INSERT INTO `person_relationship` VALUES (131, 73, 3, 133, NULL, '2022-11-08 20:43:03', NULL, '2022-11-08 20:43:03', b'0');
INSERT INTO `person_relationship` VALUES (132, 73, 3, 134, NULL, '2022-11-08 20:43:07', NULL, '2022-11-08 20:43:07', b'0');
INSERT INTO `person_relationship` VALUES (133, 73, 3, 135, NULL, '2022-11-08 20:43:21', NULL, '2022-11-08 20:43:21', b'0');
INSERT INTO `person_relationship` VALUES (134, 74, 3, 136, NULL, '2022-11-08 20:43:48', NULL, '2022-11-08 20:43:48', b'0');
INSERT INTO `person_relationship` VALUES (135, 74, 3, 137, NULL, '2022-11-08 20:43:54', NULL, '2022-11-08 20:43:54', b'0');
INSERT INTO `person_relationship` VALUES (136, 74, 3, 138, NULL, '2022-11-08 20:43:58', NULL, '2022-11-08 20:43:58', b'0');
INSERT INTO `person_relationship` VALUES (137, 74, 3, 139, NULL, '2022-11-08 20:44:03', NULL, '2022-11-08 20:44:03', b'0');
INSERT INTO `person_relationship` VALUES (138, 74, 4, 140, NULL, '2022-11-08 20:44:45', NULL, '2022-11-08 20:44:45', b'0');
INSERT INTO `person_relationship` VALUES (139, 75, 3, 141, NULL, '2022-11-08 20:45:00', NULL, '2022-11-08 20:45:00', b'0');
INSERT INTO `person_relationship` VALUES (140, 76, 3, 142, NULL, '2022-11-08 20:45:25', NULL, '2022-11-08 20:45:25', b'0');
INSERT INTO `person_relationship` VALUES (141, 76, 3, 143, NULL, '2022-11-08 20:45:34', NULL, '2022-11-08 20:45:34', b'0');
INSERT INTO `person_relationship` VALUES (142, 76, 3, 144, NULL, '2022-11-08 20:45:39', NULL, '2022-11-08 20:45:39', b'0');
INSERT INTO `person_relationship` VALUES (143, 77, 3, 145, NULL, '2022-11-08 20:46:01', NULL, '2022-11-08 20:46:01', b'0');
INSERT INTO `person_relationship` VALUES (144, 77, 3, 146, NULL, '2022-11-08 20:46:07', NULL, '2022-11-08 20:46:07', b'0');
INSERT INTO `person_relationship` VALUES (145, 77, 3, 147, NULL, '2022-11-08 20:46:13', NULL, '2022-11-08 20:46:13', b'0');
INSERT INTO `person_relationship` VALUES (146, 77, 4, 148, NULL, '2022-11-08 20:46:23', NULL, '2022-11-08 20:46:23', b'0');
INSERT INTO `person_relationship` VALUES (147, 78, 3, 149, NULL, '2022-11-08 20:46:55', NULL, '2022-11-08 20:46:55', b'0');
INSERT INTO `person_relationship` VALUES (148, 78, 3, 150, NULL, '2022-11-08 20:46:58', NULL, '2022-11-08 20:46:58', b'0');
INSERT INTO `person_relationship` VALUES (149, 79, 3, 151, NULL, '2022-11-08 20:47:16', NULL, '2022-11-08 20:47:16', b'0');
INSERT INTO `person_relationship` VALUES (150, 80, 3, 152, NULL, '2022-11-08 20:47:39', NULL, '2022-11-08 20:47:39', b'0');
INSERT INTO `person_relationship` VALUES (151, 80, 3, 153, NULL, '2022-11-08 20:47:44', NULL, '2022-11-08 20:47:44', b'0');
INSERT INTO `person_relationship` VALUES (152, 81, 3, 154, NULL, '2022-11-08 20:48:05', NULL, '2022-11-08 20:48:05', b'0');
INSERT INTO `person_relationship` VALUES (153, 82, 3, 155, NULL, '2022-11-08 20:48:19', NULL, '2022-11-08 20:48:19', b'0');
INSERT INTO `person_relationship` VALUES (154, 82, 3, 156, NULL, '2022-11-08 20:48:23', NULL, '2022-11-08 20:48:23', b'0');
INSERT INTO `person_relationship` VALUES (155, 83, 3, 157, NULL, '2022-11-08 20:48:47', NULL, '2022-11-08 20:48:47', b'0');
INSERT INTO `person_relationship` VALUES (156, 83, 3, 158, NULL, '2022-11-08 20:48:53', NULL, '2022-11-08 20:48:53', b'0');
INSERT INTO `person_relationship` VALUES (157, 84, 3, 159, NULL, '2022-11-08 20:49:13', NULL, '2022-11-08 20:49:13', b'0');
INSERT INTO `person_relationship` VALUES (158, 85, 3, 160, NULL, '2022-11-08 20:49:40', NULL, '2022-11-08 20:49:40', b'0');
INSERT INTO `person_relationship` VALUES (159, 85, 3, 161, NULL, '2022-11-08 20:49:46', NULL, '2022-11-08 20:49:46', b'0');
INSERT INTO `person_relationship` VALUES (160, 85, 3, 162, NULL, '2022-11-08 20:49:50', NULL, '2022-11-08 20:49:50', b'0');
INSERT INTO `person_relationship` VALUES (161, 86, 3, 163, NULL, '2022-11-08 20:50:08', NULL, '2022-11-08 20:50:08', b'0');
INSERT INTO `person_relationship` VALUES (162, 87, 3, 164, NULL, '2022-11-08 20:50:29', NULL, '2022-11-08 20:50:29', b'0');
INSERT INTO `person_relationship` VALUES (163, 87, 3, 165, NULL, '2022-11-08 20:50:33', NULL, '2022-11-08 20:50:33', b'0');
INSERT INTO `person_relationship` VALUES (164, 88, 3, 166, NULL, '2022-11-08 20:51:19', NULL, '2022-11-08 20:51:19', b'0');
INSERT INTO `person_relationship` VALUES (165, 88, 3, 167, NULL, '2022-11-08 20:51:24', NULL, '2022-11-08 20:51:24', b'0');
INSERT INTO `person_relationship` VALUES (166, 90, 3, 168, NULL, '2022-11-08 20:52:03', NULL, '2022-11-08 20:52:03', b'0');
INSERT INTO `person_relationship` VALUES (167, 98, 3, 169, NULL, '2022-11-08 20:53:18', NULL, '2022-11-08 20:53:18', b'0');
INSERT INTO `person_relationship` VALUES (168, 99, 3, 170, NULL, '2022-11-08 20:53:36', NULL, '2022-11-08 20:53:36', b'0');
INSERT INTO `person_relationship` VALUES (169, 99, 3, 171, NULL, '2022-11-08 20:53:41', NULL, '2022-11-08 20:53:41', b'0');
INSERT INTO `person_relationship` VALUES (170, 100, 3, 172, NULL, '2022-11-08 20:53:56', NULL, '2022-11-08 20:53:56', b'0');
INSERT INTO `person_relationship` VALUES (171, 101, 3, 173, NULL, '2022-11-08 20:54:15', NULL, '2022-11-08 20:54:15', b'0');
INSERT INTO `person_relationship` VALUES (172, 102, 3, 174, NULL, '2022-11-09 10:48:22', NULL, '2022-11-09 10:48:22', b'0');
INSERT INTO `person_relationship` VALUES (173, 102, 3, 175, NULL, '2022-11-09 10:48:43', NULL, '2022-11-09 10:48:43', b'0');
INSERT INTO `person_relationship` VALUES (174, 102, 3, 176, NULL, '2022-11-09 10:48:46', NULL, '2022-11-09 10:48:46', b'0');
INSERT INTO `person_relationship` VALUES (175, 103, 3, 177, NULL, '2022-11-09 10:49:09', NULL, '2022-11-09 10:49:09', b'0');
INSERT INTO `person_relationship` VALUES (176, 111, 3, 178, NULL, '2022-11-09 10:49:44', NULL, '2022-11-09 10:49:44', b'0');
INSERT INTO `person_relationship` VALUES (177, 111, 3, 179, NULL, '2022-11-09 10:49:46', NULL, '2022-11-09 10:49:46', b'0');
INSERT INTO `person_relationship` VALUES (178, 114, 3, 180, NULL, '2022-11-09 10:50:16', NULL, '2022-11-09 10:50:16', b'0');
INSERT INTO `person_relationship` VALUES (179, 115, 3, 181, NULL, '2022-11-09 10:50:55', NULL, '2022-11-09 10:50:55', b'0');
INSERT INTO `person_relationship` VALUES (180, 116, 4, 182, NULL, '2022-11-09 10:51:35', NULL, '2022-11-09 10:51:35', b'0');
INSERT INTO `person_relationship` VALUES (181, 120, 3, 183, NULL, '2022-11-09 10:52:08', NULL, '2022-11-09 10:52:08', b'0');
INSERT INTO `person_relationship` VALUES (182, 120, 3, 184, NULL, '2022-11-09 10:52:13', NULL, '2022-11-09 10:52:13', b'0');
INSERT INTO `person_relationship` VALUES (183, 122, 3, 185, NULL, '2022-11-09 10:52:46', NULL, '2022-11-09 10:52:46', b'0');
INSERT INTO `person_relationship` VALUES (184, 122, 3, 186, NULL, '2022-11-09 10:52:51', NULL, '2022-11-09 10:52:51', b'0');
INSERT INTO `person_relationship` VALUES (185, 122, 3, 187, NULL, '2022-11-09 10:52:53', NULL, '2022-11-09 10:52:53', b'0');
INSERT INTO `person_relationship` VALUES (186, 123, 3, 188, NULL, '2022-11-09 10:53:23', NULL, '2022-11-09 10:53:23', b'0');
INSERT INTO `person_relationship` VALUES (187, 123, 3, 189, NULL, '2022-11-09 10:53:40', NULL, '2022-11-09 10:53:40', b'0');
INSERT INTO `person_relationship` VALUES (188, 125, 3, 190, NULL, '2022-11-09 10:54:39', NULL, '2022-11-09 10:54:39', b'0');
INSERT INTO `person_relationship` VALUES (189, 125, 3, 191, NULL, '2022-11-09 10:54:42', NULL, '2022-11-09 10:54:42', b'0');
INSERT INTO `person_relationship` VALUES (190, 129, 3, 192, NULL, '2022-11-09 10:55:27', NULL, '2022-11-09 10:55:27', b'0');
INSERT INTO `person_relationship` VALUES (191, 129, 3, 193, NULL, '2022-11-09 10:55:36', NULL, '2022-11-09 10:55:36', b'0');
INSERT INTO `person_relationship` VALUES (192, 130, 3, 194, NULL, '2022-11-09 10:56:03', NULL, '2022-11-09 10:56:03', b'0');
INSERT INTO `person_relationship` VALUES (193, 130, 3, 195, NULL, '2022-11-09 10:56:11', NULL, '2022-11-09 10:56:11', b'0');
INSERT INTO `person_relationship` VALUES (194, 131, 3, 196, NULL, '2022-11-09 10:56:54', NULL, '2022-11-09 10:56:54', b'0');
INSERT INTO `person_relationship` VALUES (195, 132, 3, 197, NULL, '2022-11-09 10:57:19', NULL, '2022-11-09 10:57:19', b'0');
INSERT INTO `person_relationship` VALUES (196, 133, 3, 198, NULL, '2022-11-09 10:57:38', NULL, '2022-11-09 10:57:38', b'0');
INSERT INTO `person_relationship` VALUES (197, 134, 3, 199, NULL, '2022-11-09 10:58:08', NULL, '2022-11-09 10:58:08', b'0');
INSERT INTO `person_relationship` VALUES (198, 135, 3, 200, NULL, '2022-11-09 10:59:21', NULL, '2022-11-09 10:59:21', b'0');
INSERT INTO `person_relationship` VALUES (199, 136, 3, 201, NULL, '2022-11-09 10:59:46', NULL, '2022-11-09 10:59:46', b'0');
INSERT INTO `person_relationship` VALUES (200, 137, 3, 202, NULL, '2022-11-09 11:00:03', NULL, '2022-11-09 11:00:03', b'0');
INSERT INTO `person_relationship` VALUES (201, 141, 3, 203, NULL, '2022-11-09 11:00:26', NULL, '2022-11-09 11:00:26', b'0');
INSERT INTO `person_relationship` VALUES (202, 142, 3, 204, NULL, '2022-11-09 11:02:18', NULL, '2022-11-09 11:02:18', b'0');
INSERT INTO `person_relationship` VALUES (203, 142, 3, 205, NULL, '2022-11-09 11:02:21', NULL, '2022-11-09 11:02:21', b'0');
INSERT INTO `person_relationship` VALUES (204, 161, 3, 206, NULL, '2022-11-09 11:05:06', NULL, '2022-11-09 11:05:06', b'0');

SET FOREIGN_KEY_CHECKS = 1;
