package com.chenyue.experiment.thread;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/18
 */
public class ThreadSleep implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadSleep());
        thread.start();
        System.out.println(thread.getState());
        while (true){
            try {
                MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (thread.getState().equals(Thread.State.TERMINATED)){
                break;
            }
            System.out.println(thread.getState());
        }
    }


}
