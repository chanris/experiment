package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/14
 */
public class lc8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("123-"));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        boolean once = true;
        boolean after = false;
        for (char c : s.toCharArray()) {
            if ((c == '-' || c == '+') && once && !after) {
                sb.append(c);
                once = false;
                continue;
            }
            if (c >= '0' && c <= '9') {
                sb.append(c);
                after = true;
                continue;
            }
            break;
        }
        if ((sb.length() == 1 && (sb.charAt(0) < '0' || sb.charAt(0) > '9') )|| sb.length() <= 0) return 0;
        long res = 0;
        try {
            res = Long.parseLong(sb.toString());
        }catch (Exception e){
            return sb.charAt(0) != '-' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (res <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return Integer.parseInt(Long.toString(res));
    }
}
