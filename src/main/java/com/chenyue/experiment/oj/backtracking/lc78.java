package com.chenyue.experiment.oj.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 13/3/2024
 * @description 回溯法；求子集
 * https://programmercarl.com/0078.%E5%AD%90%E9%9B%86.html#%E6%80%9D%E8%B7%AF
 */
public class lc78 {

    public static void main(String[] args) {
        lc78 lc78 = new lc78();
        int[] nums = new int[]{1, 2, 3};
        for (List<Integer> subset : lc78.subsets(nums)) {
            System.out.println(Arrays.toString(subset.toArray()));
        }

    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.clear();
        path.clear();
        result.add(new ArrayList()); // 添加空集
        backtracking(nums, 0);
        return result;
    }

    // 回溯主体
    public void backtracking(int[] nums, int startIdx) {
        // 设置递归结束条件 路径集合长度 == 数组长度 结束递归
        if (nums.length == path.size()) {
            return;
        }
        for (int i = startIdx; i < nums.length; i++) {
            // 当前元素添加到 路径集合中
            path.add(nums[i]);
            // 记录当前路径集合 到 结果集（因为是求所有的子集，所有每次的路径集合都需要）
            result.add(new ArrayList<>(path));
            backtracking(nums, i + 1); // startIdx + 1 : 防止得到重复的子集集合，也是剪枝操作
            path.remove(path.size() - 1); // 递归结束，将当前节点从路径集合中拿掉
        }
    }
}
