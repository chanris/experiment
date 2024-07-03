package com.chenyue.experiment.designpattern.createpattern.factorymethod;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description 抽象工厂角色： 工厂作用：创建具体类，系统解耦
 */
public abstract class VehicleFactory {
    // 工厂方法，子类将实现此方法来创建具体的产品
    public abstract Vehicle createVehicle();

    public Vehicle orderVehicle(){
        Vehicle vehicle = createVehicle(); // 交给子类实现具体对象的创建
        vehicle.design(); // 调用抽象产品的功能
        vehicle.manufacture();
        return vehicle; // 返回具体的产品对象
    }
}
