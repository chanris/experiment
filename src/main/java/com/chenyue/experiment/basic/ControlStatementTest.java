package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 15/5/2024
 * @description 测试结果表明：for循环相同情况下总好于等于 while循环
 */
public class ControlStatementTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000000000; i++) {}
        long endTime = System.currentTimeMillis();
        System.out.println("for loop 耗时:" + (endTime - startTime) + "ms");


        long startTime2 = System.currentTimeMillis();
        int i = 0;
        while (i < 2000000000) {i++;}
        long endTime2 = System.currentTimeMillis();
        System.out.println("while loop 耗时:" + (endTime2 - startTime2) + "ms");
    }
}
