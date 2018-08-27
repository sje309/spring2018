package com.example.springboot.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/** @Author: shuyizhi @Date: 2018-08-20 10:12 @Description: */
@Service
public class Consumer {
    @JmsListener(destination = "test.queue")
    public void receiveMsg(String text) {
        System.out.println("<<<<<<============收到消息: " + text);
    }
}
