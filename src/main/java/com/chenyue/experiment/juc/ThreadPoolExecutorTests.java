package com.chenyue.experiment.juc;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyue7@foxmail.com
 * @date 27/3/2024
 * @description 测试线程池的执行逻辑
 */

public class ThreadPoolExecutorTests {

    static class MyTask implements Runnable {
        private final String name;
        private final long duration;

        public MyTask(String name) {
            this(name, 0);
        }

        public MyTask(String name, long duration) {
            this.name = name;
            this.duration = duration;
        }

        @Override
        public void run() {
            try {
                System.out.println("myThread 【" + Thread.currentThread().getName() + "】 running..." + this);
                Thread.sleep(duration);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "MyTask(" + name + ")";
        }
    }

    public static void main(String[] args) {
        AtomicInteger c = new AtomicInteger(1);
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
        LinkedBlockingDeque linkedBlockingQueue = new LinkedBlockingDeque();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                3,
                0,
                TimeUnit.MILLISECONDS,
                queue,
                r -> new Thread(r, "myThread" + c.getAndIncrement()),
                new ThreadPoolExecutor.DiscardPolicy());
        showState(queue, threadPool);
        threadPool.submit(new MyTask("1", 3600000)); // 阻塞一小时
        showState(queue, threadPool);
        threadPool.submit(new MyTask("2", 3600000)); // 阻塞一小时
        showState(queue, threadPool);
        threadPool.submit(new MyTask("3")); // 阻塞一小时
        showState(queue, threadPool);
        threadPool.submit(new MyTask("4")); // 阻塞一小时
        showState(queue, threadPool);
        threadPool.submit(new MyTask("5", 3600000)); // 阻塞一小时
        showState(queue, threadPool);
    }

    private static void showState(ArrayBlockingQueue<Runnable> queue, ThreadPoolExecutor poolExecutor) {
        try {
            Thread.sleep(300);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Object> tasks = new ArrayList<>();
        for (Runnable runnable : queue) {
            try {
                Field callable = FutureTask.class.getDeclaredField("callable");
                callable.setAccessible(true);
                Object adapter = callable.get(runnable);
                Class<?> clazz = Class.forName("java.util.concurrent.Executors$RunnableAdapter");
                Field task = clazz.getDeclaredField("task");
                task.setAccessible(true);
                Object o = task.get(adapter);
                tasks.add(o);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.printf("pool size: %s, queue: %s\n", poolExecutor.getPoolSize(), tasks);
    }
}
