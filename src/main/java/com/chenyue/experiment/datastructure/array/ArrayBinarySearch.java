package com.chenyue.experiment.datastructure.array;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/25
 * @description 有序数组二分查找
 */
public class ArrayBinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 6, 7, 9};
        int l = 0, r = nums.length - 1, position = -1;
        int target = 8;
        while (l <= r) {
            int mid = (l+r) / 2;
            position = mid;
            if(nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        System.out.println(position);
    }
}
