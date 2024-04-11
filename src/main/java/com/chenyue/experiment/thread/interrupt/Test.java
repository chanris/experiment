package com.chenyue.experiment.thread.interrupt;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author chenyue7@foxmail.com
 *
 * 测试线程中断
 *
 *
 */
//@SuppressWarnings("all")
public class Test {

    private final static List<Integer> list = new Vector<>();
    private static int num;

//    public static void main(String[] args) {
//        Thread t1 = new Thread(){
//            @Override
//            public void run(){
//                while (true){
//                    if (Thread.currentThread().isInterrupted()){
//                        System.out.println("Interrupted");
//                        break;
//                    }
//                    Thread.yield();
//                }
//            }
//        };
//
//        t1.start();
//        try {
//            Thread.sleep(2000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        t1.interrupt();
//    }

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//
//                    if (Thread.currentThread().isInterrupted()){
//                        System.out.println("Interrupted");
//                        break;
//                    }
//
//                    try {
//                        Thread.sleep(1000);// 在睡眠时,产生了中断,会终止睡眠,并抛出中断异常,我们需要处理
//                    }catch (InterruptedException e){
//                        System.out.println("Interrupted in Sleep");
//                        Thread.currentThread().interrupt(); //由于睡眠吃掉了中断信号,必须再次设置中断信息
//                    }
//                    Thread.yield();
//                }
//            }
//        });
//        t1.start();
//        Thread.sleep(2000);
//        t1.interrupt();


//        synchronized (list){
//            list.wait(0);
//        }


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        });
        t2.setDaemon(true); //线程为守护线程时,jvm不会等待它的关闭
        t2.start();
//        Thread.sleep(2000);
//        int thread_priority = Thread.MAX_PRIORITY + Thread.MIN_PRIORITY + Thread.NORM_PRIORITY;
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++){
                    list.add(i);
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++){
                    list.add(i);
                }
            }
        });
        // num = 2000
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println(list.size());

//        int v1 = 1073741827;
//        int v2 = 1431655768;
//        System.out.println(v1+v2);
    }
}
