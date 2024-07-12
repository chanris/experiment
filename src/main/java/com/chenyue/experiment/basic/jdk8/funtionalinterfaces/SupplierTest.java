package com.chenyue.experiment.basic.jdk8.funtionalinterfaces;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/13
 * @description Supplier 和 Consumer的区别
 * Supplier的 get方法有返回值，而Consumer的accept没有返回值
 */
public class SupplierTest {
    public static void main(String[] args) {
        // 定义一个Supplier，用于生成随机数
        Supplier<Integer> randomSupplier = () -> {
            Random random = new Random();
            return random.nextInt(100); // 生成0到99之间的随机数
        };

        // 获取随机数
        int randomNumber = randomSupplier.get();
        System.out.println("Random number: " + randomNumber);
    }
}
