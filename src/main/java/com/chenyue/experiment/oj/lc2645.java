package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 11/1/2024
 * @description
 */
public class lc2645 {

    public static void main(String[] args) {
        String sub = "abcabc";
        int a = addMinimum(sub);
        System.out.println(a);
    }

    public static int addMinimum(String word) {
        int d = 0;
        while(word.indexOf("abc") != -1) {
            word = word.replaceFirst("abc", "ABC");
            d++;
        }
        int a = searchSubstring(word, "ab");
        int b = searchSubstring(word, "ac");
        int c = searchSubstring(word, "bc");
        return a + b + c + (word.length() - d * 3 - 2 * (a + b + c)) * 2;
    }

    public static int searchSubstring(String word, String substr) {
        int res = 0;
        int start = 0;
        while(true) {
            int idx;
            if( start < word.length() ) {
                idx = word.indexOf(substr, start);
            }else {
                break;
            }
            if(idx != -1) {
                res++;
                start = idx + 1;
            }else {
                break;
            }
        }
        return res;
    }
}
