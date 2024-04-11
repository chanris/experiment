package com.chenyue.experiment.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenyue7@foxmail.com
 * @date 13/3/2024
 * @description
 */
public class lc49 {
    public static void main(String[] args) {
        String[] strs = new String[]{};

        List<List<String>> lists = groupAnagrams(strs);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int val = 1;
            for(Character c : str.toCharArray()) {
                val *= c;
            }
            if(!map.containsKey(val)) {
                List<String> lst = new ArrayList<>();
                lst.add(str);
                map.put(val, lst);
            }else {
                map.get(val).add(str);
            }
        }
        List<List<String>> ans = new ArrayList<List<String>>(map.values());
        return ans;
    }
}
