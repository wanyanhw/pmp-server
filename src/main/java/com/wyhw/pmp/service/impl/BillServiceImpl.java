package com.wyhw.pmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wyhw.pmp.dao.IBillDao;
import com.wyhw.pmp.entity.BillEntity;
import com.wyhw.pmp.entity.model.BillInfo;
import com.wyhw.pmp.service.BillService;
import com.wyhw.pmp.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wyhw
 * @date 2021/6/14 15:14
 */
@Service
public class BillServiceImpl implements BillService {
    @Resource
    private IBillDao billDao;

    @Override
    public Boolean createBill(BillInfo billInfo) {
        BillEntity entity = new BillEntity();
        entity.setTotal(billInfo.getTotal());
        entity.setRemark(billInfo.getRemark());
        entity.setOperator("1");
        entity.setConsumer(billInfo.getConsumer());
        entity.setConsumeTime(LocalDateTime.now());
        entity.setCreateTime(LocalDateTime.now());
        return billDao.save(entity);
    }

    @Override
    public List<BillInfo> listAllBill() {
        List<BillEntity> list = billDao.list(new LambdaQueryWrapper<BillEntity>().orderByDesc(BillEntity::getCreateTime));
        return list.stream().map(e -> {
            BillInfo info = new BillInfo();
            info.setId(e.getId());
            info.setTotal(e.getTotal());
            info.setConsumer(e.getConsumer());
            info.setRemark(e.getRemark());
            info.setConsumeTime(e.getConsumeTime() == null ? "" : e.getConsumeTime().format(DateUtil.STANDARD_DATE_TIME));
            return info;
        }).collect(Collectors.toList());
    }
}
