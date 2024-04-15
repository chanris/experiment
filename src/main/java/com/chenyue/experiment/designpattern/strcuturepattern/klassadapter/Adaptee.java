package com.chenyue.experiment.designpattern.strcuturepattern.klassadapter;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description 被适配者类，有自己的方法实现
 */
public class Adaptee {
    public void spcificMethod() {
        System.out.println("Called specificMethod of Adaptee");
    }
}
