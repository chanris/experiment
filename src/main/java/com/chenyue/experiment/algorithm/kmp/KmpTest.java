package com.chenyue.experiment.algorithm.kmp;


import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/12
 */
public class KmpTest {

    public static void main(String[] args) {
        String haystack = "abeababeabf";
        String needle = "abeabf";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        int j = 0; // 目前匹配的长度
        // 构建next数组：[0, i]范围，前后缀字符串相等的长度
        for(int i = 1; i < needle.length(); i++) {
            if (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        j = 0;
        for(int i = 0; i < haystack.length(); i++) {
            // 不匹配，从next找直到匹配，或到 j = 0(从头开始);
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if(j >= needle.length()) {
                return i + 1 - needle.length() ;
            }
        }
        return -1;
    }
}
