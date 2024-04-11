package com.chenyue.experiment.oj;

import java.util.regex.Pattern;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/15
 */
public class lc10 {
    public static void main(String[] args) {
        System.out.println(isMatch("",""));
    }

    public static boolean isMatch(String s, String p) {
        return Pattern.matches("\\?x*", "1x");
    }
}
