package com.wyhw.pmp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wanyanhw
 * @date 2020/6/3 13:32
 */
@Slf4j
@Aspect
@Component
public class PushSmsProxy {

    @Pointcut("execution(* com.wyhw.pmp.controller.IpController.getClientIp(..))")
    public void sendSms() {
    }

    @Before("sendSms()")
    public void doPush() {
        log.info("获取Ip之前要做的事。。。。。。。。。待续");
    }

}
