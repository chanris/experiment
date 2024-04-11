package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 22/3/2024
 * @description
 * 结论： 数组 & 对象 都是“引用”传值，统一叫 Reference变量，因为该变量都是存的一块内存的首地址，
 * 传参数时，将变量的引用赋值给方法的参数列表
 */
public class ReferenceTest {
    public static void main(String[] args) {
        int[] ints = new int[9];
        test01(ints);
        System.out.println(ints.length); // 打印 9，不是 8，因为传递引用的值
    }

    static void  test01(int[] ints) {
        int[] tmp = new int[8];
        ints = tmp;
    }
}
