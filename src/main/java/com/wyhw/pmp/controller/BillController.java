package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.BillInfo;
import com.wyhw.pmp.service.BillService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wyhw
 * @date 2021/6/14 15:08
 */
@Api(tags = "账单接口")
@RestController
@RequestMapping("/bill")
public class BillController {

    @Resource
    private BillService billService;

    @PostMapping("/save")
    public boolean saveBill(@RequestBody BillInfo billInfo) {
        return billService.createBill(billInfo);
    }

    @GetMapping("/list")
    public List<BillInfo> listBill() {
        return billService.listAllBill();
    }
}
