package com.chenyue.experiment.treenums;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/6/9
 * @description
 */
public class Tree { // 树状数组：单点增加，范围查询, 下标从1开始
    public static int[] nums = new int[100001];

    public static int lowbit(int i) {
        return i & -i;
    }

    public static void add(int i, int val) {
        while (i < nums.length) {
            nums[i] += val;
            i += lowbit(i);
        }
    }

    public static int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += nums[i];
            i -= lowbit(i);
        }
        return sum;
    }
}
