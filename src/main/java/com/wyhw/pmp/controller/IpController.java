package com.wyhw.pmp.controller;

import com.wyhw.pmp.mq.Sender;
import com.wyhw.pmp.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanyanhw
 * @date 2020/5/26 14:09
 */
@RestController
@RequestMapping("/ip")
public class IpController {

    @Autowired
    private Sender sender;

    @Autowired
    private IpUtils ipUtils;

    @GetMapping("/getClientIp")
    String getClientIp(HttpServletRequest request) {
        String ipAddress = ipUtils.getIpAddress(request);
        sender.sendMsg(ipAddress);
        return ipAddress;
    }
}
