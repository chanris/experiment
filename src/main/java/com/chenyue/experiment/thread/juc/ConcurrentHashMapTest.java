package com.chenyue.experiment.thread.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenyue7@foxmail.com
 * @date 15/4/2024
 * @description
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 100);
        Integer val = map.get(1);
        System.out.println(val);
        Integer val2 = map.getOrDefault(2, 200);
        System.out.println(val2);
    }
}
