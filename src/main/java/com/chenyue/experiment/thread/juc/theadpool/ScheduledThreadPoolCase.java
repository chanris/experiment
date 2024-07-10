package com.chenyue.experiment.thread.juc.theadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/30
 * @description
 */
public class ScheduledThreadPoolCase {
    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("任务执行开始时间：" + new Date());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        System.out.println("程序开始" + new Date());

        /**
         * schedule 提交任务到线程池中
         *
         * 第一个参数：提交的任务
         * 第二个参数：延迟的时间
         * 第三个参数：时间单位
         */
        service.schedule(new Task(), 0, TimeUnit.SECONDS);
        service.schedule(new Task(), 1, TimeUnit.SECONDS);
        service.schedule(new Task(), 5, TimeUnit.SECONDS);

        Thread.sleep(5000);
        service.shutdown();
    }
}
