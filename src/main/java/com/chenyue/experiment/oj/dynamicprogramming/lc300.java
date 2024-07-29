package com.chenyue.experiment.oj.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 18/3/2024
 * @description
 * 动态规划 -- 子序列问题 -- 最长递增子序列
 * dp数组的定义 定义dp[i] 为 【0,i】区间的最长递增子序列
 * 找出递归公式 dp[i] = max{dp[j]} + 1, 0 <= j < i, nums[j] < nums[i]
 * dp数组的初始化 Arrays.fill(dp,1);
 * 确定遍历顺序
 *
 * eg:
 * nums = [10,9,2,5,3,7,101,18]
 * 因为 [2, 3, 7, 101] ==> ans = 4
 *
 */
public class lc300 {

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int i = lengthOfLIS3(nums);
        System.out.println(i);
    }

    // 双指针+贪心（上升曲度越小，最终获得最长递增序列的长度越长）
    public static int lengthOfLIS3(int[] nums) {
        List<Integer> p = new ArrayList<>();
        p.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (p.get(p.size()-1) < nums[i]) {
                p.add(nums[i]);
            }else {
                p.set(findIdx(p, nums[i])+1, nums[i]);
            }
        }
        return p.size();
    }

    // 2 6 8 => 3
    public static int findIdx(List<Integer> list, int num) {
        int l = 1, r = list.size(), pos = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if(list.get(mid) < num) {
                pos = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return pos;
    }

    // 官方dp解法， O(n^2)
    public static int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j]+ 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        return ans;
    }

    // 不知道怎么冒出来的解法，已想不起了 O(n^2)
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        // dp初始化
        dp[nums.length - 1] = 1;
        // 逆时针遍历
        for (int i = nums.length - 2; i >= 0 ; i--) {
            // 逆时针遍历
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }else {
                    dp[i] = Math.max(1, dp[i]);
                }
                ans = Math.max(dp[i], ans);
            }
        }
        return ans;
    }
}
