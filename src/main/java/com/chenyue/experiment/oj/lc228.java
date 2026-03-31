package com.chenyue.experiment.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/26
 * @description 汇总区间
 */
public class lc228 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,4,5,7};
        lc228 lc228 = new lc228();
        List<String> list = lc228.summaryRanges(nums);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0)
            return res;
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                if (list.size() > 1) {
                    res.add(list.get(0) + "->" + list.get(list.size() - 1));
                } else {
                    res.add("" + list.get(0));
                }
                list.clear();
            }
            list.add(nums[i]);
        }
        if (!list.isEmpty()) {
            if (list.size() > 1) {
                res.add(list.get(0) + "->" + list.get(list.size() - 1));
            } else {
                res.add("" + list.get(0));
            }
        }
        return res;
    }

    public List<String> summaryRanges2(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int cur = nums[0], left = 1;
        while(left < nums.length) {
            if(cur == nums[left] - 1) {
                cur = nums[left];
                left++;
            }else {
                list.add(nums[left]);
                left++;
                if(left < nums.length) {
                    list.add(nums[left]);
                }
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
        return null;
    }
}
