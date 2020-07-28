package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author：印志刚
 * @Date：2020/7/26 09:48
 * @Description：
 */
@RestController
public class CircleBreakerController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value ="fallback",fallback = "fallbackHandler",blockHandler = "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> forObject = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id==4){
            throw new IllegalArgumentException("非法参数");
        }else if(forObject.getData()==null){
            throw new NullPointerException("空指针异常");
        }
        return forObject;
    }

    public CommonResult fallbackHandler(Long id,Throwable e){
        return new CommonResult(444,"兜底异常fallbackHandler"+e.getMessage(),new Payment(id,"null"));
    }
    public CommonResult blockHandler(Long id, BlockException blockException){
        return new CommonResult(445,"blockHandler");
    }

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return paymentService.getPayment(id);
    }
}
