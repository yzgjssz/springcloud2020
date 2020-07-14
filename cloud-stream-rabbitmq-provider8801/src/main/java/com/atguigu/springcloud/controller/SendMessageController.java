package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author：印志刚
 * @Date：2020/7/14 14:00
 * @Description：
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;
    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
