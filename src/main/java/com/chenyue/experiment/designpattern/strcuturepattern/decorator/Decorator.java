package com.chenyue.experiment.designpattern.strcuturepattern.decorator;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public abstract class Decorator implements Component {
    protected Component decoratedComponent;

    public Decorator(Component decoratedComponent) {
        this.decoratedComponent = decoratedComponent;
    }

    public void operation() {
        decoratedComponent.operation();
    }

}
