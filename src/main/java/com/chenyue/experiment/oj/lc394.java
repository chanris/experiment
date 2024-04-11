package com.chenyue.experiment.oj;

import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 8/4/2024
 * @description
 */
public class lc394 {
    public static void main(String[] args) {
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        lc394 lc394 = new lc394();
        String s1 = lc394.decodeString(s);
        System.out.println(s1);
    }
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        int multi = 0;
        for (Character c: s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                multi = 0;
                stack_res.addLast(res.toString()); // 进辅助栈
                res = new StringBuilder(); // 进辅助栈后， 重置 当前res
            }else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast(); // 取出之前存的 mutli
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }else if('0' <= c && c <= '9') multi = 10 * multi + Integer.parseInt(c + "");
            else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
