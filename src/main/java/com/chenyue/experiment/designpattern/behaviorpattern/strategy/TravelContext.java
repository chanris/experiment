package com.chenyue.experiment.designpattern.behaviorpattern.strategy;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/2
 * @description
 */
public class TravelContext {

    private Strategy strategy;

    public TravelContext(Strategy strategy) {
        this.strategy = strategy;
    }

    Strategy selectTravel() {
        return this.strategy;
    }

}
