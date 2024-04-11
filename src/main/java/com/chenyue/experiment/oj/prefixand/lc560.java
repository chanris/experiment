package com.chenyue.experiment.oj.prefixand;

/**
 * @author chenyue7@foxmail.com
 * @date 27/3/2024
 * @description 前缀和
 */
public class lc560 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        lc560 lc560 = new lc560();
        int i = lc560.subarraySum(nums, 2);
        System.out.println(i);
    }


    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        //  前缀和 O(n^2)
        for(int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for(int left = 0; left < len; left++) {
            for(int right = left; right < len; right++) {
                if(preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }
    //前缀和 + hash表
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        //  前缀和 O(n^2)
        for(int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for(int left = 0; left < len; left++) {
            for(int right = left; right < len; right++) {
                if(preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

}
