package com.chenyue.experiment.oj;
import java.util.HashMap;
/**
 * @author chenyue7@foxmail.com
 * @date 2/4/2024
 * @description
 */
public class lc41 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        lc41 lc41 = new lc41();
        int i = lc41.firstMissingPositive(nums);
        System.out.println(i);
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for(int i = 0; i < n; i++) {
            map.put(nums[i], 1);
        }
        for(int i = 1; i <= n; i++) {
            if(!map.containsKey(i)) {
                return i;
            }
        }
        return n + 1;
    }
}
