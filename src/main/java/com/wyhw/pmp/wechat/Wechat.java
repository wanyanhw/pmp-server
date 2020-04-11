package com.wyhw.pmp.wechat;

import com.alibaba.fastjson.JSONObject;
import com.wyhw.pmp.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class Wechat {

    private String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APP_ID&secret=APP_SECRET";

    private HttpUtils httpUtils = new HttpUtils();

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Wechat() {}

    private static Wechat wechat;

    public static Wechat getInstance() {
        if (wechat == null) {
            synchronized (Wechat.class) {
                if (wechat == null) {
                    wechat = new Wechat();
                }
            }
        }
        return wechat;
    }

    /**
     * 获取AccessToken
     * @param appId 微信号
     * @param appSecret 微信密钥
     * @return accessToken
     */
    public AccessToken getAccessToken(String appId, String appSecret) {
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
                accessToken.setAccessToken(access_token);
                accessToken.setExpiresIn(expires_in);
                return accessToken;
            }
        }
        return null;
    }

}
