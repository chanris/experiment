package com.chenyue.experiment.basic.jdk8;

/**
 * @author chenyue7@foxmail.com
 * @date 2022/1/17 15:58
 */
public interface Stuff {
    public abstract void say();
    public static final String NAME = "chenyue"; // 常量全大写 ‘_’分割

    default void chenyue() {
        System.out.println("陈越");
    }
}

