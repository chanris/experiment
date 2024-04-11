package com.chenyue.experiment.oj;

import java.util.*;

/**
 * @author chenyue7@foxmail.com
 * @date 13/3/2024
 * @description
 */
public class lc15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        Arrays.sort(nums);
//        System.out.println("nums:" + Arrays.toString(nums));
        for (List<Integer> list : threeSum(nums)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }


    // 双指针法： 先排序、选一个数固定，然后设置两个指针（一头一尾） ，如果三数之和大于 0 ， r指针--， 如果三数之和小于0，l指针++；
    // nums[-1, 0, 1, 2, -1, -4]
    //
    // map{-1: [0, 4], 0: [1], 1: [2], 2: [3], -4:[5]}
    // idxs [0, 1, 2] [1, 2, 4]
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
             int fixed = nums[i];
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while(l < r) {
                if((fixed + nums[l] + nums[r]) > 0) {
                    r--;
                } else if ((fixed + nums[l] + nums[r]) < 0) {
                    l++;
                } else {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(fixed);
                    item.add(nums[l]);
                    item.add(nums[r]);
                    ans.add(item);
                    while(nums[r] == nums[r-1]) {
                        r--;
                    }
                    while(nums[l] == nums[l+1] && l < nums.length - 1) {
                        l++;
                    }
                    r--;
                    l++;
                }
            }
        }
        return ans;
    }
}
