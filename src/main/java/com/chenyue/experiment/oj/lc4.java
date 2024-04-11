package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 29/3/2024
 * @description
 */
public class lc4 {
    public static void main(String[] args) {
        lc4 lc4 = new lc4();
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double medianSortedArrays = lc4.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        if(m == 0) {
            if(n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            }else {
                return  nums2[n / 2] / 2.0;
            }
        }
        if(n == 0) {
            if(n % 2 == 0) {
                return (nums1[n / 2 - 1] + nums1[n / 2]) / 2.0;
            }else {
                return nums1[n / 2] / 2.0;
            }
        }
        int count = 0;
        int i = 0, j = 0;
        for(;count != (m+n);) {
            if(i == m) {
                while(j < n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if(j == n) {
                while(i < m) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if(nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            }else {
                nums[count++] = nums2[j++];
            }
        }

        return  (m + n) % 2 == 0 ? (nums[(n + m)  / 2 - 1] + nums[(n+m) / 2]) / 2.0 : nums[(n+m) / 2];

    }
}
