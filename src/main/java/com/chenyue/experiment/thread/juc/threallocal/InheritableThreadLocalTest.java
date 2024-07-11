package com.chenyue.experiment.thread.juc.threallocal;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/11
 * @description 测试InheritableThreadLocal的用法
 */
public class InheritableThreadLocalTest {

    public static void main(String[] args) {
        m1();
    }

    /**
     * InheritableThreadLocal 用于父子线程传递ThreadLocal变量
     */
    private static void m1() {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        //主线程使用inheritableThreadLocal.set放入值java
        inheritableThreadLocal.set(Thread.currentThread().getName() + "-Java");

        new Thread(()->{
            for (;true;) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() +"线程 获得了 "+ inheritableThreadLocal.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread1").start();
        inheritableThreadLocal.set("修改了InheritableThreadLocal");
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"线程 获得了 "+ inheritableThreadLocal.get());
        }, "thread2").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() +"线程 获得了 "+ inheritableThreadLocal.get());
        }, "thread3").start();
    }
}
