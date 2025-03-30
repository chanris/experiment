package com.chenyue.experiment.algorithm;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/12/9
 * @description
 */
public class SingletonTest {

    private static Singleton singleton = new Singleton();
    private Singleton singleton2;

    //饿汉式
    public static Singleton getInstance() {
        return singleton;
    }

    //懒汉式
    public  Singleton getInstance2() {
        if (singleton2 == null) {
            synchronized (this) {
                if (singleton2 == null) {
                    singleton2 = new Singleton();
                }
            }
        }
        return singleton2;
    }

    public static class Singleton {
        private Singleton(){}
    }
}
