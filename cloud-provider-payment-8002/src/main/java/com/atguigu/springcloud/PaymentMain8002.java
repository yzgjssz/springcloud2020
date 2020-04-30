package com.atguigu.springcloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author：印志刚
 * @Date：2020/4/21 16:30
 * @Description：主启动类
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.atguigu.*.mapper"})
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PaymentMain8002.class, args);
    }
}
