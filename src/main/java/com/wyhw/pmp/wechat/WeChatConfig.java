package com.wyhw.pmp.wechat;

import com.alibaba.fastjson.JSONObject;
import com.wyhw.pmp.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class WeChatConfig {

    private HttpUtils httpUtils = new HttpUtils();

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private WeChatConfig() {}

    private static WeChatConfig instance;

    public static WeChatConfig getInstance() {
        if (instance == null) {
            synchronized (WeChatConfig.class) {
                if (instance == null) {
                    instance = new WeChatConfig();
                }
            }
        }
        return instance;
    }

    /**
     * 获取AccessToken
     * @param appId 微信号
     * @param appSecret 微信密钥
     * @return accessToken
     */
    public AccessToken getAccessToken(String appId, String appSecret) {
        String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APP_ID&secret=APP_SECRET";
        String url = ACCESS_TOKEN_URL.replace("APP_ID", appId).replace("APP_SECRET", appSecret);

        String resultJsonData = httpUtils.doGet(url);
        JSONObject jsonObject = JSONObject.parseObject(resultJsonData);
        AccessToken accessToken = new AccessToken();
        if (jsonObject != null) {
            String access_token = jsonObject.getString("access_token");
            Integer expires_in = jsonObject.getInteger("expires_in");
            if (StringUtils.isEmpty(access_token) || expires_in == null) {
                logger.error("accessToken获取失败，errcode：" +
                        jsonObject.getString("errcode") + ", errmsg：" + jsonObject.getString("errmsg"));
            } else {
                logger.info("accessToken获取成功，过期时间为：" + expires_in + "ms");
                accessToken.setAccessToken(access_token);
                accessToken.setExpiresIn(expires_in);
                return accessToken;
            }
        }
        return null;
    }

}
