package com.chenyue.experiment.algorithm.sorted;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/19
 */
@SuppressWarnings("all")
public class SortAlgorithm {

    public static void main(String[] args) {
//        selectSort();
//        bubbleSort();

        // 快排
       /* int[] arr = {2,4,1,8,5,7,9,3,6,10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("quick sorted: " + Arrays.toString(arr));*/

        int[] array = {12, 11, 13, 5, 6, 7};

        sort(array, 0, array.length - 1);

        System.out.println("\n排序后的数组");
    }

    // 选择排序 最坏O(n^2)
    public static void selectSort() {
        int tmp;
        int[] arr = {2,4,1,8,5,7,9,3,6,10};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        System.out.println("select sorted: " + Arrays.toString(arr));
    }

    // 冒泡排序 最坏O(n^2)
    public static void bubbleSort() {
        int tmp;
        int[] arr = {2,4,1,8,5,7,9,3,6,10};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = arr.length-1; j > i; j--) {
                if (arr[j-1] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
        System.out.println("bubble sorted: " + Arrays.toString(arr));
    }

    /**
     * 快排 使用分支思想， 基于基准进行排序，
     * 每次选择一个基准元素， 通过排序 使得  基准元素之前的元素 小于 基准元素， 基准元素之后的元素 大于基准元素
     * @param array
     * @param low
     * @param high
     */
    public static void quickSort(int[] array, int low, int high) {
        if(low < high) {
            // 获得分区
            int partitionIndex = partition(array, low, high);

            // 对分区的两侧进行递归排序
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // 选择最后一个元素作为基准
        int privot = array[high];

        // 初始化分区索引
        int i = low - 1;

        // 从低到高遍历数组
        for(int j = low; j < high; j++) {
            if(array[j] <= privot) {
                i++;
                swap(array, i, j);
            }
        }
        // 将基准值放在正确的位置，并返回分区索引
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 归并排序函数
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            // 找到中间点，将数组分成两个部分
            int middle = (left + right) / 2;

            // 对左半部分排序
            sort(array, left, middle);
            // 对右半部分排序
            sort(array, middle + 1, right);

            // 合并这两部分
            merge(array, left, middle, right);
        }
    }

    // 合并函数
    public static void merge(int[] array, int left, int middle, int right) {
        // 找出左右子数组的大小
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // 创建临时数组
        int L[] = new int[n1];
        int R[] = new int[n2];

        // 拷贝数据到临时数组中
        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[middle + 1 + j];

        // 合并临时数组

        // 初始化索引
        int i = 0, j = 0;

        // 初始化合并数组的起始索引
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // 拷贝剩余的元素
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }


}
