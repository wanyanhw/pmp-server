package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.PicOrderInfo;
import com.wyhw.pmp.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wanyanhw
 * @since 2023/3/27 9:14
 */
@RestController
@RequestMapping("/order")
@Api(tags = "预约订单")
public class OrderController {

    @Resource
    private OrderService orderService;

    @ApiOperation("提交预约单")
    @PostMapping("/submit")
    public String save(@RequestBody PicOrderInfo order) {
        orderService.save(order);
        return "success";
    }

    @ApiOperation("获取用户预约单")
    @GetMapping("/getBinding")
    public PicOrderInfo getBinding(String openId) {
        return orderService.getBinding(openId);
    }
}
