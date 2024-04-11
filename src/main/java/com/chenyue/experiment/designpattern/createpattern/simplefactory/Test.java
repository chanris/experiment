package com.chenyue.experiment.designpattern.createpattern.simplefactory;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 * 简单工厂模式通过工厂获得一个个新对象，定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，
 * 工厂模式使其创建过程延迟到子类进行。
 * 参考： https://blog.csdn.net/tszc95/article/details/129910486
 */
public class Test {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // 获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        // 获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        // 获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}
