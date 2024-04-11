package com.chenyue.experiment.jdk8.feature;

/**
 * @author chenyue7@foxmail.com
 */
public class Test {
    public static void main(String[] args) {
        MyImplements.func(()->{
            System.out.println("Hello, World");
        });
    }
}
