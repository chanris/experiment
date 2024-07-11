package com.chenyue.experiment.thread.juc.threallocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.*;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/11
 * @description 测试TransmittableThreadLocal的用法
 */
public class TransmittableThreadLocalTest {
    public static void main(String[] args) {
        TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
        // 为了看到TransmittableThreadLocal的效果，这里创建单线程的线程池
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Executor ttlExecutor = TtlExecutors.getTtlExecutor(threadPool);
        threadLocal.set(Thread.currentThread().getName() + "-Java");

        threadPool.submit(()->{
            System.out.println("threadPool第一次 获取 TransmittableThreadLocal值:" + threadLocal.get());
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //父线程修改transmittableThreadLocal的值
        threadLocal.set("-value已被线程"+ Thread.currentThread().getName() + "修改");
        threadPool.submit(()->{
            System.out.println("threadPool第二次 获取 TransmittableThreadLocal值:" + threadLocal.get());
        });
    }
}
