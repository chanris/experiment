package com.chenyue.experiment.oj.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 18/3/2024
 * @description 杨辉三角
 * input： 杨辉三角 的行数 numRows
 * output: 生成 杨辉三角的前 numsRows 行
 * eg:
 * numRows : 5
 * ans = [[1],[1, 1], [1, 2, 1]]
 *
 *  dp数组的定义： 定义dp[i] 为 杨辉三角 的i+1行  dp[0] = [1] dp[1] = [1, 1] dp[2] = [1, 2, 1]
 *  找出递推公式   // dp[i] = dp[i - 1][0], dp[i - 1][0] + dp[i - 1][1], .... , dp[i - 1][0]
 *  dp数组初始化 dp[0] = [1]
 *  确定遍历顺序 顺序遍历
 */
public class lc118 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        // dp初始化
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        dp.add(row);

        // 顺序遍历
        for (int i = 1; i < numRows; i ++) {
            ArrayList<Integer> r = new ArrayList<>();
            List<Integer> prev = dp.get(i - 1);
            int a = prev.get(0);
            r.add(a);
            for (int j = 0; j < prev.size() - 1; j++) {
                r.add(prev.get(j) + prev.get(j + 1));
            }
            r.add(a);
            dp.add(r);
        }
        return dp;
    }
}
