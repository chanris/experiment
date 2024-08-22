package com.chenyue.experiment.thread.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyue7@foxmail.com
 * @date 26/3/2024
 * @description
 * Condition 搭配 ReentrantLock 使用，关系好比 synchronized关键字 与 Object.wait()方法
 *
 */
public class ConditionTest {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();

    static class ReentrantLockCondition implements Runnable {
        @Override
        public void run() {
            try {
                lock.lock(); // 获得这个锁才能使用condition
                condition.await(); //阻塞该线程加入等待队列，并释放lock 锁，
                // 若收到 signal信号，则尝试重新获得锁，
                System.out.println("Thread " + Thread.currentThread().getName().toString() + " is going on.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockCondition tl = new ReentrantLockCondition();
        Thread t1 = new Thread(tl);
        t1.start();
        Thread.sleep(3000);
        lock.lock(); // 获得锁
        condition.signal(); //从该condition 的等待队列种 随机唤醒一个线程
        lock.unlock(); //交出锁, 不交出锁，等待唤醒的线程永远无法重新获得锁，也就无法被唤醒
    }
}
