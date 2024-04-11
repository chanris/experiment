package com.chenyue.experiment.oj;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 21/3/2024
 * @description 使用额外数组保存结果
 */
public class lc189 {
    public static void main(String[] args) {
        lc189 lc189 = new lc189();
        int[] nums = new int[]{-1,-100,3,99};
        lc189.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len];
        for(int i = 0; i < len; i++) {
            ans[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i]= ans[i];
        }
    }
}
