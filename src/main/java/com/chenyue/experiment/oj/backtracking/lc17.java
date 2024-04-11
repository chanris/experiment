package com.chenyue.experiment.oj.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 13/3/2024
 * @description 回溯法：电话号码的字母组合
 */
public class lc17 {

    public static void main(String[] args) {
        lc17 lc17 = new lc17();
        for (String letterCombination : lc17.letterCombinations("234")) {
            System.out.println(letterCombination);
        }
    }

    List<String> result = new ArrayList<>();
    List<Character> path = new ArrayList<>();
    String[] nums = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        backtracking(digits.toCharArray(), 0);
        return result;
    }

    public void backtracking(char[] digits, int depth) {
        // 递归结束 当前当前递归的深度 == digits的长度时，退出递归
        if (depth == digits.length) {
            // 收割结果， 结果都在叶子节点上
            StringBuilder sb = new StringBuilder();
            path.forEach(sb::append);
            result.add(sb.toString());
            return;
        }
        char c = digits[depth];
        char[] num = nums[c - '0'].toCharArray(); // 获得当前深度需要遍历的 char 数组
        for (int i = 0; i < num.length; i++) {
            path.add(num[i]); // 添加当前元素 到 path 集合中，
            backtracking(digits, depth + 1);
            path.remove(path.size() - 1); // 递归结束，退掉当前元素
        }
    }
}
