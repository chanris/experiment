package com.chenyue.experiment.oj.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 14/4/2024
 * @description 单调栈
 */
public class lc739 {
    // 方法：找到每个元素右边的第一个更大元素
    public int[] dailyTemperatures(int[] temperatures) {
        int lens = temperatures.length;
        int[] res = new int[lens];
        Deque<Integer> st = new LinkedList<>();
        st.addFirst(0);
        for (int i = 1; i < lens; i++) {
            if(temperatures[i] <= temperatures[st.peek()]) {
                st.addFirst(i);
            }else {
                /**
                 * 如何退栈
                 * 当栈顶的元素小于当前元素 则说明找到了栈顶元素右边第一个大的元素
                 * 此时就可以退栈了
                 */
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    res[st.peek()] = i - st.peek();
                    st.removeFirst();
                }
                st.addFirst(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,72,76,73}; // 示例数组
        lc739 lc739 = new lc739();
        int[] result = lc739.dailyTemperatures(nums); // 调用方法找到每个元素右边的第一个更大元素
        System.out.println(Arrays.toString(result));
    }
}
