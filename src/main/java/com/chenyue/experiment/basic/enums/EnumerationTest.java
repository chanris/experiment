package com.chenyue.experiment.basic.enums;

/**
 * @author chenyue7@foxmail.com
 */
public class EnumerationTest {
    public static void main(String[] args) {
        PizzaStatus pizzaStatus = PizzaStatus.DELIVERED;
        System.out.println(pizzaStatus.name());
        System.out.println(pizzaStatus.ordinal());

        PizzaStatus ordered = PizzaStatus.ORDERED;
        System.out.println(ordered.name());
        System.out.println(ordered.ordinal());
    }
}
