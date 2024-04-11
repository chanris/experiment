package com.chenyue.experiment.oj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyue7@foxmail.com
 * @date 4/3/2024
 * @description hash
 */
public class lc1 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        int[] ints = twoSum(nums, nums.length);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>(target);
        int val = Integer.MIN_VALUE;
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                m.put(target - nums[i], nums[i]);
            }else if(m.get(nums[i]) != null) {
                res[0] = i;
                val = m.get(nums[i]);
                break;
            }else {
                m.put(target - nums[i], nums[i]);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                res[1] = i;
                break;
            }
        }
        return res;
    }
}
