package com.chenyue.experiment.oj;


import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/10
 */
public class lc274 {


    public static void main(String[] args) {
        int[] arr = new int[]{1};
        hIndex(arr);
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int maxH = 0;
        for(int i = citations.length - 1; i >= 0; i--) {
            if(maxH < citations[i]) {
                maxH++;
            }
        }
        return maxH;
    }
}
