package com.chenyue.experiment.oj.dynamicprogramming;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/24
 * @description
 */
public class lc115 {

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        lc115 lc = new lc115();
        int i = lc.numDistinct(s, t);
        System.out.println(i);
    }

    /**
     int dp[i][j] : s[0, i] 中， t[0, j] 出现的个数
     dp[0][i],i任意，dp[0][i]=0, 同理dp[i][0]=1
    dp[i][j]=
     */
    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (i < j)
                    continue;
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }

    /**
     * s="abc"
     * 子序列个数 "" "a" "b" "c"  "ab" "bc" "ac" "abc" = 2^n
     */
}
