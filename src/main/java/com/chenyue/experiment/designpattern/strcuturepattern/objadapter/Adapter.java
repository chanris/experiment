package com.chenyue.experiment.designpattern.strcuturepattern.objadapter;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class Adapter implements Target{
    private Adaptee adaptee;
    // 通过构造方法或者setter方法传入被适配者对象的引用

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
