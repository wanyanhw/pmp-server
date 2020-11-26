package com.wyhw.pmp.mq.active;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Configuration
@Slf4j
public class ActiveMqConsumer {

    @JmsListener(destination = "${queue-name}")
    public void receiveMsg(TextMessage textMessage) {
        try {
            Thread.sleep(2000);
            String text = textMessage.getText();
            log.info("消费消息：{}", text);
        } catch (JMSException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
