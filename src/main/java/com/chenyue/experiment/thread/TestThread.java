package com.chenyue.experiment.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/17
 * 测试并发问题
 */
public class TestThread {
    private static int num = 0;
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                increment();
                Thread.yield();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                increment();
                Thread.yield();
            }
        }).start();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }

    public static void increment(){
//        num++;
        lock.lock();
        try {
            num++;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
