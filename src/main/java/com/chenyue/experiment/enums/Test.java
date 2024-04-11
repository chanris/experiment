package com.chenyue.experiment.enums;

/**
 * @author chenyue7@foxmail.com
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(PizzaStatus.DELIVERED.name());
        PizzaStatus pizzaStatus = PizzaStatus.DELIVERED;

        if (pizzaStatus.isDelivered()){
            System.out.println("is delivered");
        }
    }


}
