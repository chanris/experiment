package com.chenyue.experiment.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/18
 *
 * 测试线程的停止方式
 * 不建议使用stop，interrupt方法，
 * 推荐使用flag标记法，让线程自然执行完退出
 */
public class ThreadStop implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run...Thread: "+(i++));
        }
    }

    //stop方法
    public void stop() throws InterruptedException{
        this.wait();
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop thread = new ThreadStop();
        new Thread(thread).start();
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
