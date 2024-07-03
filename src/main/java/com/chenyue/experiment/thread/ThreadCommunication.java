package com.chenyue.experiment.thread;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/27
 * @description
 */
public class ThreadCommunication {

    static Thread t1;
    static Thread t2;
    static Thread t3;

    public static void main(String[] args) throws Exception {
        t1 = new Thread(()->{
            int num = 100;
            while (num > 0) {
                System.out.println(num);
                try {
                    t3.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                num--;
            }
        });
        t2 = new Thread(()->{
            int num = 100;
            while (num > 0) {
                System.out.println(num);

                num--;
            }
        });
        t3 = new Thread(()->{
            int num = 100;
            while (num > 0) {
                System.out.println(num);

                num--;
            }
        });
    }
}
