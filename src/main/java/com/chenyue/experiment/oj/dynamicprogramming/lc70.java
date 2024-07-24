package com.chenyue.experiment.oj.dynamicprogramming;

/**
 * @author chenyue7@foxmail.com
 * @date 16/1/2024
 * @description 爬楼梯
 */
public class lc70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(41));
    }
    public static int climbStairs(int n) {
        return f(n);
    }

    public static int f(int n) {
        if(n > 2) {
            return f(n - 1) + f(n - 2);
        }else if (n == 2) {
            return  2;
        }else {
            return 1;
        }
    }
}
