package com.chenyue.experiment.oj.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 5/4/2024
 * @description
 */
public class lc131 {

    public static void main(String[] args) {
        lc131 lc131 = new lc131();
        String s = "aab";
        List<List<String>> partition = lc131.partition(s);
        for (List<String> l : partition) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            res.add(Character.toString(s.charAt(i)));
        }
        ans.add(res);
        int sLen = 2;
        for (int i = sLen; i <= len; i++) {
            List<String> res1 = new ArrayList<>();
            for (int j = 0; j <= (len - sLen); j++) {
                res1.add(s.substring(j, sLen + j));
            }
            if (isPalindrome(res1)) {
                ans.add(res1);
            }
        }
        return ans;
    }

    public List<List<String>> ans = new ArrayList<>();

    public boolean isPalindrome(List<String> subStrList) {
        for (String s : subStrList) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }


}
