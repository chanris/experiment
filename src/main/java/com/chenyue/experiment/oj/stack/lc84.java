package com.chenyue.experiment.oj.stack;

import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 15/4/2024
 * @description
 */
public class lc84 {
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> st = new LinkedList<>();
        //数组扩容
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 0; i < heights.length; i++) {
            newHeights[i+1] = heights[i];
        }

        heights = newHeights;
        st.addFirst(0);
        int result = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[st.peek()]) {
                st.addFirst(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.removeFirst();
                st.addFirst(i);
            } else {
                while(heights[i] < heights[st.peek()]) {
                    int mid = st.peek();
                    st.removeFirst();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                    System.out.println("left:" + left + " ,mid:" +mid + " ,right:" + right);
                }
                st.addFirst(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        lc84 lc84 = new lc84();
        int[] heights = new int[]{2,1,5,6,2,3};
        int i = lc84.largestRectangleArea(heights);
        System.out.println(i);
    }
}
