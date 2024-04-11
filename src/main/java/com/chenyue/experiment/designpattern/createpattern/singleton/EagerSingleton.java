package com.chenyue.experiment.designpattern.createpattern.singleton;

/**
 * @author chenyue7@foxmail.com
 *
 * 饿汉单例:在jvm加载class时,自动创建单例
 * 在加载class是天然单线程，不用担心线程安全
 */
public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton(); // 类加载，天然单线程

    private EagerSingleton(){} // 私有构造器
}
