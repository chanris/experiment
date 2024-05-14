package com.chenyue.experiment.basic.enums;

/**
 * @author chenyue7@foxmail.com
 *
 * 枚举实现单例
 */
public enum  PizzaDeliverySystemConfiguration {
    INSTANCE;

    // constructor
    PizzaDeliverySystemConfiguration(){
        // initialization configuration which involves
        // overriding defaults like delivery strategy
    }

    private static PizzaDeliverySystemConfiguration getInstance(){
        return INSTANCE;
    }

}
