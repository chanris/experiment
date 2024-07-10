package com.chenyue.experiment.basic.jdk8.interfaces;

/**
 * @author chenyue7@foxmail.com
 * @date 24/4/2024
 * @description
 */
public class SomeImplement implements SomeInterface{

    @Override
    public void IDefaultMethod() {
        SomeInterface.super.IDefaultMethod();
    }

    public SomeImplement() {
        this.IDefaultMethod();
        SomeInterface.IStaticMethod();
    }

    public static void main(String[] args) {
        SomeImplement implement = new SomeImplement();
    }
}
