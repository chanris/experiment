package com.chenyue.experiment.basic;

/**
 * @author chenyue7@foxmail.com
 * @date 24/7/10
 * @description
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
 * == 基本类型比较的是值， 引用类型比较的是引用也就是内存地址。
 * 字符串是特例：jvm底层有一个字符串池（String pool），存储每个字符串，所以不同字符串的内存地址是不同的。
 * 在jdk 8之前字符串池存在于永久代，永久代属于堆的一部分。在jdk 8字符串池被移到了元空间（Metaspace）, 元空间属于本地内存（native memory）
 * 元空间大小可以通过jvm参数调节，垃圾收集器（GC）会对元空间（Metaspace）进行垃圾收集。
 */
@SuppressWarnings("all")
public class EqualsTest {
    public static void main(String[] args) {
        String s  = new String("a");
        String s2 = new String("a");
        System.out.println("s == s2: " + (s == s2));
        System.out.println("s.intern() == s2.intern(): " + (s.intern() == s2.intern()));
        System.out.println("s.intern() == \"a\": " + (s.intern() == "a"));
        System.out.println("s.equals(s2): " + (s.equals(s2)));
        System.out.println(s.hashCode());
//        System.out.println((int)"a".charAt(0));
        System.out.println(s2.hashCode());

        String a = "Aa";
        String b = "BB";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a == b);
    }
}
