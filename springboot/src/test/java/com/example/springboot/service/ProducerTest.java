package com.example.springboot.service;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;

/** @Author: shuyizhi @Date: 2018-08-20 10:14 @Description: */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {
    @Resource private Producer producer;
    @Resource private Publisher publisher;
    @Autowired private QueueProducer queueProducer;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            producer.sendMsg("test.queue", "Queue Message " + i);
        }
    }

    @Test
    public void testPublisher() {
        for (int i = 0; i < 10; i++) {
            publisher.publish("test.topic", "Topic Message " + i);
        }
    }

    @Test
    public void testQueue() {
        Destination destination = new ActiveMQQueue("mytest.queue");
        for (int i = 0; i < 10; i++) {
            queueProducer.sendMessage(destination, "myName is Flytiger: " + i);
        }
    }
}
