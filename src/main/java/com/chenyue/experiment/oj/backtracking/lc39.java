package com.chenyue.experiment.oj.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 13/3/2024
 * @description 组合总和
 * 回溯法
 *
 * candidatess = []整数数组
 * target = 7 ， 需要剪枝
 *
 * 路径上的和 如果大于 target 则直接剪枝，不在搜索，
 * 如果路径上的和 小于 target 则 继续搜索 加深递归层数，
 * 当路径 长度 == candidates长度时，结束递归。
 * 求子集的变种问题
 *
 * 每个path元素可以重复使用， 就是 当前元素选取了，更深的递归层依然可以选取
 */
public class lc39 {

    public static void main(String[] args) {
        lc39 lc39 = new lc39();
        int[] nums = new int[]{2, 3, 6, 7};
        List<List<Integer>> lists = lc39.combinationSum(nums, 7);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0,  target, 0);
        return  result;
    }

    public void backtracking(int[] candidates, int startIdx, int target, int sum) {
        // 判断 是否符合条件
        if(sum == target) {
            //写入结果中
            result.add(new ArrayList<>(path));
        }
        // 设置递归结束 条件
        if (sum > target) {
            return;
        }
        for (int i = startIdx; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, i, target, sum); // 注意：这里传的i，不是startIdx
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
