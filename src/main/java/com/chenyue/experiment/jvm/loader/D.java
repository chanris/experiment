package com.chenyue.experiment.jvm.loader;

/**
 * @author chenyue7@foxmail.com
 * @date 2020/08/23
 *
 * role: 测试类的加载时机
 */
@EnableConfiguration
public class D {

    static {
        System.out.println("load class D.");
    }

    public static double PI = 3.14;
}
