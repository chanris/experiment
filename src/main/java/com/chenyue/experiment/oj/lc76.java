package com.chenyue.experiment.oj;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author chenyue7@foxmail.com
 * @date 3/4/2024
 * @description todo 24/4/4
 */
public class lc76 {
    public static void main(String[] args) {
        lc76 lc76 = new lc76();
        String s = lc76.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }

    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>(t.length());
        HashMap<Character, Integer> tmpMap = new HashMap<>(t.length());
        String ans = "";
        int len = s.length();
        int sum = 0;
        for(Character c : t.toCharArray()) {
            sum += (int)c;
            map.put(c, map.getOrDefault(c, 0) + 1);
            tmpMap.put(c, 0);
        }
        int tmp = 0;
        while(right < len) {
            if(tmp != sum) {
                char c = s.charAt(right++);
                if(map.containsKey(c)) {
                    if(tmpMap.get(c) < map.get(c)) {
                        tmp += (int)c;
                    }
                    tmpMap.put(c, tmpMap.get(c) + 1);
                }
            }
            if(tmp == sum) {
                int l = left;
                int r = right;
                String subStr = s.substring(l, r);
                if(ans.equals("") || ans.length() > subStr.length()) {
                    ans = subStr;
                }

                while(tmp == sum && left < len) {
                    char c = s.charAt(left++);
                    if(map.containsKey(c)) {
                        if(tmpMap.get(c) > map.get(c)) {
                            tmpMap.put(c, tmpMap.get(c) - 1);
                        }else if(tmpMap.get(c) == map.get(c)) {
                            tmp -= (int)c;
                            tmpMap.put(c, tmpMap.get(c) - 1);
                        }
                    }
                }

            }
        }
        return ans;
    }
}
