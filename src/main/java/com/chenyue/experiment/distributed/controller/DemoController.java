package com.chenyue.experiment.distributed.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/3
 * @description 测试Redisson锁的可重入性
 * 底层使用redis hash 结构， 保存线程名称 和锁的状态。
 * 锁结构：key field value
 * 比如：
 * key=myDLock field=thread-1 value=1
 * key=myDLock field=thread-1 value=1
 * 表示myDLock 被线程thread-1持有，并重入了一次。
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
        lock.lock();
        add2();
        //释放锁
        lock.unlock();
    }

    public void add2() {
        RLock lock = redissonClient.getLock("myDistributedLock");
        lock.lock();
        lock.unlock();
    }
}
