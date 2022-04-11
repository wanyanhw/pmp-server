package com.wyhw.pmp.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author wanyanhw
 */
@Component
public class HttpUtil {

    private RestTemplate restTemplate = new RestTemplate();

    public String doGet(String url) {
        JSONObject jsonObject = restTemplate.getForObject(url, JSONObject.class);
        assert jsonObject != null;
        return jsonObject.toString();
    }

    public String doPost(String url, JSONObject requestBody) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JSONObject> request = new HttpEntity<>(requestBody, httpHeaders);
        JSONObject jsonObject = restTemplate.postForObject(url, request, JSONObject.class);
        assert jsonObject != null;
        return jsonObject.toString();
    }
}
