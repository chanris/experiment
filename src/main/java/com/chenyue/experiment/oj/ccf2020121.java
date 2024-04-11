package com.chenyue.experiment.oj;

import java.util.Scanner;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/14
 */
public class ccf2020121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w, score;
        int relu = 0;
        while (n-- != 0) {
            w = sc.nextInt();
            score = sc.nextInt();
            relu += w*score;
        }
        relu = Math.max(0, relu);
        System.out.println(relu);
    }
}
