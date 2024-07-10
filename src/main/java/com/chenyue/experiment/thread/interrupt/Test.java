package com.chenyue.experiment.thread.interrupt;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author chenyue7@foxmail.com
 *
 * 测试线程中断
 *
 */

public class Test {


    private static int num;

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted");
                        break;
                    }
                    Thread.yield();
                }
            }
        };

        t1.start();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        t1.interrupt();
    }


}
