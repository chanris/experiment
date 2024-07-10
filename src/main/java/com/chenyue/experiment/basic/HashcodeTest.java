package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description
 */
public class HashcodeTest {
    public static void main(String[] args) {
        if ("Aa".hashCode() == "BB".hashCode()) {
            System.out.println("发生hash冲突");
        }
    }

    static class Test  {

    }
}
