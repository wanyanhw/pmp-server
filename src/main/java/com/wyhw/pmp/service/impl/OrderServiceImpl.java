package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.PicOrderDao;
import com.wyhw.pmp.entity.PicOrder;
import com.wyhw.pmp.entity.model.PicOrderInfo;
import com.wyhw.pmp.service.OrderService;
import com.wyhw.pmp.service.ParseService;
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
public class OrderServiceImpl implements OrderService, ParseService<PicOrderInfo, PicOrder> {

    @Resource
    private PicOrderDao orderDao;

    @Override
    public void save(PicOrderInfo order) {
        Integer count = orderDao.lambdaQuery().eq(PicOrder::getOpenId, order.getOpenId()).eq(PicOrder::getStatus, 0).count();
        if (count > 0) {
            log.warn("用户{}预约单已提交", order.getOpenId());
            return;
        }
        orderDao.save(parse2Entity(order));
    }

    @Override
    public PicOrderInfo getBinding(String openId) {
        PicOrder entity = orderDao.lambdaQuery().eq(PicOrder::getOpenId, openId).one();
        return parse2Model(entity);
    }

    @Override
    public PicOrder parse2Entity(PicOrderInfo order) {
        return new PicOrder()
                .setId(order.getId())
                .setUsername(order.getName())
                .setDate(LocalDateTime.parse(order.getDate(), DateUtil.STANDARD_DATE))
                .setPhone(order.getPhone())
                .setAddress(order.getAddress())
                .setTypeId(order.getType())
                .setPacageId(order.getPackageId())
                .setOpenId(order.getOpenId());
    }

    @Override
    public PicOrderInfo parse2Model(PicOrder entity) {
        return new PicOrderInfo()
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
