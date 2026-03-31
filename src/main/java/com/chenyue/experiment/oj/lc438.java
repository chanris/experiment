package com.chenyue.experiment.oj;

import java.util.*;

/**
 * @author chenyue7@foxmail.com
 * @date 7/3/2024
 * @description
 */
public class lc438 {

    public static void main(String[] args) {
        String s = "bpaa"; // 9 7
        String p = "aa";
        List<Integer> list = findAnagrams3(s, p);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Integer> findAnagrams3(String s, String p) {
        int[] cnts = new int[26];
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;
        int l = 0, r  = p.length(), n = 0;
        n = p.length();
        for(int i = 0; i < p.length(); i++) {
            cnts[p.charAt(i) - 'a']++;
        }
        for(int i = 0; i < p.length(); i++) {
            int b = --cnts[s.charAt(i) - 'a'];
            if(b >= 0) {
                n--;
            }else {
                n++;
            }
        }
        if(n == 0) {
            ans.add(l);
        }
        while(r < s.length()) {
            int a = cnts[s.charAt(l) - 'a']++;
            // 从滑动窗口拿掉一个 根据 cnts的值来判断 n++/n--
            // 如果cnts > 0
            if(a >= 0) {
                n++;
            }else {
                n--;
            }
            l++;
            int b = cnts[s.charAt(r) - 'a']--;
            if(b  <= 0) {
                n++;
            }else {
                n--;
            }
            r++;
            if(n == 0) {
                ans.add(l);
            }
        }
        return ans;
    }

    // 错误思路： 利用 p的ascii码 和值 作为判断条件，会出现  "af" == "be" 的情况。
    public static List<Integer> findAnagrams2(String s, String p) {
        int left = 0;
        List<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        Set<Character> st = new HashSet<>(p.length());
        int sum = 0;
        for(int i = 0; i < p.length(); i++) {
            sum += p.charAt(i);
            st.add(p.charAt(i));
        }
        int tmp = 0;
        for(int i = 0; i < s.length(); i++) {
            tmp += s.charAt(i);
            if(tmp > sum || (i - left + 1) > p.length()) {
                tmp -=  s.charAt(left);
                left++;
            }
            if (tmp == sum) {
                boolean flag = true;
                String sbStr = s.substring(left, left + p.length());
                for (int j = 0; j < p.length(); j++) {
                    if (sbStr.indexOf(p.charAt(j)) == -1) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    ans.add(left);
                    tmp -= s.charAt(left);
                    left ++; // 找下一个起始索引
                }
            }
        }
        return ans;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;
        for(int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            // 构建滑动窗口
            sCount[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for(int i = 0; i < s.length() - p.length(); i++) {
            // 滑动
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + p.length()) - 'a']++;
            if(Arrays.equals(sCount, pCount)) {
                ans.add(i+1);
            }
        }
        return ans;
    }

}
