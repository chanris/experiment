package com.chenyue.experiment.oj.prefixand;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 21/3/2024
 * @description
 */
public class lc238 {

    public static void main(String[] args) {
        lc238 lc238 = new lc238();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] ints = lc238.productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }
    public int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length + 1];
        int[] r = new int[nums.length + 1];
        int[] ans = new int[nums.length + 1];
        l[1] = 1;
        l[0] = 1;
        for(int i = 1; i <= nums.length; i++) {
           l[i] = (l[i -1] * nums[i - 1]);
        }
        r[nums.length] = 1;
        r[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            r[i] = (r[i + 1] * nums[i + 1]);
        }
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                ans[i] = l[i];
            }else if(i == nums.length - 1) {
                ans[i] = r[i];
            }else {
                ans[i] = l[i] * r[i];
            }

        }
        return ans;
    }
}
