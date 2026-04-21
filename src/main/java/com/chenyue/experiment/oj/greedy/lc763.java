package com.chenyue.experiment.oj.greedy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenyue7@qq.com
 * @date 2026/4/20
 */
public class lc763 {
    public static void main(String[] args) {
        lc763 lc = new lc763();
        List<Integer> ans = lc.partitionLabels("caedbdedda");
        System.out.println(ans);
    }

    public List<Integer> partitionLabels(String s) {
        int left = 0, right = 0;
        int maxRight = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        while(right < s.length()) {
            if(right <= maxRight) {
                Character c = s.charAt(right);
                if(!map.containsKey(c)) {
                    map.put(c, s.lastIndexOf(c));
                }
                if(maxRight < map.get(c)) {
                    maxRight = map.get(c);
                }
            }else {
                ans.add(right - left);
                left = right;
                Character c = s.charAt(right);
                if(!map.containsKey(c)) {
                    map.put(c, s.lastIndexOf(c));
                }
                if(maxRight < map.get(c)) {
                    maxRight = map.get(c);
                }
            }
            right++;
        }
        ans.add(right - left);
        return ans;
    }
}
