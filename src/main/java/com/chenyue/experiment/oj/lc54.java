package com.chenyue.experiment.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 19/3/2024
 * @description
 */
public class lc54 {
    List<Integer> ans = new ArrayList<>();
    int[] pos = new int[] { 0, 0 }; // 起始位置
    int[] direct = new int[4]; // 右 下 左 上

    public static void main(String[] args) {
        int[][] mtx = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        lc54 lc54 = new lc54();
        for (Integer i : lc54.spiralOrder(mtx)) {
            System.out.printf("%d ", i);
        }
    }

    /**
     * 维护 行开始、行结束、列开始、列结束 四个下标值
     * 按顺序遍历二维数组，遍历一次就更新 （行/列 开始/结束）下标值，
     * 结束判断 if(行开始 > 行结束 or 列开始 > 列结束 ) 退出循环
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return ans;

        int columnBegin = 0, columnEnd = matrix.length - 1; // 列
        int rowBegin = 0, rowEnd = matrix[0].length - 1; // 行

        while(true) {
            // 左到右
           for (int i = rowBegin; i <= rowEnd; i++) {
               ans.add(matrix[columnBegin][i]);
           }
           if(++columnBegin > columnEnd) {
               break;
           }

           // 右到下
            for (int i = columnBegin; i <= columnEnd; i++) {
                ans.add(matrix[i][rowEnd]);
            }
            if (--rowEnd < rowBegin) {
                break;
            }

            // 下到左
            for (int i = rowEnd; i >= rowBegin; i--) {
                ans.add(matrix[columnEnd][i]);
            }
            if (--columnEnd < columnBegin) {
                break;
            }

            // 左到上
            for (int i = columnEnd; i >= columnBegin; i--) {
                ans.add(matrix[i][rowBegin]);
            }
            if (++rowBegin > rowEnd) {
                break;
            }
         }
        return ans;
    }

}
