package com.chenyue.experiment.oj.dynamicprogramming;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/23
 * @description 求最长回文串
 * example: s=babad
 * 【0,1】 dp[0][1] = false
 * 【0,2】 dp[0][2] = dp[1][1] = true
 * 【0,3】 dp[0][3] = dp[1][2]
 *
 * 动归五部曲
 * 1. 确定dp 数组 含义
 *      boolean dp[i][j] 在【i, j】区间的字符是否构成回文串
 * 2. 确认递推公式
 *      s[i] == s[j] if(i - j < 2) then dp[i][j] = true; else if(i -j > 2) then dp[i][j] = dp[i+1][j-1];
 *      s[i] != s[j] ==> dp[i][j]=false
 * 3. dp数组初始化
 *      dp[i][j],若i=j,dp[i][j]=true
 * 4. 确定遍历顺序
 *      从长度len=1，开始遍历，【0,1】、【1,2】、【2,3】、【3,4】
 *                      【0,1,2】、【1,2,3】、【2、3、4】
 *                      【0,1,2,3】、【1,2,3,4】、【0,1,2,3,4】
 * 5. 举例推导dp数组
 */
public class lc5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        int maxLen = 1;
        int l = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for(int i = 2; i <= len; i++) {
            for(int j = 0; j <= len-i; j++) {
                if(s.charAt(j) == s.charAt(j+i-1)) {
                    if(i == 2) {
                        dp[j][j+i-1] = true;
                    }else {
                        dp[j][j+i-1] = dp[j+1][j+i-2];
                    }
                    if(dp[j][j+i-1] &&  i > maxLen) {
                        l = j;
                        maxLen = i;
                    }
                }else {
                    dp[j][j+i-1] = false;
                }
            }
        }
        return s.substring(l, l+ maxLen); // substring(beginIdx, endIdx); [beginIdx, endIdx)
    }
}
