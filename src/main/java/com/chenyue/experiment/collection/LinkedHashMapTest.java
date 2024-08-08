package com.chenyue.experiment.collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/3
 * @description 测试LinkedHashMap的基本使用
 * LinkedHashMap底层使用一个双向链表来记录Entry的插入顺序 或 访问顺序
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        // 默认，按照插入顺序排序
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        // 按照访问顺序排序
        LinkedHashMap<String, Integer> map2 = new LinkedHashMap<>(16, 0.75f, true);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map2.put("one", 1);
        map2.put("two", 2);
        map2.put("three", 3);
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        if (iterator.hasNext()) {
            Map.Entry<String, Integer> first = iterator.next();
            System.out.println("第一个元素 key: " + first.getKey() + " ,value: " + first.getValue());
        }

        map2.get("one");
        map2.get("three");
        Iterator<Map.Entry<String, Integer>> iterator2 = map2.entrySet().iterator();
        //map2.get("two");
        while (iterator2.hasNext()) {
            Map.Entry<String, Integer> entry = iterator2.next();
            System.out.println("key: " + entry.getKey() + " ,value: " + entry.getValue());
        }
    }
}
