package com.chenyue.experiment.oj;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 8/4/2024
 * @description
 */
public class lc75 {

    public static void main(String[] args) {
        lc75 lc75 = new lc75();
        int[] nums = new int[]{2,0,2,1,1,0, 1, 2, 0, 2, 1, 2};
        lc75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        int tmp;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                p1++;
            } else if(nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                if(p0 < p1) {
                    tmp = nums[p1];   // 此时 nums[i] = 1
                    nums[p1] = nums[i];
                    nums[i] = tmp;
                }
                p1++;
                p0++;
            }
        }
        System.out.println("p0: "+  p0);
        System.out.println("p1: "+  p1);
    }
}
