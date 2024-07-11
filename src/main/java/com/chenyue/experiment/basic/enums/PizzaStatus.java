package com.chenyue.experiment.basic.enums;

/**
 * @author chenyue7@foxmail.com
 */
public enum PizzaStatus {
    ORDERED(1,"已下单"),
    READY(2,"准备送单"),
    DELIVERED(3, "已送达");

    private final Integer val;
    private final String msg;

    PizzaStatus(Integer val, String msg){
        this.val = val;
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }

    public Integer getVal(){
        return this.val;
    }

    public boolean isDelivered(){
        return this == PizzaStatus.DELIVERED;
    }

    public boolean isOrder(){
        return this == PizzaStatus.ORDERED;
    }

    public boolean isReady(){
        return this == PizzaStatus.READY;
    }
}
