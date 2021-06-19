package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.IBillDao;
import com.wyhw.pmp.entity.BillEntity;
import com.wyhw.pmp.entity.model.BillInfo;
import com.wyhw.pmp.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: wyhw
 * @date: 2021/6/14 15:14
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private IBillDao billDao;

    @Override
    public Boolean createBill(BillInfo billInfo) {
        BillEntity entity = new BillEntity();
        entity.setTotal(billInfo.getTotal());
        entity.setRemark(billInfo.getRemark());
        entity.setOperator("1");
        return billDao.save(entity);
    }
}
