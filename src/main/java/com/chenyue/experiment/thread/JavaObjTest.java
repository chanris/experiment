package com.chenyue.experiment.thread;


import org.openjdk.jol.info.ClassLayout;

/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/19
 * 测试当前jvm的 object header 布局
 */
public class JavaObjTest {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
    }
}
