package com.chenyue.experiment.thread.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * java.util.concurrent ==> (JUC) ....
 *
 * @author chenyue7@foxmail.com
 * @date 2021/2/17
 */
public class Pc2 {
    public static void main(String[] args) throws InterruptedException {
        Data2 data = new Data2();
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"A");
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"B");
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"C");
        Thread t4 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"D");
        t.start();
        t2.start();
        t3.start();
        t4.start();

        t.join();
        t2.join();
        t3.join();
        t3.join();
    }
}

//condition.await();
//condition.signalAll();
class Data2{
    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public  void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"==>"+num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public  void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (num==0){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"==>"+num);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class Data3 {
    private Lock lock = new ReentrantLock();
    public Condition condition1 = lock.newCondition();
    public Condition condition2 = lock.newCondition();
    public Condition condition3 = lock.newCondition();
    private int num = 1;
    public void printA(){
        lock.lock();
        try {
            while (num != 1) {
                // wait
                condition1.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"=>AAAAAAAA");
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while (num != 0) {
                // wait
                condition2.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"=>BBBBBB");
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            while (num != 1) {
                // wait
                condition2.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"=>CCCC");
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
