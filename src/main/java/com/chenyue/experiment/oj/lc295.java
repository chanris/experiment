package com.chenyue.experiment.oj;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenyue7@foxmail.com
 * @date 19/4/2024
 * @description
 */
public class lc295 {
    public static void main(String[] args) {

    }

    PriorityQueue<Integer> min_root_heap = new PriorityQueue<>();
    PriorityQueue<Integer> max_root_heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void addNum(int num) {
        if(min_root_heap.size() != max_root_heap.size()) {
            max_root_heap.offer(num);
            min_root_heap.offer(max_root_heap.peek());
        }else {
            max_root_heap.offer(num);
        }
    }

    public double findMedian() {
        int N = min_root_heap.size() + max_root_heap.size();
        if(N % 2 == 1) {
            return min_root_heap.peek().intValue() / 1.0;
        }else {
            return  (min_root_heap.peek() + max_root_heap.peek()) / 2.0;
        }
    }

}
