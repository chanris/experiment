package com.chenyue.experiment.basic.jdk8.funtionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/13
 * @description 测试函数式接口-Consumer<T>
 *  Consumer.andThen 用来组合两个 Consumer
 */
public class ConsumerTest {
    public static void main(String[] args) {
//        m1();

        // 创建一个包含字符串的列表
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "C#", "Ruby");

        // 使用Consumer来处理列表中的每个元素
        Consumer<String> printConsumer = language -> System.out.println("Learning " + language);

        // 使用forEach方法迭代处理列表中的每个元素
        languages.forEach(printConsumer);
    }

    private static void m1() {
        // 定义第一个Consumer，用于打印字符串的长度
        Consumer<String> printLength = str -> System.out.println("Length of '" + str + "': " + str.length());

        // 定义第二个Consumer，用于将字符串转换为大写并打印
        Consumer<String> printUpperCase = str -> System.out.println("Uppercase of '" + str + "': " + str.toUpperCase());

        // 使用andThen方法组合两个Consumer
        Consumer<String> combinedConsumer = printLength.andThen(printUpperCase);

        // 测试组合后的Consumer
        combinedConsumer.accept("java");
        combinedConsumer.accept("python");
    }
}
