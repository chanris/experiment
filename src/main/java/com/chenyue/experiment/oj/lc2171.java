package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 18/1/2024
 * @description
 */
public class lc2171 {
    public static void main(String[] args) {
        int[] beans = new int[]{7,77,99,100,22,53,19};
        long l = minimumRemoval(beans);
        System.out.println(l);
    }
    public static long minimumRemoval(int[] beans) {
        for (int i = 0; i < beans.length - 1; i++) {
            for (int j = i + 1; j < beans.length; j++) {
                if(beans[i] > beans[j]) {
                    int tmp = beans[i];
                    beans[i] = beans[j];
                    beans[j] = tmp;
                }
            }
        }
        int cur = Integer.MAX_VALUE;
        for(int i = 0; i < beans.length - 1; i++) {
            int sum = getSum(beans, beans[i], beans[i +1]);
            if(cur > sum) {
                cur = sum;
            }
        }
        return cur;
    }

    public static int getSum(int[] beans, int threshold, int threshold2) {
        int sum = 0;
        for (int i = 0; i < beans.length; i++) {
            if(beans[i] <= threshold) {
                sum += beans[i];
            }else if(beans[i] > threshold2) {
                sum += (beans[i] - threshold2);
            }
        }
        return sum;
    }
}
