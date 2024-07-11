package com.chenyue.experiment.thread.juc.threallocal;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/11
 * @description 测试线程的ThreadLocalMap 是在第一次调用threadLocal.set时创建的
 * 注意坑点！！！main线程创建之后jvm就会帮其创建ThreadLocalMap，所以第一次调用就会发现线程的threadLocals不为空-_-。
 * 一定要用新建的线程测试
 */
public class ThreadLocalMapTest {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
//        System.out.println("Hello, World!");
        Thread t1 = new Thread(new Task(), "Nothing");
        t1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello");
    }

    static class Task implements Runnable {

        static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        @Override
        public void run() {
            threadLocal.set(new Object());
            while(true) {
                try {
                    Thread.sleep(1000);
                    Thread thread = Thread.currentThread();
                    System.out.println(thread.getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
