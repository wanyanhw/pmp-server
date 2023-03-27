package com.wyhw.pmp.wechat;

import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.HttpMethod;

/**
 * @author wanyanhw
 * @since 2023/3/27 10:48
 */
public class ConstApi {

    public static String buildApi(Api apiEnum, String... params) {
        return apiEnum.buildUrl(params);
    }

    public static enum Api {
        CODE_2_SESSION(HttpMethod.GET, "/sns/jscode2session?appid=PARAM1&secret=PARAM2&js_code=PARAM3&secret=authorization_code"),
        GET_ACCESS_TOKEN(HttpMethod.GET, "/cgi-bin/token"),
        ;

        private final static String BASE_URL = "https://api.weixin.qq.com";
        @Getter
        private final HttpMethod method;
        private final String url;

        Api(HttpMethod method, String url) {
            this.method = method;
            this.url = url;
        }

        private String buildUrl(String... params) {
            if (ArrayUtils.isEmpty(params)) {
                return BASE_URL + this.url;
            }
            String url = this.url;
            for (int i = 0; i < params.length; i++) {
                url = url.replace("PARAM" + (i + 1), params[i]);
            }
            return BASE_URL + url;
        }
    }
}
