package com.wyhw.pmp.wechat;

import com.alibaba.fastjson.JSONObject;
import com.wyhw.pmp.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wanyanhw
 */
public class WeChatConfig {

    @Resource
    private HttpUtil httpUtil;

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
     * 数据管理容器
     */
    private static Map<String, Map<String, Long>> contextMap = new HashMap<>(16);

    /**
     * AccessToken设置刷新时间，单位；秒（S）
     */
    private static final Integer ACCESS_TOKEN_REFRESH_TIME = 10;

    /**
     * 获取AccessToken
     * @param appId 微信号
     * @param appSecret 微信密钥
     * @return accessToken
     */
    public AccessToken getAccessToken(String appId, String appSecret) {
        AccessToken accessToken = new AccessToken();
        String access_token = null;
        Integer expires_in = null;
        Long accessRefreshTime = null;
        // 从容器中取出AccessToken
        Map<String, Long> accessTokenMap = contextMap.get("accessToken");
        if (accessTokenMap != null) {
            Set<Map.Entry<String, Long>> entrySet = accessTokenMap.entrySet();
            if (entrySet.size() > 1) {
                contextMap.remove("accessToken");
            } else {
                for (Map.Entry<String, Long> entry : entrySet) {
                    access_token = entry.getKey();
                    accessRefreshTime = entry.getValue();
                }
            }
        }

        if (access_token != null && accessRefreshTime != null) {
            long now = System.currentTimeMillis() / 1000;
            if (accessRefreshTime + ACCESS_TOKEN_REFRESH_TIME >= now) {
                accessToken.setAccessToken(access_token);
                accessToken.setExpiresIn(7200);
                logger.info("从内存中取的token");
                return accessToken;
            }
        }

        String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APP_ID&secret=APP_SECRET";
        String url = ACCESS_TOKEN_URL.replace("APP_ID", appId).replace("APP_SECRET", appSecret);

        String resultJsonData = httpUtil.doGet(url);
        JSONObject jsonObject = JSONObject.parseObject(resultJsonData);
        if (jsonObject != null) {
            access_token = jsonObject.getString("access_token");
            expires_in = jsonObject.getInteger("expires_in");
            if (StringUtils.isEmpty(access_token) || expires_in == null) {
                logger.error("accessToken获取失败，errcode：" +
                        jsonObject.getString("errcode") + ", errmsg：" + jsonObject.getString("errmsg"));
            } else {
                logger.info("accessToken获取成功，过期时间为：" + expires_in + "ms");
                accessToken.setAccessToken(access_token);
                accessToken.setExpiresIn(expires_in);
                Map<String, Long> map = new HashMap<>(1);
                map.put(access_token, System.currentTimeMillis() / 1000);
                contextMap.put("accessToken", map);
                return accessToken;
            }
        }
        return null;
    }

}
