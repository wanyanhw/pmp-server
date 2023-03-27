package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.model.PicOrderInfo;

/**
 * @author wanyanhw
 * @since 2023/3/27 14:23
 */
public interface OrderService {
   void save(PicOrderInfo order);
   PicOrderInfo getBinding(String openId);
}
