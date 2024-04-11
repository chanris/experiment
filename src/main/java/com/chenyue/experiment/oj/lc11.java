package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 13/3/2024
 * @description
 */
public class lc11 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        int i = maxArea(nums);
        System.out.println(i);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while(l < r) {
            max = Math.max(max,  (r - l) * Math.min(height[l], height[r]));
            if(height[l] < height[r]) {
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
