package com.chenyue.experiment.designpattern.createpattern.abstractfactory;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 * 抽象工厂参考:https://refactoringguru.cn/design-patterns/abstract-factory
 * 抽象工厂模式是一种创建型设计模式， 它能创建一系列相关的对象， 而无需指定其具体类。
 * 客户端代码可以通过相应的抽象接口调用工厂和产品类。 你无需修改实际客户端代码， 就能更改传递给客户端的工厂类，
 * 也能更改客户端代码接收的产品变体。
 * 适用于客户端不在乎具体实现的工厂和产品类。客户端仅接触抽象接口就可以了。
 *
 * 最后一点说明： 如果客户端仅接触抽象接口， 那么谁来创建实际的工厂对象呢？ 一般情况下， 应用程序会在初始化阶段创建具体工厂对象。
 * 而在此之前， 应用程序必须根据配置文件或环境设定选择工厂类别。
 */
public class Test {
    public static void main(String[] args) {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println(osName );
        if(osName.contains("windows")) {  // 在应用启动的时候，进行初始化工厂
            factory = new WindowsFactory();
        }else {
            factory = new MacOSFactory();
        }
        app = new Application(factory); // 用户在不了解具体工厂的情况下，也能直接使用工厂提供的服务。
        app.paint();
     }
}
