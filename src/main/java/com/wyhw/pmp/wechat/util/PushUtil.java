package com.wyhw.pmp.wechat.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

@Configuration
@Slf4j
public class PushUtil {

    public String push(String url, String params) {
        OutputStream outputStream = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        HttpsURLConnection connection = null;
        try {
            // 创建URL对象
            URL realUrl = new URL(url);
            // 打开连接 获取连接对象
            connection = (HttpsURLConnection) realUrl.openConnection();
            // 设置请求编码
            connection.addRequestProperty("encoding", "UTF-8");
            // 设置允许输入
            connection.setDoInput(true);
            // 设置允许输出
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("content-type", "application/json");
            // 当outputStr不为null时向输出流写数据
            if (null != params) {
                outputStream = connection.getOutputStream();
                // 注意编码格式
                outputStream.write(params.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            JSONObject jsonObject = JSONObject.parseObject(buffer.toString());
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 依次关闭打开的输入流
            try {
                if (connection != null) {
                    connection.disconnect();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                // 依次关闭打开的输出流
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
