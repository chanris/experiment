package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 31/3/2024
 * @description
 */
public class lc34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                r = mid;
            }else if(nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }

        }
        return nums;
    }
}
