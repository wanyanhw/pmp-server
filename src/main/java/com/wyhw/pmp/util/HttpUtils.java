package com.wyhw.pmp.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class HttpUtils {

    RestTemplate restTemplate = new RestTemplate();

    public String doGet(String url) {
        JSONObject jsonObject = restTemplate.getForObject(url, new JSONObject().getClass());
        return jsonObject.toString();
    }

    public String doPost(String url, JSONObject requestBody) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<JSONObject> request = new HttpEntity<>(requestBody, httpHeaders);
        JSONObject jsonObject = restTemplate.postForObject(url, request, new JSONObject().getClass());
        return jsonObject.toString();
    }
}
