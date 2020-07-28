package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author：印志刚
 * @Date：2020/7/19 17:58
 * @Description：
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    public static HashMap<Long, Payment> hashMap =new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"11111"));
        hashMap.put(2L,new Payment(2L,"22222"));
        hashMap.put(3L,new Payment(3L,"33333"));
    }
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult commonResult = new CommonResult(200, "from mysql,serverPort: " + serverPort, payment);
        return commonResult;
    }
}
