package com.chenyue.experiment.thread;

/**
 * @author chenyue7@foxmail.com
 * @date 15/5/2024
 * @description 三个线程顺序打印ABC，十次
 */
public class PrintABC {
    private volatile int status = 1;
    private final int PRINT_COUNT = 10;

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();

        new Thread(printABC.new PrinterA(), "Thread-1").start();
        new Thread(printABC.new PrinterB(), "Thread-2").start();
        new Thread(printABC.new PrinterC(), "Thread-3").start();
    }

    class PrinterA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < PRINT_COUNT; i++) {
                synchronized (PrintABC.this) { // 获得 PrintABC.this实例锁
                    while (status != 1) { // 当前的状态不为1，进入等待
                        try {
                            PrintABC.this.wait(); // 释放锁，阻塞线程
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    status = 2;
                    PrintABC.this.notifyAll();
                }
            }
        }
    }

    class PrinterB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < PRINT_COUNT; i++) {
                synchronized (PrintABC.this) {
                    while (status != 2) { // status != 2 ，则释放锁，阻塞线程
                        try {
                            PrintABC.this.wait(); // 当其他线程 调用PrintABC.this.notifyAll() 则唤醒线程，若status != 2 继续阻塞，释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    status = 3;
                    PrintABC.this.notifyAll();
                }
            }
        }
    }

    class PrinterC implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < PRINT_COUNT; i++) {
                synchronized (PrintABC.this) {
                    while (status != 3) {
                        try {
                            PrintABC.this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    status = 1;
                    PrintABC.this.notifyAll();
                }
            }
        }
    }
}
