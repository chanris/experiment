package com.chenyue.experiment.thread.juc;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/17
 *
 * 线程之间的通信问题：生成者和消费者问题
 *
 */
public class Pc {

    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.decrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.increment();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    data.decrement();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}

class Data{
    private int num = 0;
    public synchronized void increment() throws InterruptedException {
        if (num != 0){
            this.wait();
            return;
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"==>"+num);
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        if (num==0){
            this.wait();
            return;
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"==>"+num);
        notifyAll();
    }
}
