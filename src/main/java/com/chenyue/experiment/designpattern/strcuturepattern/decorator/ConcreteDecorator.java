package com.chenyue.experiment.designpattern.strcuturepattern.decorator;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component decoratedComponent) {
        super(decoratedComponent);
    }

    @Override
    public void operation() {
        super.operation();
        addedFunctionality();
    }

    private void addedFunctionality() {
        System.out.println("ConcreteDecorator Added Functionality");
    }
}
