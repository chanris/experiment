package com.chenyue.experiment.oj.dynamicprogramming.pack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chenyue7@foxmail.com
 * @date 9/4/2024
 * @description
 */
public class ZeroOnePackage {

    public static void main(String[] args) {
        // 0 1背包 二维数组版
        /*Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.next());
        int n = Integer.parseInt(sc.next());
        sc.nextLine();
        int[] weight = new int[m];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            weight[i] = Integer.parseInt(s[i]);
        }
        int[] value = new int[m];
        s = sc.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            value[i] = Integer.parseInt(s[i]);
        }
        int[][] dp = new int[m][n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (weight[0] <= i) {
                dp[0][i] = value[0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[m - 1][n]);*/

        // 0 1背包 一维数组版（滚动数组）
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.next());
        int n = Integer.parseInt(sc.next());
        sc.nextLine();
        int[] weight = new int[m];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            weight[i] = Integer.parseInt(s[i]);
        }
        int[] value = new int[m];
        s = sc.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            value[i] = Integer.parseInt(s[i]);
        }

        int[] dp = new int[n+1];
        for (int i = 0; i < m; i++) {
            for (int j = n; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
//            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[n]);
    }
}
