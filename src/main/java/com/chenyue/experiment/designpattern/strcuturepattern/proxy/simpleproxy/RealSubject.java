package com.chenyue.experiment.designpattern.strcuturepattern.proxy.simpleproxy;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("RealSubject: Handling request.");
    }
}
