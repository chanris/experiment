package com.chenyue.experiment.oj.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 13/3/2024
 * @description 回溯法： 全排列
 */
public class lc46 {
    public static void main(String[] args) {
        lc46 lc46 = new lc46();
        int[] nums = new int[]{1, 2, 3};
        for (List<Integer> list : lc46.permute(nums)) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path= new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // 叶子节点 收割结果
        // 什么时候到达叶子节点
        result.clear();
        path.clear();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return result;
    }

    // 回溯法主体
    void backtracking(int[] nums, boolean[] used) {
        // 递归结束条件 就是 搜索路径长度 ==  数组长度
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return; // 结束递归
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果被使用跳过搜索
            if (used[i]) continue;
            // 没有被使用，继续搜索
            used[i] = true; // 使用标记 置为 true
            path.add(nums[i]); // 添加到路径中
            backtracking(nums, used); // 继续搜索
            path.remove(path.size() - 1); // 当前递推结束时，要将当前节点从路径中删除
            used[i] = false; // 使用标记置为 false，供下次使用
        }
    }
}
