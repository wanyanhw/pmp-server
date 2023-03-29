package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.UserAppointmentDao;
import com.wyhw.pmp.entity.UserAppointment;
import com.wyhw.pmp.entity.model.UserAppointmentInfo;
import com.wyhw.pmp.service.ParseService;
import com.wyhw.pmp.service.UserAppointmentService;
import com.wyhw.pmp.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author wanyanhw
 * @since 2023/3/27 14:23
 */
@Service
@Slf4j
public class AppointmentServiceImpl implements UserAppointmentService, ParseService<UserAppointmentInfo, UserAppointment> {

    @Resource
    private UserAppointmentDao appointmentDao;

    @Override
    public void save(UserAppointmentInfo order) {
        Integer count = appointmentDao.lambdaQuery().eq(UserAppointment::getOpenId, order.getOpenId()).eq(UserAppointment::getStatus, 0).count();
        if (count > 0) {
            log.warn("用户{}预约单已提交", order.getOpenId());
            return;
        }
        appointmentDao.save(parse2Entity(order));
    }

    @Override
    public UserAppointmentInfo getBinding(String openId) {
        UserAppointment entity = appointmentDao.lambdaQuery().eq(UserAppointment::getOpenId, openId).one();
        return parse2Model(entity);
    }

    @Override
    public UserAppointment parse2Entity(UserAppointmentInfo info) {
        return new UserAppointment()
                .setId(info.getId())
                .setUsername(info.getName())
                .setDate(LocalDateTime.parse(info.getDate(), DateUtil.STANDARD_DATE))
                .setPhone(info.getPhone())
                .setAddress(info.getAddress())
                .setTypeId(info.getType())
                .setPacageId(info.getPackageId())
                .setOpenId(info.getOpenId());
    }

    @Override
    public UserAppointmentInfo parse2Model(UserAppointment entity) {
        return new UserAppointmentInfo()
                .setId(entity.getId())
                .setName(entity.getUsername())
                .setPhone(entity.getPhone())
                .setType(entity.getTypeId())
                .setPackageId(entity.getPacageId())
                .setAddress(entity.getAddress())
                .setStatus(entity.getStatus())
                .setCreateTime(entity.getCreateTime().format(DateUtil.STANDARD_DATE));
    }
}
