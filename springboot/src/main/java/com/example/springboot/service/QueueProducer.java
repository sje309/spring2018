package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @Author: shuyizhi @Date: 2018-08-20 11:32 @Description: 点对点模型
 * 参考：https://blog.csdn.net/songfeihu0810232/article/details/78648706
 */
@Service(value = "queueproducer")
public class QueueProducer {
    @Autowired private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送消息,每3S执行1次
     *
     * @param destination 发送到的消息队列
     * @param message 待发送的消息
     */
    @Scheduled(fixedDelay = 3000)
    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    @JmsListener(destination = "out.queue")
    public void consumerMessgae(String text) {
        System.out.println("从out.queue队列收到的回复报文为: " + text);
    }
}
