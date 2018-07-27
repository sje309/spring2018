package com.example.springboot.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** @Author: shuyizhi @Date: 2018-07-27 13:52 @Description: */
@Controller
public class HelloWorld {
    private static final Logger LOGGER = LogManager.getLogger(HelloWorld.class);

    @RequestMapping(value = "/sayhello.html")
    public @ResponseBody String say(String name) {
        hello();
        return "hello " + name;
    }

    public static boolean hello() {
        LOGGER.entry(); // trace级别的信息，单独列出来是希望你在某个方法或者程序逻辑开始的时候调用，和logger.trace("entry")基本一个意思
        LOGGER.error("Did it again!"); // error级别的信息，参数就是你输出的信息
        LOGGER.info("我是info信息"); // info级别的信息
        LOGGER.debug("我是debug信息");
        LOGGER.warn("我是warn信息");
        LOGGER.fatal("我是fatal信息");
        LOGGER.log(Level.DEBUG, "我是debug信息"); // 这个就是制定Level类型的调用：谁闲着没事调用这个，也不一定哦！
        LOGGER.exit(); // 和entry()对应的结束方法，和logger.trace("exit");一个意思
        return false;
    }
}
