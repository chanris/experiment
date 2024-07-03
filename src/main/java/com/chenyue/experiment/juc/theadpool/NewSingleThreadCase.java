package com.chenyue.experiment.juc.theadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/30
 * @description 单线程-线程池
 */
public class NewSingleThreadCase {

    static int count = 0;
    static class Demo implements Runnable {
        @Override
        public void run() {
            count++;
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Demo());
            Thread.sleep(5);
        }
        executorService.shutdown();
    }
}
