package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 24/4/2024
 * @description 测试除零异常和finally 语句
 */
public class ExceptionTest {

    public static int f(int b) {
        int a = 50;
        try {
            System.out.println("before statement");
            a %= b;
            System.out.println("after statement a:" + a);
            return a;
        }catch (Exception e) {
            System.out.println("catch statement");
            return -100;
        }finally {
            System.out.println("finally statement");
//            return 100;
        }
    }

    public static void main(String[] args) {
        int f = f(10); // throws ArithmeticException: / by zero 除零异常
        System.out.println(f);
    }
}
