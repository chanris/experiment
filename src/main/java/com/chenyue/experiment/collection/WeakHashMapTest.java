package com.chenyue.experiment.collection;

import java.util.WeakHashMap;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/11
 * @description 测试弱引用HashMap
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<String, Integer> map = new WeakHashMap<>();
        map.put("age", 18);
        map.put("serial", 2024);
        Integer age = map.get("age");
        System.out.println(age);
    }
}
