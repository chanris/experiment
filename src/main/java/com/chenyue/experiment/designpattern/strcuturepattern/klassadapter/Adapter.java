package com.chenyue.experiment.designpattern.strcuturepattern.klassadapter;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 * 适配器继承了被适配者的方法，实现了客户期望的方法
 *
 */
public class Adapter extends Adaptee implements TargetInterface{
    @Override
    public void targetMethod() {
        /**
         * 基本上的思路
         * 需要一个需要适配的服务将这个服务返回给适配器中客户期望的方法
         * 在这个方法中我们将这个服务的结果转成 客户期望的结果，并返回。
         * 此后，客户只需要调用适配器，用户期望的方法，而不用关系原来的服务的结果
         */
        spcificMethod();
    }
}
