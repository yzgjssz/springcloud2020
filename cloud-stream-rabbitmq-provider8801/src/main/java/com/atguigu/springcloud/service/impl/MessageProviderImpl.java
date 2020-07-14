package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Author：印志刚
 * @Date：2020/7/14 13:52
 * @Description：
 */

/**
 * 定义消息推送管道
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {
    /**
     * 消息发送通道
     */
    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String serial = IdUtil.fastSimpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("********serial="+serial);
        return serial;
    }
}
