package com.chenyue.experiment.oj;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/12
 */
public class lc202 {
    public static void main(String[] args) {
        boolean happy = isHappy(2);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(n, n);
        for(;;) {
            int next = 0;
            while(n != 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            if(next == 1) {
                return true;
            }
            if(m.containsKey(next)) {
                return false;
            }
            m.put(next, next);

            n = next;
        }
    }
}
