package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author：印志刚
 * @Date：2020/7/10 21:59
 * @Description：
 */
@Component
public class MyLB implements LoadBalance {
    private AtomicInteger atomicInteger= new AtomicInteger(0);
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current=atomicInteger.get();
            next=current >= Integer.MAX_VALUE ? 0:current+1;
        }while(!atomicInteger.compareAndSet(current,next));
        System.out.println("***第几次访问，次数next:"+next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int i= getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(i);
    }
}
