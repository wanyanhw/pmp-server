package com.wyhw.pmp.aop;

import com.wyhw.pmp.entity.UserEntity;
import com.wyhw.pmp.service.UserService;
import com.wyhw.pmp.threadLocal.UserSession;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Aspect
@Component
public class LoginFilter {
    Logger logger = Logger.getLogger(this.getClass().toString());

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("@annotation(com.wyhw.pmp.aop.config.LoginRequired)")
    public void annotation() {}

    @Before("annotation()")
    public void setUserAccount() {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserEntity userInfo = userService.getUserInfo(null, username, password);
        UserSession.setUser(userInfo);
        logger.info("set user account {} {} ::: " + Thread.currentThread());
    }
    @After("annotation()")
    public void removeUserAccount() {
        logger.info("remove user account {} {} :::" + Thread.currentThread());
        UserSession.removeUser();
    }
}
