package com.chenyue.experiment.thread.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/17
 *
 * java.util.concurrent.locks.Lock和synchronized区别
 * 1. synchronized是关键字 Lock是一个java类
 * 2. synchronized无法判断获取锁的状态，Lock可以判断释放获得了锁
 * 3. synchronized会自动释放锁，lock必须手动释放，如果不是释放会死锁
 * 4. synchronized线程1(获得了锁，阻塞),线程2(只有等待)；Lock锁就不一定会等待下去;
 * 5. synchronized 可重入锁，不可以中断的，非公平；Lock，可重入锁，可以判断锁，非公平(可以自己设置)
 * 6. synchronized适合锁少量的代码同步，Lock适合锁大量的代码同步！
 *
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0;i < 100000; i++){
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0;i < 100000; i++){
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0;i < 100000; i++){
                ticket.sale();
            }
        },"C").start();
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * lock锁
 * 1. new ReentrantLock();
 * 2. lock.lock 加锁
 * 3. tr{业务代码}catch(Exception e){}
 * 4. unlock 释放锁
 */
class Ticket{
    private int number = 1000000;
    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if (number > 0){
                number--;
                System.out.println(Thread.currentThread().getName() + "卖出了: " + (1000000 - number) + "票,剩余: "+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
