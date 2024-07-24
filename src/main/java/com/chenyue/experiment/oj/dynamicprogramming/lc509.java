package com.chenyue.experiment.oj.dynamicprogramming;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/23
 * @description 斐波那契数
 */
public class lc509 {
    public int fib(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }
        return dp[n];
    }
}
