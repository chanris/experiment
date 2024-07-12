package com.chenyue.experiment.thread;

/**
 * @author chenyue7@foxmail.com
 * @date 15/5/2024
 * @description 三个线程顺序打印ABC
 */
@SuppressWarnings("all")
public class MultiThreadPrintABC {
    private volatile static int status = 1;
    private static final int PRINT_COUNT = 10;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new PrinterA(), "Thread-A").start();
        new Thread(new PrinterB(), "Thread-B").start();
        new Thread(new PrinterC(), "Thread-C").start();
    }

    static class PrinterA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < PRINT_COUNT; i++) {
                synchronized (lock) { // 获得 PrintABC.this实例锁
                    while (status != 1) { // 当前的状态不为1，进入等待
                        try {
                            lock.wait(); // 释放锁，阻塞线程
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    status = 2;
                    lock.notifyAll();
                }
            }
        }
    }

    static class PrinterB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < PRINT_COUNT; i++) {
                synchronized (lock) {
                    while (status != 2) { // status != 2 ，则释放锁，阻塞线程
                        try {
                            lock.wait(); // 当其他线程 调用PrintABC.this.notifyAll() 则唤醒线程，若status != 2 继续阻塞，释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    status = 3;
                    lock.notifyAll();
                }
            }
        }
    }

    static class PrinterC implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < PRINT_COUNT; i++) {
                synchronized (lock) {
                    while (status != 3) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    status = 1;
                    lock.notifyAll();
                }
            }
        }
    }
}
