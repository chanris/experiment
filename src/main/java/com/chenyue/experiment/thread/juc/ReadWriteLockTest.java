package com.chenyue.experiment.thread.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/3
 * @description 测试读写锁
 * 读锁：共享锁，读读 不互斥， 读写互斥 读读互斥
 *
 *
 */
public class ReadWriteLockTest {

    static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
//        test1();
        test3();
    }

    /**
     * 测试一：当一个线程获得读锁后，其他线程还能不能获得读锁
     */
    public static void test1() {
        new Thread(()->{
            rwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "线程获取读锁");
        }, "t1").start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
                rwLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + "线程获取读锁");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2").start();
    }

    /**
     * 测试二：当一个线程获得读锁后，其他线程还能不能获得写锁
     */
    public static void test2() {
        Thread t1 = new Thread(() -> {
            rwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "线程获取读锁");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            rwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "线程获取写锁");
        }, "t2");
        t2.start();
    }

    /**
     * 测试三：当一个线程获得写锁后，其他线程还能不能获得写锁
     */
    public static void test3() {
        Thread t1 = new Thread(() -> {
            rwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "线程获取写锁");

        }, "t1");
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            rwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "线程获取写锁");
        }, "t2");
        t2.start();
    }
}
