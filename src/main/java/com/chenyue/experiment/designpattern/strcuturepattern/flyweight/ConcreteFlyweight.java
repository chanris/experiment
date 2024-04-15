package com.chenyue.experiment.designpattern.strcuturepattern.flyweight;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 *
 * ConcreteFlyweight 对象的状态被分为内在和外在状态。内在状态是存在于对象内部、不会随环境而改变的状态，即 intrinsicState。
 * 外在状态则是随环境变化而变化、不能共享的状态，即 extrinsicState，通常由客户端代码提供。
 */
public class ConcreteFlyweight implements Flyweight{
    private String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void doOperation(String extrinsicState) {
        System.out.println("Intrinsic State = " + intrinsicState + ", Extrinsic State = " + extrinsicState);
    }
}
