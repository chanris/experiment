package com.chenyue.experiment.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/13
 * @description
 *
 * HashSet 无序，元素唯一，支持交集，差集
 * 底层数据结构，使用的是HashMap<E, Object>
 * 像 contains, add, remove，基本上就是对HashMap的操作
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("banana");
        set.add("strawberry");
        set.add("apple"); // map.put
        if (set.contains("lemon")) { // map.containsKey()
            System.out.println("set has an element: [lemon]");
        }
        if (set.isEmpty()) {
            System.out.println("set is empty.");
        }
        boolean b = set.remove("apple");
        Iterator<String> iterator = set.iterator();
        for (;iterator.hasNext();) {
            System.out.println(iterator.next());
        }

    }
}
