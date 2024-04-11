package com.chenyue.experiment.oj;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/12
 */
public class lc6 {
    public static void main(String[] args) {
        System.out.println(convert2("PA", 1));
    }

    public static String convert(String s, int numRows) {
        int len = s.length();
        if (len == 1 || numRows == 1) {
            return s;
        }
        int flag = 1;
        int row = 0;
        String[] res = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = "";
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            res[row] += c;
            row += flag;
            if (row == numRows-1 || row == 0) {
                flag = -flag;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String part: res) {
            //System.out.println(part);
            sb.append(part);
        }
        return sb.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c: s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows -1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
