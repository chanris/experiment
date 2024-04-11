package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 2022/1/20 21:55
 * 大数相乘
 */
public class NC1 {
    public static void main(String[] args) {
        String s = "99999999999999999999999999999999999999999999999999999999999994";
        String t = "9";
        System.out.println(solve(s,t));
    }

    public static String solve(String s, String t) {
        String longer, shorter;
        boolean isDiff = true;
        if(s.length() > t.length()) {
            longer = s;
            shorter = t;
        }else if(s.length() < t.length()) {
            longer = t;
            shorter = s;
        }else {
            longer = s;
            shorter = t;
            isDiff = false;
        }

        StringBuffer res = new StringBuffer();
        int c = 0; // 进位
        int i = longer.length() - 1, j = shorter.length() - 1;
        for(; j>=0; i--, j--) {
            int c1 = shorter.charAt(j) - '0';
            int c2 = longer.charAt(i) - '0';
            int cur = c1 + c2 + c;
            if (cur > 9) {
                c = 1;
                cur -= 10;
            }else {
                c = 0;
            }
            res.insert(0, cur);
        }

        if (isDiff) {
            while (i>=0) {
                int temp = longer.charAt(i) - '0';
                int cur = temp + c;
                if (cur > 9) {
                    c = 1;
                    cur -= 10;
                }else {
                    c = 0;
                }
                res.insert(0, cur);
                i--;
            }
        }
        if (c == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }
}
