package com.chenyue.experiment.algorithm.sorted;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author chenyue7@foxmail.com
 * @date 4/4/2024
 * @description 自顶向下 使用递归法 把数组分为更小
 */
public class MergeSortAlgo {
    // 归并排序
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    // 自顶向下的归并排序
    private void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            System.out.printf("left: %d, right: %d\n", left, right);
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid); // 对左半部分进行归并排序
            mergeSort(arr, temp, mid + 1, right); // 对右半部分进行归并排序
            merge(arr, temp, left, mid, right); // 合并两个有序数组
            System.out.println(Arrays.toString(temp));
        }
    }

    // 合并两个有序数组
    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
//        System.out.printf("left: %d, mid: %d, right: %d\n", left, mid, right);
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }

    // 测试
    public static void main(String[] args) {
//        int[] arr = {12, 11, 13, 5, 6, 7};
//        MergeSort mergeSort = new MergeSort();
//        mergeSort.mergeSort(arr);
//        System.out.println("排序后的数组:");
//        for (int num : arr) {
//            System.out.print(num + " ");
//        }
        System.out.println(".".repeat(0));
        HashSet set = new HashSet();

    }
}
