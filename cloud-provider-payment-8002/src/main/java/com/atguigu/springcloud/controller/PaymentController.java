package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entity.CommonResult;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping("/create")
    public CommonResult createPayment(@RequestBody Payment payment){
        boolean save = paymentService.save(payment);
        if(!save){
            return new CommonResult(555,null);
        }else{
            return new CommonResult(200,"插入成功，端口号："+serverPort);
        }

    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long  id){
        Payment byId = paymentService.getById(id);
        if(byId==null){
            return new CommonResult(555,null);
        }else{
            return new CommonResult(200,"成功，端口号："+serverPort,byId);
        }

    }
    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}

