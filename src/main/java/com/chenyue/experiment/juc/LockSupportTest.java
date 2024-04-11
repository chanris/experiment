package com.chenyue.experiment.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author chenyue7@foxmail.com
 * @date 26/3/2024
 * @description
 * LockSupport 线程阻塞类工具，它可以在任意位置让线程阻塞
 * 1. LockSupport 不需要获得任何锁
 * 2. LockSupport 不会抛出InterruptedException
 */
public class LockSupportTest {
    public final static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");
    static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String threadName) {
            super.setName(threadName);
        }

        @Override //重写
        public void run() {
            synchronized (u) { // 为什么需要获得u的锁
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) { //发生了中断就为true
                    System.out.println(Thread.currentThread().getName() + "发生了中断");
                }
                System.out.println(Thread.currentThread().getName() + " is going on.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
