package com.chenyue.experiment.datastructure.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/12
 * @description 测试阻塞队列
 * 阻塞队列：线程安全的队列，在队列没有元素时，会阻塞获取操作直到有元素被添加，在队列已满时，添加元素的操作将被阻塞，直到队列中有空间。
 * add/remove 已满或为空，会报错；offer/poll 不会报错。 take/put是阻塞操作
 */
public class ArrayBlockQueueTest {
    public static void main(String[] args) {
        int MAX_CAPABILITY = 200;
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(MAX_CAPABILITY);
        for (int i = 0; i < MAX_CAPABILITY; i++) {
            queue.add("Element: " + i);
        }
        System.out.println("添加成功: " + queue.offer("element 201"));

        LinkedBlockingQueue<String> queue2 = new LinkedBlockingQueue<>();
        for (long i = 0; i < Integer.MAX_VALUE / 100000 ; i++) {
            queue2.add("Element: " + i);
        }
        System.out.println("添加成功: " + queue2.offer("element 201"));
        System.out.println(queue2.size());
    }
}
