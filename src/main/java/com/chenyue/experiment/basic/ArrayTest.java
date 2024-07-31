package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/29
 * @description 测试二维数组的初始化
 */
public class ArrayTest {
    public static void main(String[] args) {
        // 二维数组初始化可以不指定第二维的长度，默认null
        int[][] matrix = new int[10][];
        // 指定二维长度
        int[][] mtx = new int[10][11];
        // mtx[1][11] = 10; // 指定了长度越界会抛异常
        // matrix[1][1] = 10; // 未指定长度 默认第二维的数组为null，必须先初始化才能赋值
        matrix[1] = new int[100];
        matrix[2] = new int[200];
        matrix[1][99] = Integer.valueOf("10000");
        System.out.println(matrix[1][99]);
        // 默认元素为 0
        int[] array = new int[10];
        System.out.println(array[1]);
    }
}
