package com.chenyue.experiment.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description jvm不会等待守护线程的结束而结束
 */
public class DaemonThreadTest {
    public static void main(String[] args) throws InterruptedException {
        // 匿名内部类写法
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("daemon thread is running....");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        t2.setDaemon(true); //线程为守护线程时,jvm不会等待它的关闭
        t2.start();
        TimeUnit.SECONDS.sleep(5);
    }
}
