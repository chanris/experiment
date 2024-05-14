package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 6/5/2024
 * @description
 */
public class lc151 {
    public static void main(String[] args) {
        lc151 lc151 = new lc151();
        String s = lc151.reverseWords("a good   example");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split(" ");
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        for(int i = n - 1; i >= 0; i--) {
            if(arr[i] != "") {
                sb.append(arr[i]);
                if(i != 0) {
                    sb.append(" ");
                }
            }

        }
        return sb.toString();
    }
}
