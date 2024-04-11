package com.chenyue.experiment.oj.binarysearch;

/**
 * @author chenyue7@foxmail.com
 * @date 8/4/2024
 * @description
 */
public class lc33 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        int target = 1;
        lc33 lc33 = new lc33();
        int search = lc33.search(nums, target);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(left == right && nums[mid] != target) {
                return -1;
            }
            if(nums[mid] == target) return mid;
            else if(nums[left] < nums[right]) {
                if(target < nums[mid]) {
                    right =  mid - 1;
                }else {
                    left = mid + 1;
                }
            } else if(nums[left] < nums[mid]) {
                if(nums[left] <= target && target < nums[mid] ) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else if(nums[mid] < nums[right]) {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
               left = mid + 1;
            }
        }
        return -1;
    }
}
