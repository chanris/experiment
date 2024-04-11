package com.chenyue.experiment.oj.dynamicprogramming;

/**
 * @author chenyue7@foxmail.com
 * @date 18/3/2024
 * @description dp数组的定义: 以i（nums[i]）为尾的最大连续子数组的和
 * 找出递推公式: dp[i] = Max(dp[i - 1] + nums[i], nums[i])
 * dp数组初始化: dp[0] = nums[0]，其他设为 0 即可
 * 确定遍历顺序： nums 顺序遍历
 */
public class lc53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // 存储长度为 i的 连续子数组的和
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = nums[0];
        ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
