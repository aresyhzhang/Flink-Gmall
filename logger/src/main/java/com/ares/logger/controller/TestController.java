package com.ares.logger.controller;

import org.springframework.stereotype.Component;

/**
 *对当前类进行标记，springboot类启动后会扫描到这个类
 */

@Component
public class TestController {
    @Override
    public String toString() {
        return super.toString();
    }
}
