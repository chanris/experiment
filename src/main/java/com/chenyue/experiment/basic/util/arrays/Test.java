package com.chenyue.experiment.basic.util.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ArrayList<Integer> collect = new ArrayList<>(list);
        Iterator<Integer> iterator = collect.iterator();// new 一个迭代器对象操作ArrayList结合
        for (;iterator.hasNext();) {
            Integer next = iterator.next();
            if (next == 4) {
                iterator.remove();
            }
        }
        collect.forEach(System.out::println);
    }
}
