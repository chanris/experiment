package com.chenyue.experiment.designpattern;

/**
 * @author chenyue7@foxmail.com
 *
 *
 * 抽象工厂:工厂方法模式中只考虑一类产品的生产,而抽象工厂考虑多种类别的产品的生产
 */
public class FarmTest {
    public static void main(String[] args) {

    }

}

interface Animal{
    void show();
}

class Horse implements Animal{
    @Override
    public void show() {
        System.out.println("马...");
    }
}


interface Plant{
    void show();
}

class Fruitage implements Plant{
    @Override
    public void show() {
        System.out.println("水果...");
    }
}

class Vegetables implements Plant{
    @Override
    public void show() {

    }
}