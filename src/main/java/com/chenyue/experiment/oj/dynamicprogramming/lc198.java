package com.chenyue.experiment.oj.dynamicprogramming;

/**
 * @author chenyue7@foxmail.com
 * @date 18/3/2024
 * @description
 * 动态规划
 * 打家劫舍
 *
 * dp数组的定义 dp[i] 为 i 之前（包括i）的最大金额数，那么
 * 找出递推公式  dp[0] = nums[0], dp[1] = Max(dp[0], nums[1]), dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
 * dp数组初始化 dp[0] = nums[0]， dp[1] = Max(dp[0], nums[1])
 * 确定遍历顺序 顺序遍历
 */
public class lc198 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
