package com.chenyue.experiment.algorithm.sorted;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 4/4/2024
 * @description
 */
@SuppressWarnings("all")
public class QuickSortAlgo {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 7, 5, 3, 1, 9};
//        quickSort(nums, 0, nums.length-1);
        quickSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 递归版本
    public static void quickSort(int[] nums, int left, int right) {
        if(left >= right) return;
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            // 先右再左
            while(l < r && nums[r] >= pivot ) {r--;}
            while(l < r && nums[l] <= pivot) {l++;}
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }
        nums[left] = nums[l];
        nums[l] = pivot;
        quickSort(nums, left, r - 1);
        quickSort(nums, r + 1, right);
    }

    // 非递归版快排
    public static void quickSort2(int[] nums) {
        Deque<int[]> st = new LinkedList<>();
        st.addFirst(new int[]{0, nums.length-1});
        while(!st.isEmpty()) {
            int[] crd = st.removeFirst();
            int pivotIdx = partition(nums, crd[0], crd[1]);
            if(pivotIdx != -1) {
                st.addFirst(new int[]{crd[0], pivotIdx-1});
                st.addFirst(new int[]{pivotIdx+1, crd[1]});
            }
        }
    }

    public static int partition(int[] nums, int low, int high) {
        if(low >= high) return -1;
        int pivot = nums[low];
        int l = low;
        int r = high;
        while(l < r) {
            while(l < r && nums[r] >= pivot) {r--;}
            while(l < r && nums[l] <= pivot) {l++;}
            int tmp = nums[r];
            nums[r] = nums[l];
            nums[l] = tmp;
        }
        nums[low] = nums[r];
        nums[r] = pivot;
        return r;
    }
}
