package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.model.UserAppointmentInfo;

/**
 * @author wanyanhw
 * @since 2023/3/27 14:23
 */
public interface UserAppointmentService {
   void save(UserAppointmentInfo order);
   UserAppointmentInfo getBinding(String openId);
}
