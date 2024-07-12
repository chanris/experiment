package com.chenyue.experiment.basic.jdk8.funtionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/13
 * @description Function 和 Supplier 的区别
 * Function的apply  有参数， 而Supplier的get方法没有参
 */
public class FunctionTest {
    public static void main(String[] args) {
        testIdentity();

       /* // 创建一个包含字符串的列表
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "C#", "Ruby");

        // 定义一个Function，用于将字符串转换为它们的长度
        Function<String, Integer> lengthFunction = str -> str.length();

        // 使用map方法将列表中的每个字符串映射为它们的长度
        languages.stream()
                .map(lengthFunction)
                .forEach(length -> System.out.println("Length: " + length));*/
    }

    private static void  testIdentity() {
        /*List<String> languages = Arrays.asList("java", "python", "javascript");

        // 使用map和identity将列表中的每个元素转换为大写形式
        List<String> upperCaseLanguages = languages.stream()
                .map(String::toUpperCase) // 使用方法引用
                .collect(Collectors.toList());

        System.out.println("Uppercase languages: " + upperCaseLanguages);*/

        // 使用Function.identity()作为默认转换函数
        Function<String, String> transformFunction = Function.identity();

        // 使用转换函数进行处理
        String result = transformFunction.apply("Hello, World!");

        System.out.println("Result: " + result);
    }
}
