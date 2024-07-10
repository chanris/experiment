package com.chenyue.experiment.thread;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/17
 * @description
 * 线程之间的通信问题：生成者和消费者问题
 * 使用 wait() 和 notify 进行线程通信
 */
public class InterThreadCommTest {

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

    static class Data{
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
}


