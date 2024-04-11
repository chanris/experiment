package com.chenyue.experiment.designpattern.createpattern.builder;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 * LunchOrder类有一个内部静态类Builder。可以连续调用Builder类的方法来设置LunchOrder的不同属性，
 * 并通过调用build()方法来完成构建过程，返回一个LunchOrder对象。这种方式可以让代码更加清晰，
 * 并且由于所有的属性都是通过Builder类设置的，LunchOrder对象一旦创建就是不可变的。
 * 有优点
 * 1. 可以分步创建对象，展缓创建步骤或递归运行创建步骤。
 * 2. 生成不同形式的产品时， 你可以复用相同的制造代码。
 * 3. 单一职责原则。 你可以将复杂构造代码从产品的业务逻辑中分离出来。
 */
public class Test {
    public static void main(String[] args) {
        LunchOrder.Builder builder = new LunchOrder.Builder();

        builder.bread("Wheat").condiments("Lettuce").dressing("Mustard").meat("Ham");
        LunchOrder lunchOrder = builder.build();

        System.out.println(lunchOrder.getBread());
        System.out.println(lunchOrder.getCondiments());
        System.out.println(lunchOrder.getDressing());
        System.out.println(lunchOrder.getMeat());
    }
}
