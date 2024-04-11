package com.chenyue.experiment.oj;

import java.util.*;


/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/14
 */
public class ccf2020122 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int i,j,k;
        for (k = 0; k < n; k++) {
           a[k] = sc.nextInt();
           b[k] = sc.nextInt();
        }
        int maxAc = Integer.MIN_VALUE;
        int maxThreshold = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {
            int threshold = a[i];
            int ac = 0;
            for (j = 0; j < n; j++) {
                int predicate = threshold <= a[j] ? 1 : 0;
                if (predicate == b[j]) {
                    ac++;
                }
                if (ac > maxAc) {
                    maxAc  = ac;
                }
                if (threshold > maxThreshold && ac == maxAc) {
                    maxThreshold  = threshold;
                }
            }
        }
        System.out.println(maxThreshold);
    }
}
