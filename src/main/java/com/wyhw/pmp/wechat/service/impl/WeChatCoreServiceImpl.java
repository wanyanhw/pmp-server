package com.wyhw.pmp.wechat.service.impl;

import com.thoughtworks.xstream.XStream;
import com.wyhw.pmp.wechat.bean.InputMessageBean;
import com.wyhw.pmp.wechat.bean.OutputMessageBean;
import com.wyhw.pmp.wechat.em.EventTypeEnum;
import com.wyhw.pmp.wechat.em.MsgTypeEnum;
import com.wyhw.pmp.wechat.service.WeChatCoreService;
import com.wyhw.pmp.wechat.util.CodeUtil;
import com.wyhw.pmp.wechat.util.XmlParseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;

@Service
public class WeChatCoreServiceImpl implements WeChatCoreService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final static String TOKEN = "0123456789abcdefghijklmnopqrstuvwxyz";

    @Override
    public String checkSignature(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
            logger.info("绑定开发者成功");
            return echostr;
        }
        return "";
    }

    @Override
    public String parseXmlMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletInputStream ris = req.getInputStream();

        XStream xs = XmlParseUtil.createXstream();
        xs.processAnnotations(InputMessageBean.class);
        xs.processAnnotations(OutputMessageBean.class);
        xs.alias("xml", InputMessageBean.class);

        StringBuilder contentBuilder = new StringBuilder();
        byte[] b = new byte[1024];
        int lens = -1;
        while ((lens = ris.read(b)) > 0) {
            System.out.println(new String(b, 0, lens));
            contentBuilder.append(new String(b, 0, lens));
        }

        InputMessageBean inputMessageBean = (InputMessageBean) xs.fromXML(contentBuilder.toString());
        String toUserName = inputMessageBean.getToUserName();
        String fromUserName = inputMessageBean.getFromUserName();
        Long createTime = inputMessageBean.getCreateTime();
        String msgType = inputMessageBean.getMsgType();
        long returnTime = Calendar.getInstance().getTimeInMillis();

        // 根据消息类型获取对应的消息内容
        if (msgType.equals(MsgTypeEnum.Event.toString())) {
            // 事件消息
            String event = inputMessageBean.getEvent();
            if (event.equals(EventTypeEnum.Subscribe.toString())) {
                // 订阅
                OutputMessageBean outputMessageBean = new OutputMessageBean();
                outputMessageBean.setToUserName(fromUserName);
                outputMessageBean.setFromUserName(toUserName);
                outputMessageBean.setCreateTime(returnTime);
                outputMessageBean.setMsgType(MsgTypeEnum.Text.toString());
                outputMessageBean.setContent("刘梦丽女士你好，完颜宏伟先生说他爱你，他要和你一直在一起！！！");
                logger.info("订阅结束！");
                return xs.toXML(outputMessageBean);
            }
        }
        return "";
    }
}
