package com.chenyue.experiment.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 12/1/2024
 * @description
 */
public class lc67 {

    public static void main(String[] args) {
        String s = addBinary("1111", "1111");//  110
        System.out.println(s);
    }
    public static String addBinary(String a, String b) {
        List<Character> res = new ArrayList<>();
        boolean flag = false;
        if(a.length() < b.length()) {
           String t = "";
           t = a;
           a = b;
           b = t;
        }
        char[] c =  reverseString(a).toCharArray();
        char[] c2 = reverseString(b).toCharArray();
        for(int i = 0; i < c.length; i++) {
            int t;
            if(i < c2.length) {
                t = c[i] + c2[i] - '0';
                if(flag) {
                    t = t + '1' - '0';
                }
                if(t > '1') {
                    t = t - '2' + '0';
                    flag = true;
                }else {
                    flag = false;
                }
                res.add((char) t);
            }else if(flag) {
                t = c[i] + '1' - '0';
                if(t > '1') {
                    t = '0';
                }else {
                    flag = false;
                }
                res.add((char) t);
            }else {
                res.add(c[i]);
            }
        }
        if (flag) {
            res.add('1');
        }
        StringBuilder sb = new StringBuilder();
        Collections.reverse(res);
        res.forEach(sb::append);
        return sb.toString();
    }

    public static String reverseString(String original) {
        char[] c = original.toCharArray();
        char[] res = new char[c.length];
        for (int i = c.length - 1, j = 0; i >= 0; i--) {
            res[j++] = c[i];
        }
        return new String(res);
    }
}
