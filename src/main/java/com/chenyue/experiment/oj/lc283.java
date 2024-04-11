package com.chenyue.experiment.oj;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 4/3/2024
 * @description
 */
public class lc283 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int[] indices = new int[nums.length];
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                indices[k++] = i;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(i < k) {
                nums[i] = nums[indices[i]];
            }else {
                nums[i] = 0;
            }
        }
    }
}
