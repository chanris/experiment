package com.chenyue.experiment.oj.prefixand;

import java.util.Scanner;

/**
 * @author chenyue7@foxmail.com
 * @date 13/4/2024
 * @description
 * https://blog.csdn.net/m0_60511809/article/details/136628555
 *
 *
 */
public class 求子矩阵和 {
   /*
   7 3 2
   3 5 1
   6 2 4
   7 9 10
   4 3 6
   3 9 9
   6 10 1
   9 10 4
   2 2 7 3
   2 1 4 2
   */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int q = sc.nextInt();
        int[][] mtx = new int[r+1][c+1];
        for (int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                mtx[i][j] = sc.nextInt();
                mtx[i][j] = mtx[i - 1][j] + mtx[i][j - 1] + mtx[i][j] - mtx[i - 1][j - 1];
            }
        }
        for(;q > 0; q--) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            System.out.println(mtx[x2][y2] + mtx[x1 - 1][y1 - 1] - mtx[x2][y1 - 1] - mtx[x1 - 1][y2]);
        }
    }
}
