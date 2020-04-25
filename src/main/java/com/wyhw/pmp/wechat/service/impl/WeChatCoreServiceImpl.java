package com.wyhw.pmp.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.wyhw.pmp.util.HttpUtils;
import com.wyhw.pmp.wechat.AccessToken;
import com.wyhw.pmp.wechat.WeChatConfig;
import com.wyhw.pmp.wechat.bean.TemplateData;
import com.wyhw.pmp.wechat.bean.TemplateDataDetail;
import com.wyhw.pmp.wechat.bean.TextOutputMessageBean;
import com.wyhw.pmp.wechat.bean.WechatTemplate;
import com.wyhw.pmp.wechat.em.EventTypeEnum;
import com.wyhw.pmp.wechat.em.MsgTypeEnum;
import com.wyhw.pmp.wechat.service.WeChatCoreService;
import com.wyhw.pmp.wechat.util.CodeUtil;
import com.wyhw.pmp.wechat.util.PushUtil;
import com.wyhw.pmp.wechat.util.XmlParseUtil;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

@Service
@Slf4j
public class WeChatCoreServiceImpl implements WeChatCoreService {
    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private PushUtil pushUtil;

    WeChatConfig weChatConfig = WeChatConfig.getInstance();

    @Override
    public String checkSignature(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String TOKEN = "0123456789abcdefghijklmnopqrstuvwxyz";
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        String[] arr = new String[] {TOKEN, timestamp, nonce};
        Arrays.sort(arr);
        StringBuffer content = new StringBuffer();
        for (String s : arr) {
            content.append(s);
        }
        String temp = CodeUtil.getSha1(content.toString());
        boolean flag = temp.equals(signature);
        if (flag) {
            log.info("绑定开发者成功");
            return echostr;
        }
        return "";
    }

    @Override
    public String parseXmlMessage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Map<String, String> xmlMessageMap = parseXml(req);

        String toUserName = xmlMessageMap.get("ToUserName");
        String fromUserName = xmlMessageMap.get("FromUserName");
        Long createTime = Long.parseLong(xmlMessageMap.get("CreateTime"));
        String msgType = xmlMessageMap.get("MsgType");
        long returnTime = Calendar.getInstance().getTimeInMillis();

