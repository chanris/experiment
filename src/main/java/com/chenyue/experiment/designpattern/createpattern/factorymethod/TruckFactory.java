package com.chenyue.experiment.designpattern.createpattern.factorymethod;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class TruckFactory extends VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}
