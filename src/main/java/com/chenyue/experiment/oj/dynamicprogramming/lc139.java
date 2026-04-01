package com.chenyue.experiment.oj.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/23
 * @description
 *
 * dp[i], 长度0..i的s是否由字典拼接
 *
 */
public class lc139 {

    public static void main(String[] args) {
        lc139 lc139 = new lc139();
        boolean b = lc139.wordBreak2("leetcode", List.of("leet", "code"));
    }

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

    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Set<String> st = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                dp[i] = dp[i] || (dp[j] && st.contains(s.substring(j, i)));
            }
        }
        return dp[s.length()];
    }
}
