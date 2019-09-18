package com.springmvc.mq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @Author: luohanwen
 * @Date: 2019/9/16 17:40
 */

@Service
public class MessageProducer {
    @Resource
    private JmsTemplate activeMqJmsTemplate;

    @Resource
    private Destination queueDestination;

    public void sendMessage(final String message) {
        activeMqJmsTemplate.send(queueDestination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });

    }

}
