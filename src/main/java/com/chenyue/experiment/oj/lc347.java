package com.chenyue.experiment.oj;

import java.util.*;

/**
 * @author chenyue7@foxmail.com
 * @date 2/4/2024
 * @description
 */
public class lc347 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        lc347 lc347 = new lc347();
        int[] ints = lc347.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // int[] counts = new int[len + 1];
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        List<Freq> list = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            list.add(new Freq(key, value));
        }
        Collections.sort(list);
        int[] ans = new int[k];
        int c = 0;
        for (int i = list.size() - 1; i >= 0 && k > 0; i--, k--) {
            ans[c++] = list.get(i).val;
        }
        return ans;
    }

    public static class Freq implements Comparable<Freq>{
        public Freq(int val, int count) {
            this.val = val;
            this.count = count;
        }
        int val;
        int count;

        @Override
        public int compareTo(Freq o) {
            return this.count - o.count;
        }
    }
}
