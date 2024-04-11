package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 5/1/2024
 * @description
 */
public class lc35 {
    public static void main(String[] args) {
        int[] nums = new int[]{2};
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }
    public static int searchInsert(int[] nums, int target) {
//        if(target < nums[0]) return 0;
//        if(nums.length == 1 && nums[0] == target) return 0;
        return binarySearch(nums, target, 0, nums.length -1 );
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        if(start >= end) {
            if(target > nums[start]) {
                return start + 1;
            }else {
                return start;
            }
        }
        int mid = start + (end - start) / 2;
        if(target < nums[mid]) {
            return binarySearch(nums, target, start, mid - 1);
        }
        if(target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, end);
        }
        return mid;
    }

}
