package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 12/1/2024
 * @description
 */
public class lc69 {
    public static void main(String[] args) {
        int i = mySqrt(2147395599);
        System.out.println(i);
    }

    private  static long target;
    private  static long error = Integer.MAX_VALUE;

    public static int mySqrt(int x) {
        binarySearch(x, 0, x);
        if(x == 0 || x == 1) return x;
        return (int)target;
    }

    public static void binarySearch(long x, long start, long end) {
        if(start <= end) {
            long mid = (end + start ) / 2 + start;
            long gap = x - mid * mid;
            if(gap > 0 && gap < error) {
                error = gap;
                target = mid;
            }
            if((mid * mid) < x) {
                binarySearch(x, mid + 1, end);
            }else if((mid * mid) > x) {
                binarySearch(x, start, mid - 1);
            }else {
                target = mid;
            }
        }
    }
}
