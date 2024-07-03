package com.chenyue.experiment.basic.inner;

/**
 * @author chenyue7@foxmail.com
 */
public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.fun();

        Outer.Inner inner = new Outer().new Inner();
        inner.print();
    }
}
