package com.chenyue.experiment.oj.binarysearch;

/**
 * @author chenyue7@foxmail.com
 * @date 31/3/2024
 * @description
 */
public class lc107 {
    public static void main(String[] args) {
        lc107 lc107 = new lc107();
        int[][] mtx = new int[][]{{1}};
        boolean b = lc107.searchMatrix(mtx, 0);
        System.out.println(b);
    }

    boolean flag = false;
    public boolean searchMatrix(int[][] matrix, int target) {
        //BS(matrix, matrix.length / 2, 0, matrix[0].length - 1,  target);
        int i = rBs(matrix, target);
        if (i == -1) {
            return false;
        }
        int cBegin = 0, cEnd = matrix[i].length - 1;
        while(cBegin <= cEnd) {
            int mid = (cBegin + cEnd) / 2;
            if(matrix[i][mid] == target) return true;
            else if(matrix[i][mid] > target) {
                cEnd = mid - 1;
            }else {
                cBegin = mid + 1;
            }
        }
        return flag;
    }

    public int rBs(int[][] matrix,int target) {
        int rBegin = 0;
        int rEnd = matrix.length - 1;
        while (rBegin <= rEnd) {
            int mid = (rBegin + rEnd) / 2;
            if (matrix[mid][0] == target) return mid;
            else if(matrix[mid][0] > target) {
                rEnd = mid - 1;
            }else {
                rBegin = mid + 1;
            }
        }
        return rEnd;
    }

}
