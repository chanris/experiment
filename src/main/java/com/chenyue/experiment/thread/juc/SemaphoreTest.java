package com.chenyue.experiment.thread.juc;

import java.util.concurrent.Semaphore;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/30
 * @description 测试 信号量的使用
 */
public class SemaphoreTest {
    public static void main(String[] args) {

        //1.创建Semaphore
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire(); // 阻塞获得
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("running....");
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end...");
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
