package com.chenyue.experiment.oj;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 19/3/2024
 * @description 矩阵置零、
 *
 * 使用一个一维数组，记录i行是否需要全部置为0，j列是否需要全部置为0;
 */
public class lc73 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}, {0, 10, 11, 12}, {13, 14, 15, 0}};
        setZeroes(matrix);
        System.out.println(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        int len = matrix.length + matrix[0].length;
        boolean[] flag = new boolean[len];
        for (int i = 0; i < matrix.length; i++) { // row
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    flag[i] = true; // i 行
                    flag[matrix.length + j] = true; // j 列
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (i < matrix.length && flag[i]) {
                Arrays.fill(matrix[i], 0); // 指行 为 0
            }
            if (i >= matrix.length && flag[i]) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i - matrix.length] = 0;
                }
            }
        }
    }
}
