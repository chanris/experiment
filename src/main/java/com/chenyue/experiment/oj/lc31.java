package com.chenyue.experiment.oj;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/23
 * @description
 */
public class lc31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 1) return;
        boolean isSorted = true;
        boolean isReverse = true;
        for(int i = 0; i < len - 1; i++) {
            if(nums[i] > nums[i+1]) {
                isSorted = false;
            }
            if(nums[i] < nums[i+1]) {
                isReverse = false;
            }
        }
        if(isSorted) {
            int temp = nums[len-1];
            nums[len-1] = nums[len-2];
            nums[len-2] = temp;
            return;
        }
        if(isReverse) {
            Arrays.sort(nums);
            return;
        }
        for(int i = len - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                for(int j = len - 1;  j >= 0; j--) {
                    if(nums[i] < nums[j]) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        int l = i + 1, r = len -1;
                        while(l < r) {
                            tmp = nums[l];
                            nums[l] = nums[r];
                            nums[r] = tmp;
                            l++;
                            r--;
                        }
                        return;
                    }
                }
            }
        }
    }
}
