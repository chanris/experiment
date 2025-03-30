package com.chenyue.experiment.thread;
/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description 多线程打印顺序0102030405
 *
 * 主要lock.wait() 和 lock.notify() 方法的使用限制，
 * 只有在 线程获取了lock锁之后才能 调用 lock.wait()和 lock.notify()方法
 *
 * 状态 + lock.wait() + lock.notifyAll() 实现线程间通讯，顺序打印abc
 *
 * 初始化状态 state => 指定为A线程的状态
 *
 * synchronized(lock) {
 *     while(state != self) { // 为什么要加while，因为可能其他线程唤醒后，state还不是自己的状态，继续睡觉。
 *         lock.wait() 让出锁
 *     }
 *     // do work
 *     // 做完任务，让出锁
 *     lock.notifyAll()
 * }
 *
 */
public class MultiThreadPrintNum {

    public final static Object lock = new Object();
    public static volatile int status = 0;
    public final static int count = 10;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new PrintZero(), "thread-1").start();
        new Thread(new PrintNonZero(), "thread-2").start();
    }

    static class PrintZero implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                synchronized (lock) {
                    while (status != 0) {
                        try {
                            lock.wait(); // 让出锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("0");
                    status = 1;
                    lock.notifyAll();
                }
            }
        }
    }

    static class PrintNonZero implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= count; i++) {
                synchronized (lock) {
                    while (status != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(i);
                    status = 0;
                    lock.notifyAll();
                }
            }
        }
    }
}
