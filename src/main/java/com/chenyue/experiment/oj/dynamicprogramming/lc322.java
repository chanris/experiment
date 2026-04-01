package com.chenyue.experiment.oj.dynamicprogramming;


/**
 * @author chenyue7@qq.com
 * @date 2026/4/1
 */
public class lc322 {

    public static void main(String[] args) {
        lc322 lc322 = new lc322();
        int i = lc322.coinChange(new int[]{1,2,5}, 11);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}
