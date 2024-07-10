package com.chenyue.experiment.basic.jdk8;

import java.util.ArrayList;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description
 * jdk 17 新特性： var 关键字
 */
public class KeyWordTest {
    public static void main(String[] args) {
        var list = new ArrayList<>(); // 右值推断类型
    }
}
