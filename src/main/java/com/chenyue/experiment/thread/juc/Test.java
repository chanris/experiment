package com.chenyue.experiment.thread.juc;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/17
 */
public class Test {
    public static void main(String[] args) {
       /* Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"thread-001");
        thread.start();*/
        //获得cpu核数
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
