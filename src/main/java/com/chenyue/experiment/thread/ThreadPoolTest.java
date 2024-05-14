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
    }
}
