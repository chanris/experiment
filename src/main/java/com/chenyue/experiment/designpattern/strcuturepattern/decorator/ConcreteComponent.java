package com.chenyue.experiment.designpattern.strcuturepattern.decorator;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent Operation");
    }
}
