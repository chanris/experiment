package com.chenyue.experiment.thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/30
 * @description
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-begin");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown(); // 原子减一
        }).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-begin");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown(); // 原子减一
        }).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-begin");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDownLatch.countDown(); // 原子减一
        }).start();

        countDownLatch.await();

    }
}
