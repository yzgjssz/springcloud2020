package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entity.CommonResult;

/**
 * @Author：印志刚
 * @Date：2020/7/26 08:50
 * @Description：
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"CustomerBlockHandler,global,version-1  服务不可用");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"CustomerBlockHandler,global,version-2  服务不可用");
    }
}
