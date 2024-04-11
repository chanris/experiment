package com.chenyue.experiment.oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chenyue7@foxmail.com
 * @date 10/4/2024
 * @description
 */
public class kama57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());sc.nextLine();
        int[] dp = new int[n+1];
        int[] nums = new int[m];
        for(int i = 0; i < m; i++) {
            nums[i] = (i + 1);
        }
        dp[0] = 1;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                if(i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[n]);
    }
}
