package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 21/3/2024
 * @description
 */
public class lc240 {
    public static void main(String[] args) {
        lc240 lc240 = new lc240();
        int[][] mtx = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        boolean b = lc240.searchMatrix(mtx, 19);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
