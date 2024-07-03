package com.chenyue.experiment.basic.generic;

/**
 * @author chenyue7@foxmail.com
 * @date 22/4/2024
 * @description
 */
public class Recursion {
    static int ans = 0;
    public static void main(String[] args) {
        recursion(8);
        System.out.println(ans);
    }

    public static void recursion(int n) {
        if(n == 0) return;
        recursion(n - 1);
        recursion(n - 1);
        ans++;
    }
}
