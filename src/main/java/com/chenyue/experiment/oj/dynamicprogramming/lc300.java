package com.chenyue.experiment.oj.dynamicprogramming;

/**
 * @author chenyue7@foxmail.com
 * @date 18/3/2024
 * @description
 * 动态规划 -- 子序列问题 -- 最长递增子序列
 * dp数组的定义 定义dp[i] 为 下标 为 i 的开始的最长递增子序列长度
 * 找出递归公式 dp[i] = Max{dp[i+1], dp[i + 2], dp[i+3]} + 1
 * dp数组的初始化 dp[nums.length - 1] = 1
 * 确定遍历顺序 逆序遍历
 *
 * eg:
 * nums = [10,9,2,5,3,7,101,18]
 * 因为 [2, 3, 7, 101] ==> ans = 4
 *
 * 这道题的最好的时间复杂度 为O(n^2)
 */
public class lc300 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        // dp初始化
        dp[nums.length - 1] = 1;
        // 逆时针遍历
        for (int i = nums.length - 2; i >= 0 ; i--) {
            // 逆时针遍历
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }else {
                    dp[i] = Math.max(1, dp[i]);
                }
                ans = Math.max(dp[i], ans);
            }
        }
        return ans;
    }
}
