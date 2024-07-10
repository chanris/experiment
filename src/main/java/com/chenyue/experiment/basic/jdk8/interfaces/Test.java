package com.chenyue.experiment.basic.jdk8.interfaces;

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
