package com.example.springboot.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/** @Author: shuyizhi @Date: 2018-08-20 10:42 @Description: */
@Service
public class Subscriber {
    @JmsListener(destination = "test.topic", containerFactory = "myJmsContainerFactory")
    public void subscriber(String text) {
        System.out.println("====================<<<<<<<<<收到订阅的消息: " + text);
    }
}
