package com.chenyue.experiment.jvm.loader;

/**
 * @author chenyue7@foxmail.com
 * @date 2020/08/23
 *
 * role: 测试类的加载时机
 */
public class B implements Cloneable{
    static {
        System.out.println("load class io.cyt.loader.B.");
    }

    public void test() {
        System.out.println("Class B public method ....");
    }
}
