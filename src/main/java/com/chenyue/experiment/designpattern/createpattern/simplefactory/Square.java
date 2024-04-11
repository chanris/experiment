package com.chenyue.experiment.designpattern.createpattern.simplefactory;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
