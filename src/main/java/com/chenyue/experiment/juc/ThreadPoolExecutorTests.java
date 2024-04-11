package com.chenyue.experiment.juc;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.*;

/**
 * @author chenyue7@foxmail.com
 * @date 27/3/2024
 * @description
 */
public class ThreadPoolExecutorTests {
    public static void main(String[] args) {
        /**
         * 创建线程池
         * coreThread: 核心线程数
         * maxThread: 最大线程数
         * keepAliveTime: 最大存货时间
         * time:时间单位
         * blockingQueue: 等待队列
         * threadFactory: 线程工程
         * ThreadPoolExector.policy
         *  {
         *      抛出异常，
         *      把最先等待的任务删掉
         *      把溢出任务放在主进程运行
         *      直接抛弃任务
         *  }
         */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(20, 200, 2000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(2000), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }
}
