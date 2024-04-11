package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 8/3/2024
 * @description
 */
public class lc2834 {
    public static void main(String[] args) {
        // 39636 39636 156198582
        // 63623 82276 948940307
        // 1000000000 1000000000
        // 13 50 91
        int i = minimumPossibleSum2(13, 50);
        System.out.println(i);
    }

    /**
     * n = 3
     * target = 3
     * 0 0 0 0
     * 0 0 0 0
     * 0 0 0 0
     * 0 0 0 0
     */
    public static int minimumPossibleSum(int n, int target) {
        int[] arr = new int[target / 2 + 1];
        long ans = 0;
        int count = 0;
        for(int i = 1; count < n; i++) {
            if(i < target) {
                int idx = Math.min(i, target - i);
                int flag = arr[idx];
                if(flag == 0) {
                    arr[idx] = 1;
                    ans += i;
                    count ++;
                }
            }else {
                ans += i;
                count++;
            }
        }
        return (int)(ans % 1000000007);
    }

    public static int minimumPossibleSum2(int n, int target) {
        long ans = 0;
        int count = 0;
        int len = ((target - 1 ) / 2 + (target - 1) % 2);
        for(int i = 1; i <= len && count < n; i++) {
            ans+= i;
            count ++;
        }
        for(int i = target; count < n; i++ ) {
            ans+= i;
            count ++;
        }
        return (int)(ans % 1000000007);
    }
}
