package com.chenyue.experiment.oj.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author chenyue7@foxmail.com
 * @date 3/4/2024
 * @description
 * 1. 求滑动窗口最大值
 * 方法一: 使用优先队列（最大堆/最小堆）
 *
 */
public class lc215 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] nums = new int[]{1,-1};
        lc215 lc215 = new lc215();
        int[] ints = lc215.maxSlidingWindow(nums, 1);
        System.out.println(Arrays.toString(ints));
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Status> stack = new PriorityQueue<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            stack.offer(new Status(nums[i], i));
        }
        ans[0] = stack.peek().val;
        for (int i = k; i < nums.length; i++) {
            stack.offer(new Status(nums[i], i));
            Status peek = stack.peek();
            while (peek != null && peek.idx < i - k + 1) {
                stack.poll();
                peek = stack.peek();
            }
            ans[i - k + 1] = peek.val;
        }
        return ans;
    }

    public static class Status implements Comparable<Status> {
        public int val;
        public int idx;

        public Status(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Status o) {
            return o.val - this.val ;
        }
    }
}
