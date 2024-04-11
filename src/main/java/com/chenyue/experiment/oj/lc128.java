package com.chenyue.experiment.oj;

import java.util.HashSet;

/**
 * @author chenyue7@foxmail.com
 * @date 13/3/2024
 * @description
 */
public class lc128 {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> nums_set = new HashSet<>();
        for (int num : nums) {
            nums_set.add(num);
        }
        // nums_set.contains() // 常数阶
        int longestStreak = 1;
        int currentStreak = 1;
        int k;
        for (Integer i : nums_set) {
            if(!nums_set.contains(i - 1)) {
                k = i;
                while(nums_set.contains(++k)) {
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
        }
        return longestStreak;
    }
}
