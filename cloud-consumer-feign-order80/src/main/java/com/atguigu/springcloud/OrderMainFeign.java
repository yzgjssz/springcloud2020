package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author：印志刚
 * @Date：2020/4/26 21:20
 * @Description：
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderMainFeign {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainFeign.class,args);
    }
}
