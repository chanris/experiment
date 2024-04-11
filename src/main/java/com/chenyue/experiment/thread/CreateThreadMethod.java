package com.chenyue.experiment.thread;

/**
 * @author chenyue7@foxmail.com
 * 开启一个线程的三种方式
 */
public class CreateThreadMethod {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println("Hello World");
                }

            }
        }.start();


        // lambda方式 这样构建线程能避免重写run方法
        new Thread(()->{
            System.out.println("Thread 构造器 传入一个Runnable实例");
        }).start();

        // 传Runnable接口
        new Thread(new Runnable() {
            private int threadId = 100;

            public Runnable setThreadId(int threadId){
                this.threadId = threadId;
                return this;
            }
            @Override
            public void run() {
                System.out.println("本线程id:"+this.threadId);
            }
        }.setThreadId(101)).start();
    }



}
