package com.wyhw.pmp.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyhw.pmp.dao.UserDao;
import com.wyhw.pmp.entity.UserEntity;
import com.wyhw.pmp.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserEntity> implements UserDao {
}
