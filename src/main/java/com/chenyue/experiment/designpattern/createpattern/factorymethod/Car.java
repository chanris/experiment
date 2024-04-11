package com.chenyue.experiment.designpattern.createpattern.factorymethod;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description 具体产品角色
 */
public class Car implements Vehicle{
    @Override
    public void design() {
        System.out.println("Designing a car");
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing a car");
    }
}
