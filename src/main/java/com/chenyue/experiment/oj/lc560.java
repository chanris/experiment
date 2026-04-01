package com.chenyue.experiment.oj;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyue7@qq.com
 * @date 2026/3/31
 */
public class lc560 {
    public static void main(String[] args) {
        lc560 lc560 = new lc560();
        lc560.subarraySum(new int[]{1, 1, 1}, 2);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] pre = new int[nums.length];
        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                pre[i] = nums[i];
            }else {
                pre[i] = pre[i-1] + nums[i];
            }
            if(map.containsKey(pre[i] - k)) {
                ans += map.get(pre[i] - k);
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
            if(pre[i] == k) {
                ans++;
            }
        }
        return ans;
    }
}
