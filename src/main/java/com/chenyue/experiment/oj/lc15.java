package com.chenyue.experiment.oj;

import java.util.*;

/**
 * @author chenyue7@foxmail.com
 * @date 13/3/2024
 * @description
 */
public class lc15 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,-2,-1};

        for (List<Integer> list : threeSum(nums)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int fixedNum = nums[i];
            if(fixedNum > 0) break;
            int l = i + 1;
            int r = nums.length -1;
            if(i > 0 && nums[i] == nums[i-1]) continue; // 防止重复
            int pre = Integer.MAX_VALUE;
            while(l < r) {
                while(l < r && (nums[l] + nums[r]) > -fixedNum) {
                    r--;
                }
                if(l != r && nums[l] + nums[r] + fixedNum == 0) {
                    if(pre == Integer.MAX_VALUE) {
                        ans.add(new ArrayList<>(List.of(fixedNum, nums[l], nums[r])));
                    }else if(pre != nums[l]){
                        ans.add(new ArrayList<>(List.of(fixedNum, nums[l], nums[r])));
                    }
                    pre = nums[l];
                }
                l++;
            }
        }
        return ans;
    }
}
