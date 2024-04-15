package com.chenyue.experiment.designpattern.strcuturepattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class FlyweightFactory {
    private Map<String, Flyweight> flyweightPool;

    public FlyweightFactory() {
        flyweightPool = new HashMap<>();
    }

    public Flyweight getFlyweight(String key) {
        if (!flyweightPool.containsKey(key)) {
            Flyweight flyweight = new ConcreteFlyweight(key);
            flyweightPool.put(key, flyweight);
        }
        return flyweightPool.get(key);
    }
}
