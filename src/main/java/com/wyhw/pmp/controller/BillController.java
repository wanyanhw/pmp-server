package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.BillInfo;
import com.wyhw.pmp.service.BillService;
import com.wyhw.pmp.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    public boolean saveBill(HttpServletRequest request, @RequestBody BillInfo billInfo) {
        String ipAddress = ipUtils.getIpAddress(request);
        return billService.createBill(billInfo);
    }
}
