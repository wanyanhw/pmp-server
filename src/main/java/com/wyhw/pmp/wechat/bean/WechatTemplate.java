package com.wyhw.pmp.wechat.bean;

import lombok.Data;

import java.util.Map;

@Data
public class WechatTemplate {
    /**
     * 接收者openid
     */
    private String touser;

    /**
     * 模板ID
     */
    private String template_id;

    /**
     * 模板跳转链接
     */
    private String url;

    /**
     * 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
     */
    private String appid;

    /**
     * 模板数据
     */
    private Map<String, Object> data;

}
