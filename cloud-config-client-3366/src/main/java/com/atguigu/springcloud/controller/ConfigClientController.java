package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：印志刚
 * @Date：2020/7/13 11:41
 * @Description：
 */
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return serverPort+"---"+configInfo;
    }
}
