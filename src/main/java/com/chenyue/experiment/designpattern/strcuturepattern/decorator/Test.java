package com.chenyue.experiment.designpattern.strcuturepattern.decorator;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 *
 * 装饰模式运行想一个对象动态添加新的行为，而不改变其结构。
 * 这种类型的设计模式属于结构型模式，它是作为现有类的一个包装。
 * 装饰模式与代理的区别？
 * 主要用于动态地给一个对象增加额外的职责（功能扩展），而不改变其接口。这个模式创建了一个装饰类来包裹原有的类，并提供了其他功能扩展。
 * 而代理模式主要用于控制对一个对象的访问，可以在不改变客户端的情况下在对象的处理流程前或后加入特定的逻辑。
 * 装饰模式与代理的区别？
 * 继承是面向对象的一个基本特征，运行一个类继承另一个类的特性和行为。继承在编译时定义的，一旦定义了继承关系，运行时就不可以改变
 * 紧耦合：子类和父类之间的关系是固定的，子类继承了父类的所有特性，有时甚至可以访问父类的内部成员。
 * 装饰模式是设计模式的一种，允许动态地向一个对象添加额外的功能，这是通过创建一个包装对象来实现的，而不是通过继承。
 * 装饰可以在运行时添加，也可以根据需要动态地撤销，增加了系统的灵活性。继承是静态的，装饰是动态的。继承与父类紧密绑定，装饰提供松耦合的扩展。
 * 继承可能破坏封装，装饰提倡小的对象组合
 */
public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decoratedComponent = new ConcreteDecorator(component);
        decoratedComponent.operation();
    }
}
