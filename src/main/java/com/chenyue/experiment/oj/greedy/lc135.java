package com.chenyue.experiment.oj.greedy;

import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 6/5/2024
 * @description leetcode hard 分发糖果
 */
public class lc135 {

    public static void main(String[] args) {
        lc135 lc135 = new lc135();
        int candy = lc135.candy(new int[]{1, 0, 2, 3, 0, 1});
        System.out.println(candy);
    }

    public int candy(int[] ratings) {
        LinkedList<Integer> st = new LinkedList<>();
        int n = ratings.length;
        int[] res = new int[n];
        int ans = 0;
        if(n == 1) {
            return 1;
        }
        st.addFirst(ratings[0]);
        Integer start = null;
        for(int i = 1; i < n; i++) {
            int top = st.peek();
            if(ratings[i] > top) {
                Integer pre = null;
                while(!st.isEmpty()) {

                }
            }
            st.addFirst(ratings[i]);
        }
        if(st.isEmpty()) return ans;
        return ans;
    }
}
