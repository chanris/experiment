package com.chenyue.experiment.oj.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/24
 * @description
 */
public class lc646 {
    public static void main(String[] args) {
        lc646 lc = new lc646();
        int[][] pairs = new int[][]{{1,2},{7,8},{4,5}};
        System.out.println(lc.findLongestChain(pairs));
    }

    /**
     * 动态规划： dp[i]表示区间【0,i】之间的最大链长度 dp[i]=max{dp[j]+1,,dp[i]}, j < i, pairs[i][0] > pairs[j][1]
     * 排序后，求最长对数链的长度，和求最长递增子序列思路一致。O(n^2)
     */
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Integer[] dp = new Integer[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < pairs.length - 1; i++) {
            int[] temp;
            for (int j = i; j < pairs.length; j++) {
                if(pairs[i][1] > pairs[j][1]){
                    temp = pairs[i];
                    pairs[i] = pairs[j];
                    pairs[j] = temp;
                }
            }
        }
        for (int[] num : pairs) {
            System.out.println(Arrays.toString(num));

        }
        for(int i = 0; i < len; i++) {
            for(int j = i; j >= 0; j--) {
                if(pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        return res;
    }
}
