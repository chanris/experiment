package com.chenyue.experiment.oj;


/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/11
 */
public class lc134 {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++) {
            int count = 0, j = i;
            int rest = 0;
            while(count < gas.length) {
                j = (i + count) % gas.length;
                rest += gas[j];
                rest -= cost[j];
                if (rest <= 0 && count != gas.length - 1) {
                    break;
                }
                count++;
            }
            if(count == gas.length && rest >= 0) {
                return i;
            }
        }
        return -1;
    }
}
