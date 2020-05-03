package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author：印志刚
 * @Date：2020/4/26 21:52
 * @Description：
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL="http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",CommonResult.class);
    }

}
