package com.chenyue.experiment.designpattern.strcuturepattern.klassadapter;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description https://refactoringguru.cn/design-patterns/adapter
 */
public class Test {
    public static void main(String[] args) {
        TargetInterface target = new Adapter(); // 将被适配者扩展进适配器（继承）
        target.targetMethod();
    }
}
