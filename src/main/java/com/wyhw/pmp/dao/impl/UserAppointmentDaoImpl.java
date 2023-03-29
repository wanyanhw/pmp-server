package com.wyhw.pmp.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyhw.pmp.dao.UserAppointmentDao;
import com.wyhw.pmp.entity.UserAppointment;
import com.wyhw.pmp.mapper.UserAppointmentMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户预约表 服务实现类
 * </p>
 *
 * @author wanyanhw
 * @since 2023-03-28
 */
@Service
public class UserAppointmentDaoImpl extends ServiceImpl<UserAppointmentMapper, UserAppointment> implements UserAppointmentDao {

}
