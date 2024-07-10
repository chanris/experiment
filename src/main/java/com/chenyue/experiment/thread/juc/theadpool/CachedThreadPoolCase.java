package com.chenyue.experiment.thread.juc.theadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/30
 * @description 缓存线程-线程池
 */
public class CachedThreadPoolCase {

    static class Demo implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "执行完毕了");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建一个缓存的线程，没有核心线程数，最大线程数为Integer.MAX_VALUE
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new Demo());
            Thread.sleep(1);
        }
    }

}
