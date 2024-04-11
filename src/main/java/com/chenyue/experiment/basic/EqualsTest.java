package com.chenyue.experiment.basic;

import java.util.Objects;

/**
 * @author chenyue7@foxmail.com
 */

/**
 * hashcode() 方法详解
 * hashcode()方法给对象返回一个hash code值。这个方法被用于hash table, 例如HashMap
 * 特点:
 * 1. 在java应用的执行期间，如果一个对象提供给equals做比较的信息没有被修改的话，该对象多次调用
 * hashCode()方法，该方法必须始终返回同一个integer
 * 2. 如果两个对象根据equals(Object)方法是相等的，那么调用两者各自的hashCode()方法必须产生同一个integer
 * 3. 并不要求根据equals(java.lang.Object)方法不相等的两个对象，调用二者各自的hashCode()方法必须产生不同的integer结果。
 * 然而，程序员应该意识到对于不同的对象产生不同的integer结果，有可能会提高hash table的性能。
 *
 * 1. 相等(相同)的对象必须具有相等的hash码
 * 2. 如果两个对象的hashCode相同，它们不一定相同
 *
 *
 */
public class EqualsTest {
    public static void main(String[] args) {
        String s  = new String("a");
        String s2 = new String("a");
        System.out.println(s == s2);
        System.out.println(s.equals(s2));
        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());
    }
}
