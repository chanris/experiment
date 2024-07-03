package com.chenyue.experiment.distributed.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/3
 * @description
 */
@RestController
public class DemoController {

    @Resource
    RedissonClient redissonClient;

    @RequestMapping("test")
    public String testReentrant() {
        add1();
        return "success";
    }


    public void add1() {
        RLock lock = redissonClient.getLock("myDistributedLock");
        boolean isLock = lock.tryLock();
        add2();
        //释放锁
    }

    public void add2() {
        RLock lock = redissonClient.getLock("myDistributedLock");
        boolean isLock = lock.tryLock();
        lock.unlock();
    }
}
