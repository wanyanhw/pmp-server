package com.wyhw.pmp.controller;

import com.wyhw.pmp.mq.active.ActiveMqConsumer;
import com.wyhw.pmp.mq.active.ActiveMqSender;
import com.wyhw.pmp.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wanyanhw
 * @date 2020/5/26 14:09
 */
@RestController
@RequestMapping("/ip")
public class IpController {

    @Autowired
    private IpUtils ipUtils;

    @Autowired
    private ActiveMqSender sender;

    @Autowired
    private ActiveMqConsumer consumer;

    @GetMapping("/getClientIp")
    String getClientIp(HttpServletRequest request) {
        LocalDateTime now = LocalDateTime.now();
//        sender.sendMsg(now.getHour() + ":" + now.getMinute() + ":" + now.getSecond());
        try {
            sender.sessionSendMsg("queue01", "hello world");
        } catch (JMSException e) {
            return "error:" + e.getMessage();
        }
        return ipUtils.getIpAddress(request);
    }

    @GetMapping("/getMsg")
    String getMsg() {
//        return consumer.receiveMsg();
        try {
            return consumer.sessionReceiveMsg("queue01");
        } catch (JMSException e) {
            return "error:" + e.getMessage();
        }
    }


}
