-- pmp.person_info definition
CREATE TABLE `person_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` int(1) NOT NULL COMMENT '性别，1-男，2-女',
  `birthday` varchar(10) DEFAULT NULL COMMENT '出生日期',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `create_user` varchar(100) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标识',
  `father_id` int(11) DEFAULT NULL COMMENT '父亲ID',
  `spouse_id` int(11) DEFAULT NULL COMMENT '配偶ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

