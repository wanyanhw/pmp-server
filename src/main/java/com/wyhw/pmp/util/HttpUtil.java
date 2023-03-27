package com.wyhw.pmp.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @author wanyanhw
 */
public class HttpUtil {

    private static final RestTemplate restTemplate = new RestTemplate();

    public static String doGet(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    public static String doPost(String url, JSONObject requestBody) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JSONObject> request = new HttpEntity<>(requestBody, httpHeaders);
        JSONObject jsonObject = restTemplate.postForObject(url, request, JSONObject.class);
        assert jsonObject != null;
        return jsonObject.toString();
    }
}
