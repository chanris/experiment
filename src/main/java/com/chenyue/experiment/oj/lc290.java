package com.chenyue.experiment.oj;
import java.util.HashMap;
/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/26
 * @description
 */
public class lc290 {
    public static void main(String[] args) {
        lc290 lc = new lc290();
        String pattern = "abba";
        String ss = "dog cat cat dog";
        lc.wordPattern(pattern, ss);
    }

    public boolean wordPattern(String pattern, String ss) {
        String[] s = ss.split(" ");
        HashMap<Character, String> m1 = new HashMap<>();
        HashMap<String, Character> m2 = new HashMap<>();
        if(s.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++) {
            if(!m1.containsKey(pattern.charAt(i)) && !m2.containsKey(s[i])) {
                m1.put(pattern.charAt(i), s[i]);
                m2.put(s[i], pattern.charAt(i));
            }else {
                if(!m1.containsKey(pattern.charAt(i)) || !m1.get(pattern.charAt(i)).equals(s[i])) return false;

            }
        }
        return true;
    }
}
