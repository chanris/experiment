package com.chenyue.experiment.oj.greedy;

/**
 * @author chenyue7@foxmail.com
 * @date 25/3/2024
 * @description
 */
public class lc55 {
    public static void main(String[] args) {
        lc55 lc55 = new lc55();
        int[] nums = new int[]{3,2,1,0,4};
//        int[] nums = new int[]{2, 0, 0};
        boolean b = lc55.canJump(nums);
        System.out.println(b);
    }
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        // 求局部最优解
        for(int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + i);
            if(dp[i] <= i) {
                break;
            }else if(dp[i] >= (len - 1)) {
                return true;
            }
        }
        return false;
    }
}
