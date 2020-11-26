package com.wyhw.pmp.mq.active;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

@Configuration
public class ActiveMqSender {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String msg) {
        jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

}
