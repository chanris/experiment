package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description 测试Integer包装类的比较
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(127);
        Integer b = Integer.valueOf(127);
        var c = Integer.valueOf(128);
        var d = Integer.valueOf(128);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(c == d);
        System.out.println(c.equals(d));
    }
}
