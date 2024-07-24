package com.chenyue.experiment.oj.dynamicprogramming;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/23
 * @description 编辑距离
 * word1 ==> word2
 * dp[i][j] 表示 word1[0,i] 转化为 word2[0,j]需要的最少操作数
 * 插入： dp[i][j+1]+1
 * 删除： dp[i-1][j]+1
 * 修改： dp[i-1][j-1]+1, 是否需要修改取决于 word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
 */
public class lc72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m * n == 0) {
            return n + m;
        }
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1] + ((word1.charAt(i-1) == word2.charAt(j-1)) ? 0 : 1));
            }
        }
        return dp[m][n];
    }
}
