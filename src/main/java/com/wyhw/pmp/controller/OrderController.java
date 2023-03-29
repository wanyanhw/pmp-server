package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.UserAppointmentInfo;
import com.wyhw.pmp.service.UserAppointmentService;
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
    private UserAppointmentService appointmentService;

    @ApiOperation("提交预约单")
    @PostMapping("/submit")
    public String save(@RequestBody UserAppointmentInfo order) {
        appointmentService.save(order);
        return "success";
    }

    @ApiOperation("获取用户预约单")
    @GetMapping("/getBinding")
    public UserAppointmentInfo getBinding(String openId) {
        return appointmentService.getBinding(openId);
    }

}
