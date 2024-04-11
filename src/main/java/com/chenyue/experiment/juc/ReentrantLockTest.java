package com.chenyue.experiment.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyue7@foxmail.com
 * @date 26/3/2024
 * @description
 * ReentrantLock 已经获得该锁的线程可以再次获得这个锁，就是需要unlock多次（获得锁几次就释放锁几次）
 * 1. 响应中断
 * 2. 限时申请锁
 * 3. 实现公平锁
 *
 * Condition: ReentrantLock的好搭档，用于线程之间的协作
 */
public class ReentrantLockTest {
    public static ReentrantLock lock = new ReentrantLock();
    public static  int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ReenterLock());
        Thread t2 = new Thread(new ReenterLock());
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(count);
    }

    static class ReenterLock implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try { // 使用try catch 代码块把同步代码包裹起来，防止出现异常，导致锁没有释放
                for (int i = 0; i < 10000; i++) {
                    count ++;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
