package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/13
 */
public class lc5 {
    public static void main(String[] args) {
//        System.out.println("sbccc".substring(1,5));
        //System.out.println(longestPalindrome("bbacbca"));
        System.out.println(mySubString("abcded", 0, 1));
    }


    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        if (s.length() == 2 && palindromeString(s)) {
            return s;
        }else if (s.length() == 2){
            return s.substring(0, 1);
        }
        if (palindromeString(s)) return s;
        int from = 0, len = 1;
        String res = s.substring(0,1);
        while (true) {
            if (from+len > s.length()) {
                from = 0;
                len++;
            }
            if (from == 0 && len >= s.length()) break;
            String tmp = subStringByLen(s, from, len);
            boolean b = palindromeString(tmp);
            if (b) {
                res = tmp;
                from = 0;
                len++;
                continue;
            }
            from++;
        }
        return res;
    }
    /**
     * 获得指定长度的字串
     * String.subString(int beginIndex, int endIndex) 不包含endIndex 指定的数
     */
    public static String subStringByLen(String source, int from ,int len) {
        return source.substring(from,from+len);
    }

    public static boolean palindromeString(String source) {
        if (source.length() == 1) return true;
        for (int i = 0; i < source.length() / 2; i++) {
            if (source.charAt(i) != source.charAt(source.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * beginIndex >= 0 开始下标 (长度包含本身,即从本身开始数)
     * len >= 1
     */
    public static String mySubString(String source, int beginIndex, int len) {
        int endIndex = beginIndex+len-1;
        if (endIndex >= source.length()) throw new StringIndexOutOfBoundsException("error index: " + endIndex + " | source.length() == " + source.length());
        return source.substring(beginIndex, endIndex+1);
    }
}
