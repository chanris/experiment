package com.chenyue.experiment.oj.dynamicprogramming;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/23
 * @description 最长回文子串
 * s=bbbac
 *
 * int[i][j] dp 表示在闭区间【i, j】的最长回文字序列长度
 *
 *  dp[i][j],任意i=j, dp[i][j]=1
 * s[i]==s[j] => dp[i+1][j-1]+1
 * s[i]!=s[j] => if(i-j == 1)  then dp[i][j] = 1 else if(i-j>2) then for()
 *
 * s=nwlrbbmqbh
    [1, 1, 0, 0, 0, 0, 0, 0, 0, 0]
    [0, 1, 1, 1, 0, 0, 0, 0, 0, 0]
    [0, 0, 1, 1, 1, 1, 0, 0, 0, 0]
    [0, 0, 0, 1, 1, 1, 1, 1, 0, 0]
    [0, 0, 0, 0, 1, 2, 1, 1, 4, 1]
    [0, 0, 0, 0, 0, 1, 1, 2, 3, 1]
    [0, 0, 0, 0, 0, 0, 1, 1, 2, 2]
    [0, 0, 0, 0, 0, 0, 0, 1, 1, 2]
 *
 *
 */
public class lc516 {
    public static void main(String[] args) {
        String s = "nwlrbbmqbh";
        lc516 lc = new lc516();
        System.out.println(lc.longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int maxLen = 1;
        for (int i = 2; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                if (s.charAt(j) == s.charAt(j + i - 1)) {
                    dp[j][j + i - 1] = dp[j + 1][j + i - 2] + 2;
                } else {
                    if (i == 2) {
                        dp[j][j + i - 1] = 1;
                    } else {
                        for (int k = j; k <= j+1; k++) {
                            dp[j][j + i - 1] = Math.max(dp[j][j + i - 1], dp[k][k+i-2]);
                        }
                    }
                }
                maxLen = Math.max(maxLen, dp[j][j + i - 1]);
            }
        }
        for(int[] nums : dp) {
//            System.out.println(Arrays.toString(nums));
        }
        return maxLen;
    }
}
