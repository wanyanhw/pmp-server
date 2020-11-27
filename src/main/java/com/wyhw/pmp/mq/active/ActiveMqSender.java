package com.wyhw.pmp.mq.active;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.*;

@Configuration
public class ActiveMqSender {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String msg) {
        jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    @Autowired
    private ConnectionFactory connectionFactory;

    public void sessionSendMsg(String destination, String msg) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(destination);
        MessageProducer producer = session.createProducer(queue);
        try {
            Message message = session.createTextMessage(msg);
            producer.send(message);
            session.commit();
        }
        finally {
            session.close();
            connection.close();
        }
    }

}
