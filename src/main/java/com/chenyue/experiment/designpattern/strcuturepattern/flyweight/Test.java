package com.chenyue.experiment.designpattern.strcuturepattern.flyweight;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description 享元模式（Flyweight Pattern）主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，
 * 它通过与相似对象共享尽可能多的数据来达到这一目的，这通常涉及到一个工厂创建一个享元池来管理对象存储和重用。
 */
public class Test {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("key1");
        Flyweight flyweight2 = factory.getFlyweight("key2");
        Flyweight flyweight3 = factory.getFlyweight("key1"); // Reuses the existing instance

        flyweight1.doOperation("op1");
        flyweight2.doOperation("op2");
        flyweight3.doOperation("op3"); // Will have the same intrinsic state as 'flyweight1'
    }
}
