package com.chenyue.experiment.designpattern.behaviorpattern.strategy;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/2
 * @description
 */
public class Test {
    public static void main(String[] args) {
        TravelContext context = new TravelContext(new Car());
        Strategy strategy = context.selectTravel();

    }
}
