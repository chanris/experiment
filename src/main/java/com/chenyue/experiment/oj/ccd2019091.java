package com.chenyue.experiment.oj;

import java.util.Scanner;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/16
 */
public class ccd2019091 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, a, drop, i, j;
        int all = 0, maxd = Integer.MIN_VALUE, id = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        for (int k = 0; k < n; k++) {
            a = sc.nextInt();
            all += a;
            drop = 0;
            for (j = 0; j < m; j++) {
                a = sc.nextInt();
                all += a;
                drop-= a;
            }
            if (drop > maxd) {
                maxd = drop;
                id= k;
            }
        }
        System.out.printf("%d %d %d\n", all, id+1, maxd);
    }


    {
       /* Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rounds = sc.nextInt();
        int[] zg = new int[rounds];
        int[] appleTrees = new int[n];
        int apples = 0;
        for (int i = 0; i < n; i++) {
            appleTrees[i] = sc.nextInt();
            for (int j = 0; j < rounds; j++) {
                zg[i] += sc.nextInt();
            }
            appleTrees[i] += zg[i];
            apples += appleTrees[i];
        }
        int idx = Integer.MAX_VALUE;
        int maxZg = Integer.MIN_VALUE;
        for (int i = 0 ; i < zg.length; i++) {
            if (maxZg < -zg[i]) {
                maxZg = -zg[i];
                idx = i;
            }
        }
        System.out.println(apples+" " + (idx+1) +" "+maxZg);*/
    }
}
