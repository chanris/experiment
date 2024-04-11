package com.chenyue.experiment.designpattern.createpattern.factorymethod;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 *
 * 抽象工厂角色（Abstract Factory）：描述具体工厂的公共接口，是具体工厂的父类。
 * 具体工厂角色（Concrete Factory）：描述具体工厂，创建产品的实例，供外界调用，主要实现了抽象工厂中的抽象方法，完成具体产品的创建。
 * 抽象产品角色（Product）：抽象产品角色是简单工厂模式所创建的所有对象的父类,负责描述所有实例所共有的公共接口，它的引入将提高系统的灵活性，使得在工厂类中只需定义一个工厂方法，因为所有创建的具体产品对象都是其子类对象。
 * 具体产品角色（Concrete Product）：具体产品角色是简单工厂模式的创建目标，所有创建的对象都充当这个角色的某个具体类的实例。每一个具体产品角色都继承了抽象产品角色，需要实现定义在抽象产品中的抽象方法，由具体工厂来创建，它同具体工厂之间一一对应。
 *
 * 在上面的例子中，每种类型的车辆（如 Car, Truck 等）都有与之对应的工厂类（如 CarFactory, TruckFactory 等）。
 * 这些工厂类继承自抽象的 VehicleFactory，并覆盖 createVehicle 方法来生产产品。
 * 客户端代码只需与抽象工厂和产品接口打交道，从而实现了对象创建过程的解耦，增强了系统的灵活性。
 */
public class Test {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new CarFactory();
        Vehicle car = vehicleFactory.orderVehicle();
        System.out.println("Ordered a new vehicle: Car\n");

        vehicleFactory = new TruckFactory();
        Vehicle truck = vehicleFactory.orderVehicle();
        System.out.println("Ordered a new vehicle: Truck\n");
    }
}
