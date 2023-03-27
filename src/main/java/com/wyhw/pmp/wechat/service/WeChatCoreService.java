package com.wyhw.pmp.wechat.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface WeChatCoreService {
    /**
     * 开发者接入微信校验
     * @param req 请求
     * @param resp 响应
     * @return 返回结果
     */
    String checkSignature(HttpServletRequest req, HttpServletResponse resp) throws IOException;

    /**
     * 公众号发送消息解析
     * @param req 请求
     * @param resp 响应
     * @return 返回消息内容
     * @throws IOException 异常信息
     */
    String parseXmlMessage(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    /**
     * 模版消息推送接口
     * @param accessToken 用户获取的token
     * @param toUser 接收者openId
     * @param templateId 模版Id
     * @param url 模版跳转链接
     * @param appId 公众号appId
     * @param data 模版数据（json格式）
     * @see com.wyhw.pmp.wechat.bean.WechatTemplate
     * @return 消息发送结果（json格式）
     */
    String sendTemplateData(String accessToken, String toUser, String templateId, String url, String appId, String data);

    String getUserOpenId(String code);
}
