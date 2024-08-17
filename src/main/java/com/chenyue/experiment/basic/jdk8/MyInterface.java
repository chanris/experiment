package com.chenyue.experiment.basic.jdk8;

import com.chenyue.experiment.basic.jdk8.interfaces.Stuff;

/**
 * @author chenyue
 * @date 2022/1/17 16:00
 */
public interface MyInterface extends Stuff {
    public static final int xx = 100;

    public abstract  void ff();
    @Override
    default void chenyue() {
        System.out.println("陈越2");
    }
}
