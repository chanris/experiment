package com.chenyue.experiment.oj;



/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/11
 */
public class lc12 {
    public static void main(String[] args) {
        String result = intToRoman(3749);
        System.out.println(result);
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int c = num / 1000;
        if (c > 0) {
            sb.append("M".repeat(c));
            num = num - c * 1000;
        }
        c = num / 100;
        if (c == 4) {
            sb.append("CD");
            num = num - c * 100;
        } else if (c == 9) {
            sb.append("CM");
            num = num - c * 100;
        } else {
            c = num / 500;
            if (c > 0) {
                sb.append("D".repeat(c));
                num = num - c * 500;
            }
            c = num / 100;
            if (c > 0) {
                sb.append("C".repeat(c));
                num = num - c * 100;
            }
        }

        c = num / 10;
        if (c == 4) {
            sb.append("XL");
            num = num - c * 10;
        } else if (c == 9) {
            sb.append("XC");
            num = num - c * 10;
        } else {
            c = num / 50;
            if (c > 0) {
                sb.append("L".repeat(c));
                num = num - c * 50;
            }
            c = num / 10;
            if (c > 0) {
                sb.append("X".repeat(c));
                num = num - c * 10;
            }
        }

        if (num == 4) {
            sb.append("IV");
        } else if (num == 9) {
            sb.append("IX");
        } else {
            c = num / 5;
            if (c > 0) {
                sb.append("V".repeat(c));
                num = num - c * 5;
            }
            if (num > 0) {
                sb.append("I".repeat(num));
            }
        }
        return sb.toString();
    }
}
