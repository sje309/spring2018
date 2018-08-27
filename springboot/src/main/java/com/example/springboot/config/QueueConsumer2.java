package com.example.springboot.config;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/** @Author: shuyizhi @Date: 2018-08-20 14:09 @Description: */
@Component
public class QueueConsumer2 {
    @JmsListener(destination = "mytest.queue")
    @SendTo(value = "out.queue")
    public String receiveQueue(String text) {
        System.out.println("QueueConsumer2收到的报文为: " + text);
        return "return message: " + text;
    }
}
