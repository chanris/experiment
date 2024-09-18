package com.chenyue.experiment.basic.jdk17;

import java.util.Scanner;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/9/18
 * @description jdk 17 新特性之 switch case
 * case 语句可以添加 lambda 表达式，不用写 break;
 * 此外，增加 yield 关键字，case语句可以返回结果
 */
public class SwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        switch (s) {
            case ("xx")-> System.out.println("xx");
            case ("yy")-> System.out.println("yy");
            default -> throw new RuntimeException("flag is not existed.");
        }
        // JDK 17 yield 关键字
        int result = switch (s){
            case ("xx") -> 1;
            case ("yy") -> 2;
            case ("zz") -> 3;
            default -> -1;
        };
        System.out.printf("switch case的返回值：%d%n", result);
    }
}
