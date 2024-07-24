package com.chenyue.experiment.thread;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/28
 * @description jit会把 stop变量替换成 false(即时编译器的优化)，导致 t3线程死循环。 解决方法。1.jvm 启动参数 -Xint 禁止jit优化，不推荐 2. 使用volatile
 * volatile的作用： 1. 保证共享变量在各个线程之间的可见性。 2. 禁止jit指针重排优化。
 *
 * 测试volatile的可见性。
 */
public class VolatileTest {
    volatile static boolean stop = false;
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop = true;
        }, "t1").start();
        new Thread(()->{
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("stopped... c " + i);
        }, "t2").start();
    }
}
