package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 22/3/2024
 * @description
 */
public class ReferenceTest {
    public static void main(String[] args) {
        int[] ints = new int[9];
        test01(ints);
        System.out.println(ints.length);
    }

    static void  test01(int[] ints) {
        int[] tmp = new int[8];
        ints = tmp;
    }
}
