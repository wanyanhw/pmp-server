-- 用户基本信息表
CREATE TABLE `person_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` int(1) NOT NULL COMMENT '性别，1-男，2-女',
  `birthday` varchar(10) DEFAULT NULL COMMENT '出生日期',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `create_user` varchar(100) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 用户关系信息表
CREATE TABLE `person_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `father_id` int(11) DEFAULT NULL COMMENT '父ID',
  `create_user` varchar(100) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(100) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
