package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yinzg
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public CommonResult getPaymentById(){
            return new CommonResult(200,"springcloud with consul成功，端口号："+serverPort+"\t"+ UUID.randomUUID().toString());
    }

}

