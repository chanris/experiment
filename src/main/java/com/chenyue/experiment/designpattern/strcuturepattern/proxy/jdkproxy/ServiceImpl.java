package com.chenyue.experiment.designpattern.strcuturepattern.proxy.jdkproxy;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class ServiceImpl implements IService{
    @Override
    public void serve() {
        System.out.println("Service Implementation is serving.");
    }
}
