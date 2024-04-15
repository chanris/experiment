package com.chenyue.experiment.designpattern.strcuturepattern.objadapter;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 * 适配器模式是一种结构型设计模式，用于使不兼容的接口之间能够一起工作。
 *
 * 接口兼容性：可以使任何没有实现目标接口的类能够与目标接口一起工作。
 * 解耦：增加了类之间的解耦性，因为引入适配器模式后，可以独立地改变客户端实现或者被适配者的实现而不会相互影响。
 * 代码复用：可以复用现有的类，因为可以使用多个适配器与目标接口一起工作，而不必修改原来的代码
 */
public class Test {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee); // 将被适配者传入适配器（组合）
        target.request(); // 客户调用适配方法
    }
}
