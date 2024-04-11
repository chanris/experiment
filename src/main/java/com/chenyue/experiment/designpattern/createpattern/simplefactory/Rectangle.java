package com.chenyue.experiment.designpattern.createpattern.simplefactory;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
