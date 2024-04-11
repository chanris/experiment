package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 6/3/2024
 * @description
 */
public class lc121 {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        int i = maxProfit3(arr);
        System.out.println(i);
    }

    //两层循环 会 超时
    public static int maxProfit(int[] prices) {
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            int min = prices[i];
            int max = -1;
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] > max && prices[j] > min) {
                    max = prices[j];
                }
            }
            if(max - min > res) {
                res = max - min;
            }
        }
        return Math.max(res, 0);
    }

    public static int maxProfit2(int[] prices) {
        int ans = 0;
        int buy_i = 0;
        for (int sell_i = 0; sell_i < prices.length; sell_i++) {
            if(prices[buy_i] <= prices[sell_i]) {
                ans = Math.max(ans, prices[sell_i] - prices[buy_i]);
                continue;
            }
            buy_i = sell_i;
        }
        return ans;
    }

    /**
     * 双指针法：
     * 设置两个指针：一个是bugIdx，一个sellIdx， 一次遍历就查询完所有的结果。
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int ans = 0;
        int buyIdx = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[buyIdx] <= prices[i]) {
                ans = Math.max(ans, prices[i] - prices[buyIdx]);
                continue;
            }
            buyIdx = i;
        }
        return ans;
    }

}
