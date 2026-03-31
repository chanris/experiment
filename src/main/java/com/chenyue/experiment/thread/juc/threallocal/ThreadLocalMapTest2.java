package com.chenyue.experiment.thread.juc.threallocal;


import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/18
 * 反射获取当前线程的 ThreadLocalMap，并打印
 */
public class ThreadLocalMapTest2 {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 反射获取当前线程的 ThreadLocalMap
        ThreadLocalMapTest2 threadLocalMapTest2 = new ThreadLocalMapTest2();
        threadLocalMapTest2.threadLocal.set("hello");
        String s = threadLocalMapTest2.threadLocal.get();

        // 通过反射强行拿到 ThreadLocalMap
        Thread thread = Thread.currentThread();

        Field threadLocalsField = Thread.class.getDeclaredField("threadLocals");
        threadLocalsField.setAccessible(true);  // 强行开放访问权限

        Object threadLocalMap = threadLocalsField.get(thread);

        // 再拿到 Entry[]
        Field tableField = threadLocalMap.getClass().getDeclaredField("table");
        tableField.setAccessible(true);

        Object[] table = (Object[]) tableField.get(threadLocalMap);

        // 遍历所有 Entry
        for (Object entry : table) {
            if (entry == null) continue;

            // 拿到 Key（ThreadLocal 实例）
            Field keyField = WeakReference.class.getDeclaredField("referent");
            keyField.setAccessible(true);
            Object key = keyField.get(entry);

            // 拿到 Value
            Field valueField = entry.getClass().getDeclaredField("value");
            valueField.setAccessible(true);
            Object value = valueField.get(entry);

            System.out.println("key: " + key + ", value: " + value);
        }

    }


}
