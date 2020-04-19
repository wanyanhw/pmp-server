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
    String parseXmlMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
