package com.ares.logger.controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 日志处理服务
 */

@RestController
@Slf4j
public class LoggerController {

    //KafkaTemplate是Spring提供对kafka操作的类
    private static final Logger log = LoggerFactory.getLogger(LoggerController.class);

    @Autowired //注入
    KafkaTemplate kafkaTemplate;

    @RequestMapping("/applog")
    public String logger(@RequestParam("param") String jsonLog){
        //1.打印输出到控制台
        //System.out.println(jsonLog);
        //2.落盘   借助记录日志的第三方框架 log4j [logback]
        log.info(jsonLog);
        //3.将生成的日主发送到kafka对应的主题中
        kafkaTemplate.send("ods_base_log",jsonLog);

        return "success";
    }
}
