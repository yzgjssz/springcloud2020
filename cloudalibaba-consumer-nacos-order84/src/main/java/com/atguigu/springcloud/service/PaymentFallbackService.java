package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entity.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @Author：印志刚
 * @Date：2020/7/26 10:48
 * @Description：
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult getPayment(Long id) {
        return new CommonResult(444444,"服务降级返回");
    }
}
