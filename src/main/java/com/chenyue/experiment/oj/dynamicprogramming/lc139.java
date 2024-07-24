package com.chenyue.experiment.oj.dynamicprogramming;

import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/23
 * @description
 *
 * dp[i], 长度0..i的s是否由字典拼接
 *
 */
public class lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String string : wordDict) {
                if (i < string.length() - 1)
                    continue;
                if (s.startsWith(string, i - string.length()) && dp[i - string.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
