package com.chenyue.experiment.oj.dynamicprogramming;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/24
 * @description 最长递增子序列的个数
 *
 * dp[i]: 区间【0,i】
 */
public class lc673 {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(dp[i] == ans) {
               for (int j = 0; j < i; j++) {
                   if (dp[i] == ans -1) count++;
               }
            }
        }
        return count;
    }
}
