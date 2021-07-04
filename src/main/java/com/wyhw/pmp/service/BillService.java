package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.model.BillInfo;

import java.util.List;

/**
 * @author: wyhw
 * @date: 2021/6/14 15:13
 */
public interface BillService {
    Boolean createBill(BillInfo billInfo);

    List<BillInfo> listAllBill();
}
