package com.chenyue.experiment.other.debug;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description 测试 intellij idea 的调试功能
 */
public class DebugDemo {

    private static ThreadLocal<Object> threadLocal;
    private static int x = 9;
    public static void main(String[] args) {
//        myStreamChain();
//        testArrayListGrow();
        testMethodBreakpoint();
    }

    // demo for java stream debugger
    private static void myStreamChain() {
        // 流操作 toList返回的是不可变列表
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6).filter(f -> f > 3).map(m -> m * 2).collect(Collectors.toList());
        System.out.println("next statement executed.");
    }
    private static void testArrayListGrow() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            list.add(i);
        }
    }

    private static void testMethodBreakpoint() {
        threadLocal = new ThreadLocal<>();
        threadLocal.set(new Object());
        Object o = threadLocal.get();
    }
}
