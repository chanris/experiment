package com.chenyue.experiment.thread.juc;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/22
 * @description
 * 高性能的阻塞队列，底层使用CAS保证并发安全的同时提高无锁性能。
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        queue.offer("Element1");
        queue.offer("Element2");
        queue.offer("Element3");

        System.out.println("Peek:" + queue.peek());

        // 移除并查看队列头部元素
        System.out.println("Poll: " + queue.poll());
        System.out.println("Poll: " + queue.poll());

        // 查看剩余元素
        System.out.println("Remaining elements: " + queue);
    }
}
