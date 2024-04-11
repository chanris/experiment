package com.chenyue.experiment.basic;

import java.io.IOException;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/20
 */
public class RuntimeTest {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
