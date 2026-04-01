package com.chenyue.experiment.oj.matrix;


import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@qq.com
 * @date 2026/3/31
 */
public class lc54 {
    public static void main(String[] args) {
        lc54 lc54 = new lc54();
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        List<Integer> lst = lc54.spiralOrder(matrix);
        System.out.println(lst);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        List<Integer> lst = new ArrayList<>();
        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; i++) {
                lst.add(matrix[top][i]);
            }
            top++;
            if(top > bottom) break;
            for(int i = top; i <= bottom; i++) {
                lst.add(matrix[i][right]);
            }
            right--;
            if(left > right) break;
            for(int i = right; i >= left; i--) {
                lst.add(matrix[bottom][i]);
            }
            bottom--;
            if(top > bottom) break;
            for(int i = bottom; i >= top; i--) {
                lst.add(matrix[i][left]);
            }
            left++;
            if(left > right) break;
        }
        return lst;
    }
}
