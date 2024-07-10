package com.chenyue.experiment.thread.juc;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/30
 * @description
 */
public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{
            String name = Thread.currentThread().getName();
            threadLocal.set("itcast");
            print(name);
            System.out.println("name + -after remove : " + threadLocal.get());
        }, "t1").start();

        new Thread(()->{
            String name = Thread.currentThread().getName();
            threadLocal.set("itheima");
            print(name);
            System.out.println("name + -after remove : " + threadLocal.get());
        }, "t2").start();
    }

    static void print(String str) {
        System.out.println(str + ":" + threadLocal.get());
        threadLocal.remove();
    }
}
