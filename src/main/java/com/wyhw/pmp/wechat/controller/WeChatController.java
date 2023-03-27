package com.wyhw.pmp.wechat.controller;

import com.wyhw.pmp.wechat.AccessToken;
import com.wyhw.pmp.wechat.WeChatConfig;
import com.wyhw.pmp.wechat.service.WeChatCoreService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/wx")
public class WeChatController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeChatCoreService coreService;

    private final WeChatConfig instance = WeChatConfig.getInstance();

    @ApiOperation("开发者认证接口")
    @RequestMapping("/wxMessage")
    public String wxMessage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        boolean isGet = req.getMethod().toLowerCase().equals("get");
        if (isGet) {
            return coreService.checkSignature(req, resp);
        } else {
            return coreService.parseXmlMessage(req, resp);
        }
    }

    @ApiOperation("获取AccessToken")
    @GetMapping("/getAccessToken")
    public AccessToken getAccessToken(String appId, String appSecret) {
        return instance.getAccessToken(appId, appSecret);
    }

    @GetMapping("/user/openId/get")
    public String get(String code) {
        return coreService.getUserOpenId(code);
    }

}
