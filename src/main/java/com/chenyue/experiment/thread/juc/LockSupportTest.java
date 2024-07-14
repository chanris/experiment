package com.chenyue.experiment.thread.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author chenyue7@foxmail.com
 * @date 26/3/2024
 * @description
 * LockSupport 线程阻塞类工具，它可以在任意位置让线程阻塞
 * 1. LockSupport 不需要获得任何锁
 * 2. LockSupport 不会抛出InterruptedException
 * 3. LockSupport.park() 可以响应interrupt
 * 4. LockSupport.park() 线程挂起后，不会释放持有的锁，这是和Object.wait() 或者 Condition.await() 方法之间的一个重要区别
 *
 */
public class LockSupportTest {
    public final static Object lock = new Object();

    static class ChangeObjectThread implements Runnable {

        @Override //重写
        public void run() {
            synchronized (lock) { // 为什么需要获得u的锁
                System.out.println("in " + Thread.currentThread().getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) { //发生了中断就为true
                    System.out.println(Thread.currentThread().getName() + "发生了中断");
                }
                System.out.println(Thread.currentThread().getName() + " is going on.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        ChangeObjectThread t1 = new ChangeObjectThread("t1");
//        ChangeObjectThread t2 = new ChangeObjectThread("t2");
        Thread t1 = new Thread(new ChangeObjectThread(), "t1");
        Thread t2 = new Thread(new ChangeObjectThread(), "t2");
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}
