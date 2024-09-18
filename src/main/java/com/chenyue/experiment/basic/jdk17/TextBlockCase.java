package com.chenyue.experiment.basic.jdk17;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/9/18
 * @description JDK17新特性之文本块
 */
public class TextBlockCase {
    public static void main(String[] args) {
        String str = """
                Hello,
                World!
                """;
        System.out.println(str);
    }
}
