package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.BillInfo;
import com.wyhw.pmp.service.BillService;
import com.wyhw.pmp.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: wyhw
 * @date: 2021/6/14 15:08
 */
@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;
    @Autowired
    private IpUtils ipUtils;

    @PostMapping("/save")
    public boolean saveBill(@RequestBody BillInfo billInfo) {
        return billService.createBill(billInfo);
    }

    @GetMapping("/list")
    public List<BillInfo> listBill() {
        return billService.listAllBill();
    }
}
