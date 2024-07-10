package com.chenyue.experiment.basic.jdk8.interfaces;

/**
 * @author chenyue7@foxmail.com
 */
@FunctionalInterface // 声明该接口是一个lambda接口(只有一个方法)
public interface DefaultMethod {

    void func();

    /*
    a default method
     */
    default void test(){
        System.out.println("Talk is cheap, Show me the code. --Linus Torvalds");
        System.out.println("Go big or go home. --google office slogan");
        System.out.println("Stay hungry Stay foolish. --Steve jobs");
    }
}