        // 根据消息类型获取对应的消息内容
        if (MsgTypeEnum.EVENT.toString().equals(msgType)) {
            // 事件消息
            String event = xmlMessageMap.get("Event");
            if (EventTypeEnum.SUBSCRIBE.toString().equals(event)) {
                // 订阅
                TextOutputMessageBean textOutputMessageBean = new TextOutputMessageBean();
                textOutputMessageBean.setToUserName(fromUserName);
                textOutputMessageBean.setFromUserName(toUserName);
                textOutputMessageBean.setCreateTime(returnTime);
                textOutputMessageBean.setMsgType(MsgTypeEnum.TEXT.toString());
                textOutputMessageBean.setContent("刘梦丽女士你好，完颜宏伟先生说他爱你，他要和你一直在一起！！！");
                log.info("订阅结束！");
                return textMessageToXML(textOutputMessageBean);
            }
        } else if (MsgTypeEnum.TEXT.toString().equals(msgType)) {
            log.info("推送开始--------------------");
            String appId = "wxc39f9342546ef11c";
            String appSecret = "9637d86b499bba0fab2eaa7373a70853";
            AccessToken accessToken = weChatConfig.getAccessToken(appId, appSecret);
            String token = accessToken.getAccessToken();
            System.out.println("token: " + token);
            String toUser = "oo8MEs7RsoaUGfSC7PVPrwrPEL0s";
            String templateId = "eaL01jUJLL-PpgoApf4k27wUicSbZLOVvDPTggMCaSI";
            String url = "www.baidu.com";

            JSONObject data = new JSONObject();
            JSONObject firstDataDetail = new JSONObject();
            firstDataDetail.put("value", "完颜宏伟你好");
            firstDataDetail.put("color", null);
            data.put("first", firstDataDetail);

            JSONObject keyword1DataDetail = new JSONObject();
            keyword1DataDetail.put("value", "完颜宏伟");
            keyword1DataDetail.put("color", null);
            data.put("keyword1", keyword1DataDetail);

            JSONObject keyword2DataDetail = new JSONObject();
            keyword2DataDetail.put("value", "男");
            keyword2DataDetail.put("color", null);
            data.put("keyword2", keyword2DataDetail);

            JSONObject keyword3DataDetail = new JSONObject();
            keyword3DataDetail.put("value", "25");
            keyword3DataDetail.put("color", null);
            data.put("keyword3", keyword3DataDetail);

            JSONObject remarkDataDetail = new JSONObject();
            remarkDataDetail.put("value", "hello world！");
            remarkDataDetail.put("color", null);
            data.put("remark", remarkDataDetail);
            String result = sendTemplateData(token, toUser, templateId, url, appId, data.toString());
            log.info("推送结束--------------------");
        }
        return "";
    }

    @Override
    public String sendTemplateData(String accessToken, String toUser, String templateId, String url, String appId, String data) {
        String postUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        postUrl = postUrl.replace("ACCESS_TOKEN", accessToken);
        WechatTemplate wechatTemplate = new WechatTemplate();
        wechatTemplate.setTouser(toUser);
        wechatTemplate.setTemplate_id(templateId);
        wechatTemplate.setUrl(url);
        wechatTemplate.setAppid(appId);
//        TemplateData templateData = parseJsonDataToTemplate(data);
        Map<String, Object> dataMap = parseData(data);
        wechatTemplate.setData(dataMap);
        JSONObject postData = (JSONObject) JSONObject.toJSON(wechatTemplate);
        if (postData != null) {
//            String result = pushUtil.push(postUrl, postData.toString());
            String result = httpUtils.doPost(postUrl, postData);
            JSONObject jsonResult = JSONObject.parseObject(result);
            Integer errcode = jsonResult.getInteger("errcode");
            String errmsg = jsonResult.getString("errmsg");
            if (errcode == 0) {
                log.info("消息发送成功！");
                return result;
            }
            log.error("消息发送失败！！！ errcode:{ {} }, errmsg{ {} }", errcode, errmsg);
        }
        return null;
    }

    private Map<String, Object> parseData(String data) {
        if (StringUtils.isEmpty(data)) {
            return null;
        }
        JSONObject jsonData = JSONObject.parseObject(data);
        return jsonData;
    }

    /**
     * json格式字符串转成TemplateData对象
     * @param jsonDataString 模版数据json字符串
     * @return templateData 模版对象
     */
    private TemplateData parseJsonDataToTemplate(String jsonDataString) {
        if (jsonDataString == null) {
            return null;
        }
        try {
            Class clazz = Class.forName("com.wyhw.pmp.wechat.bean.TemplateData");
            TemplateData templateData = (TemplateData) clazz.newInstance();
            JSONObject jsonData = JSON.parseObject(jsonDataString);
            Class[] params = new Class[1];
            params[0] = TemplateDataDetail.class;
            for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
                String key = entry.getKey();
                String setName = "set" + Character.toUpperCase(key.charAt(0)) + key.substring(1);
                JSONObject dataDetailJson = JSON.parseObject(entry.getValue().toString());
                if (dataDetailJson != null) {
                    TemplateDataDetail detail = new TemplateDataDetail();
                    String value = dataDetailJson.getString("value");
                    String color = dataDetailJson.getString("color");
                    detail.setValue(value);
                    detail.setColor(color);
                    try {
                        Method m = clazz.getMethod(setName, params);
                        m.invoke(templateData, detail);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return templateData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String textMessageToXML(TextOutputMessageBean textOutputMessageBean) {
        XStream xStream = XmlParseUtil.createXstream();
        xStream.alias("xml", textOutputMessageBean.getClass());
        return xStream.toXML(textOutputMessageBean);
    }

    private Map<String, String> parseXml(HttpServletRequest req) throws Exception {
        Map<String, String> map = new HashMap<>(30);
        ServletInputStream inputStream = req.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();
        List<Element> elements = root.elements();
        elements.forEach(item -> {
            map.put(item.getName(), item.getText());
        });
        inputStream.close();
        return map;
    }
}
