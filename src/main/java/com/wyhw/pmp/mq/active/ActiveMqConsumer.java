package com.wyhw.pmp.mq.active;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.*;

@Configuration
@Slf4j
public class ActiveMqConsumer {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    public String receiveMsg() {
        try {
            String queueName = queue.getQueueName();
            TextMessage textMessage = (TextMessage) jmsTemplate.receive(queueName);
            assert textMessage != null;
            String text = textMessage.getText();
            log.info("消费消息：[{}]", text);
            return text;
        } catch (JMSException e) {
            log.info("消费消息异常: [{}]", e.getMessage());
        }
        return null;
    }

    @Autowired
    private ConnectionFactory connectionFactory;

    public String sessionReceiveMsg(String destination) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(destination);
        try {
            MessageConsumer consumer = session.createConsumer(queue);
            TextMessage message = (TextMessage) consumer.receive();
            return message.getText();
        } finally {
            session.close();
            connection.close();
        }
    }


}
