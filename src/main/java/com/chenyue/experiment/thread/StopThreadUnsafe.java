package com.chenyue.experiment.thread;

import com.chenyue.experiment.thread.entity.User;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description
 */
public class StopThreadUnsafe {
    public final static User u = new User();

    public static class ChangeObjectThread extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (u){
                    int v = (int)(System.currentTimeMillis()/1000);
                    u.setId(v);

                    // mock thread do sth. else
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends  Thread {
        @Override
        public void run() {
            while(true){

                synchronized (u){
                    if (u.getId() != Integer.parseInt(u.getName())){
                        System.out.println("read inconsistent data");
                    }
                }

                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while(true){
            Thread thread  = new ChangeObjectThread();
            thread.start();
            Thread.sleep(150);  // 模拟
            thread.stop();
        }
    }
}
