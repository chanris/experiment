package com.chenyue.experiment.thread;

import java.util.concurrent.*;

/**
 * @author chenyue7@foxmail.com
 * @date 15/4/2024
 * @description
 *
 * 核心线程数
 * 最大线程数
 * 最大空闲时间
 * 空闲时间单位
 * 等待队列
 * 线程工厂
 * 淘汰策略
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20,
                200,
                2000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(200),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
    
        ExecutorService executorService = Executors.newFixedThreadPool(3);  // 阻塞队列为：LinkedBlockingQueue，无参构造器，有界，Integer.MAV_VALUE，会导致OOM
        ExecutorService executorService1 = Executors.newSingleThreadExecutor(); // LinkedBlockingQueue,无参构造器，有界，Integer.MAV_VALUE，会导致OOM
        ExecutorService executorService2 = Executors.newCachedThreadPool(); // 允许创建的线程数为Integer.MAX_VALUE，会OOM

        Runnable r = () -> System.out.println("Hello, World!");

    }
}
