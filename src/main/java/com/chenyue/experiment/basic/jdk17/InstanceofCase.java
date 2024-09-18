package com.chenyue.experiment.basic.jdk17;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/9/18
 * @description
 * instanceof Class 后，一般还需要强制转换为该类型，
 * JDK 16 引入的 instanceof模式匹配作为语法糖，可以简化代码
 */
public class InstanceofCase {
    public static void main(String[] args) {
        Object s = "Hello, World!";
//        System.out.println(s instanceof String);
        if (s instanceof String str) {
            System.out.println(str);
        }else {

        }
    }
}
