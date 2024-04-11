package com.chenyue.experiment.datastructure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 3/4/2024
 * @description 手写优先队列 todo 24/4/4
 */
public class MyPriorityQueue <T extends Comparable<T>> {
    private List<T> heap;
    public MyPriorityQueue() {
        heap = new ArrayList<>();
    }

    public void offer(T element) {
        heap.add(element);
        int currentIndex = heap.size() - 1;
        while(currentIndex > 0) {
            int parentIdx = (currentIndex - 1) / 2;

        }
    }

    public T peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("MyPriorityQueue is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }
}
