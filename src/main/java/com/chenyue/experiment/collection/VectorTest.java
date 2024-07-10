package com.chenyue.experiment.collection;

import java.util.List;
import java.util.Vector;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description
 * java.util.Vector: 线程安全的动态数组容器，通过给get/add/remove这些操作容器的方法添加synchronized 关键字实现线程安全。
 */
public class VectorTest {
    private final static List<Integer> list = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++){
                    list.add(i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++){
                    list.add(i);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list.size());
    }
}
