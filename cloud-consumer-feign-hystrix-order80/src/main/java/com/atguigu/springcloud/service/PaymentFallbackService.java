package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author：印志刚
 * @Date：2020/7/11 15:32
 * @Description：
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService  {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK fallback o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "paymentInfo_Timeout fallback o(╥﹏╥)o";
    }
}
