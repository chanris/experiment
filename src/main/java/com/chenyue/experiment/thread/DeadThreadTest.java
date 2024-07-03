package com.chenyue.experiment.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/28
 * @description 模拟死锁情况
 */
public class DeadThreadTest {

    final static Object A = new Object();
    final static Object B = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (A) {
                System.out.println(Thread.currentThread().getName() + "-lock A");
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e) {
                    throw new RuntimeException();
                }
                synchronized (B) {
                    System.out.println(Thread.currentThread().getName() + "-lock B");
                    System.out.println(Thread.currentThread().getName() + "-操作...");
                }
            }
        }, "t1");
        Thread t2 = new Thread(()->{
            synchronized (B) {
                System.out.println(Thread.currentThread().getName() + "-lock B");
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e) {
                    throw new RuntimeException();
                }
                synchronized (A) {
                    System.out.println(Thread.currentThread().getName() + "-lock A");
                    System.out.println(Thread.currentThread().getName() + "-操作...");
                }
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
