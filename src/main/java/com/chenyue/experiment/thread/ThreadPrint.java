package com.chenyue.experiment.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description 多线程打印0102030405
 */
public class ThreadPrint implements Runnable {

    public Object prev;
    public Object self;
    private int max;
    private static int current = 1;
    private int threadId;

    public ThreadPrint(Object prev, Object self, int max, int threadId) {
        this.prev = prev;
        this.self = self;
        this.threadId = threadId;
        this.max = max;
    }

    @Override
    public void run() {
        while (current < max) {
            synchronized (prev) {
                synchronized (self) {
                    if(threadId == 1) {
                        System.out.print("0");
                    }else {
                        System.out.print(current++);
                    }
                    self.notify(); // 唤醒另一个等待当前对象锁的线程
                }
                try {
                    prev.wait(); // 释放prev锁标记，让出CPU，进入等待状态
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lockA = new Object();
        Object lockB = new Object();
        ThreadPrint threadPrint1 = new ThreadPrint(lockA, lockB, 6, 1);
        ThreadPrint threadPrint2 = new ThreadPrint(lockB, lockA, 6, 2);

        new Thread(threadPrint1).start();
        Thread.sleep(100); // 先让线程1执行
        new Thread(threadPrint2).start();

    }
}
