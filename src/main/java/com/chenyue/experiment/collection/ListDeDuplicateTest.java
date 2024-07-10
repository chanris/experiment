package com.chenyue.experiment.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/10
 * @description 测试列表去重方法
 */
@SuppressWarnings("all")
public class ListDeDuplicateTest {
    private static List<Integer> origin = new ArrayList<>(Arrays.asList(70, 70, 40, 30, 25, 26, 80, 81, 25));
    public static void main(String[] args) {
        m5();
    }

    /**
     * 循环坐标去重，类似双指针，按照值找到下标
     * 如果下标不同，表示有重复需要删除
     */
    private static void m5() {
        List<Integer> srcList = new ArrayList<>(origin);
        List<Integer> newList = new ArrayList<>(origin);
        for (Integer element : srcList) {
            if (newList.indexOf(element) != newList.lastIndexOf(element)) {
                newList.remove(element);
            }
        }
        newList.forEach((element)->{
            System.out.print(element + " ");
        });
    }


    // Stream流式计算
    private static void m4() {
        List<Integer> srcList = new ArrayList<>(origin);
        List<Integer> newList = srcList.stream().distinct().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).collect(Collectors.toList());
        newList.forEach(System.out::println);
    }

    // LinkedHashSet(Collection) 构造器天然去重，并且构造完成后的元素顺序和原集合一样。
    private static void m3() {
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(origin);
        hashSet.forEach(System.out::println);
    }

    // HashSet(Collection) 构造器天然去重
    private static void m2() {
        HashSet<Integer> hashSet = new HashSet<>(origin);
        hashSet.forEach(System.out::println);
    }

    // for循环遍历去重
    private static void m1() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < origin.size(); i++) {
            if (!result.contains(origin.get(i))) {
                result.add(origin.get(i));
            }
        }
        result.forEach(System.out::println);
    }
}
