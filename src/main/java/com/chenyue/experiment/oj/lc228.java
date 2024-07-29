package com.chenyue.experiment.oj;

import java.util.ArrayList;
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
}
