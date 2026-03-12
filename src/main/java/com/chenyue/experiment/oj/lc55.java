package com.chenyue.experiment.oj;


/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/10
 */
public class lc55 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 0};

        boolean b = canJump(arr);
        System.out.println(b);
    }

    public static boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int max = 0, i = 0, next = 0;
        while(i < nums.length) {
            boolean canGo = false;
            for(int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                int nextStep = j + nums[j];
                if(nextStep > max) {
                    max = j + nums[j];
                    canGo = true;
                    next = j;
                }
                if (nextStep >= nums.length - 1) {
                    return true;
                }
            }
            if(!canGo) {
                return false;
            }
            i = next;
            if(next >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
