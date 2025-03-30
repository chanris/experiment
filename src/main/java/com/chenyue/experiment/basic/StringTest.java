package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/15
 * @description
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "leetcode";
        String word = "leet";
        boolean b = s.startsWith(word, 0);
//        System.out.println(b);

        System.out.println("getTypeName: " + s.getClass().getTypeName());
        System.out.println("getName: " + s.getClass().getName());
    }
}
