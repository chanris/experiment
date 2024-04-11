package com.chenyue.experiment.oj;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyue7@foxmail.com
 * @date 7/3/2024
 * @description
 */
public class lc3 {

    public static void main(String[] args) {
        String s = "dvdf";
        int i = lengthOfLongestSubstring3(s);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int k = 0, ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                ans = Math.max(ans, map.size());
                k++;
                i = k;
                i--;
                map.clear();
            }else {
                map.put(s.charAt(i), 0);
            }
        }
        if(map.size() != 0) {
            ans = Math.max(ans, map.size());
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        if(s.length() == 0) return 0;
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
