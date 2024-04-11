package com.chenyue.experiment.jdk8;

/**
 * @author chenyue
 * @date 2022/1/17 16:00
 */
public interface MyObject extends Stuff {
    @Override
    default void chenyue() {
        System.out.println("陈越2");
    }
}
