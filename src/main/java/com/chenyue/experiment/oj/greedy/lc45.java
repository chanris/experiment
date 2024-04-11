package com.chenyue.experiment.oj.greedy;

/**
 * @author chenyue7@foxmail.com
 * @date 25/3/2024
 * @description
 */
public class lc45 {
    public static void main(String[] args) {
        lc45 lc45 = new lc45();
        int[] nums = new int[]{2,3,0,1,4};
        int jump = lc45.jump(nums);
        System.out.println(jump);
    }

    public int jump(int[] nums) {
        int startIdx = 0;
        if (nums.length == 1) {
            return nums[0] > 0 ? 1 : -1;
        }
        int ans = 0;
        do {
            int scopeLen = startIdx + nums[startIdx];
            int max = startIdx + nums[startIdx];
            if (scopeLen >= nums.length - 1) {
                return ++ans;
            }
            System.out.println("From startIdx: " + startIdx);
            for (int i = startIdx; i <= scopeLen; i++) {
                if (max < (i + nums[i])) {
                    startIdx = i;
                    max = (i + nums[i]);
                }
            }
            System.out.println("To startIdx: " + startIdx);
            ans++;
        } while (startIdx < nums.length);
        return ans;
    }
}
