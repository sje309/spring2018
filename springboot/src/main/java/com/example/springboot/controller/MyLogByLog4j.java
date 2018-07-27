package com.example.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** @Author: shuyizhi @Date: 2018-07-27 16:28 @Description: 使用log4j记录日志 */
@Controller
public class MyLogByLog4j {
    private final Logger logger = LoggerFactory.getLogger(MyLogByLog4j.class);

    @GetMapping(value = "/mylog")
    public @ResponseBody String index() {
        logger.debug("This is a debug message11");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "success";
    }
}
