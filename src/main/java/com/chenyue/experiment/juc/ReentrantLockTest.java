package com.chenyue.experiment.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
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

    // 创建可重入锁
    static ReentrantLock lock = new ReentrantLock();

    //条件1
    static Condition c1 = lock.newCondition();
    //条件2
    static Condition c2 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        // 获取锁的过程中，可以被打断
//        lockInterrupt();

        // 非阻塞的获取锁，一次CAS操作，返回结果， 也设置获取锁的时间，规定时间内没获取锁就失败
//        timeOutLock();

        // 多条件变量
        conditionTest();


    }

    private static void conditionTest() {
        new Thread(()->{
            lock.lock();
            try {
                c1.await(); // 进入c1条件的等待
                System.out.println(Thread.currentThread().getName()+",acquire lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }, "t1").start();

        new Thread(()->{
            lock.lock();
            try {
                c2.await(); // 进入c2条件的等待
                System.out.println(Thread.currentThread().getName() + ",acquire lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }, "t2").start();

        new Thread(()->{
            lock.lock();
            try {
                c1.signal(); // 唤醒c1条件的线程
//                c1.signalAll(); 唤醒c1条件的所有线程
                c2.signal(); // 唤醒c2条件的线程
                System.out.println(Thread.currentThread().getName() + ",acquire lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }, "t3").start();
    }

    private static void timeOutLock() throws InterruptedException{
        Thread t1 = new Thread(()->{
            // 非阻塞的获取锁，如果没有获取成功，会立即返回结果
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                   System.out.println("t1-获取锁失败");
                   return;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println("t1线程-获取了锁");
            }finally {
               lock.unlock();
            }
        });
        lock.lock();
        System.out.println("主线程获取了锁");
        t1.start();
        try {
            Thread.sleep(2000);
        }finally {
            lock.unlock();
        }
    }

    private static void lockInterrupt() throws InterruptedException{
        Thread t1 = new Thread(()->{
            try {
                // 阻塞获取锁，阻塞的状态可以被线程状态的改变而被打断
                lock.lockInterruptibly(); // 获得锁 并可以响应中断（开启可中断的锁）
            }catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            try {
                System.out.println(Thread.currentThread().getName() + ",获得了锁");
            }finally {
                lock.unlock();
            }
        }, "t1");
        lock.lock();
        System.out.println("主线程获得了锁");
        t1.start();

        try {
            Thread.sleep(1000);
            t1.interrupt();
            System.out.println("执行打断");
        }finally {
            lock.unlock();
        }
    }


}
