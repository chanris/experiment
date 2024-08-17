package com.chenyue.experiment.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/10
 * @description
 * CopyAndWriteArrayList: 读 无锁，写有锁。
 * 写操作时，会复制底层数组，然后在副本上添加新元素，让底层数组的引用指向这个新副本，完成写操作。
 * 适用场景：读多写少。
 */
public class CopyAndWriteArrayListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<>(list);
        Collection collection = Collections.synchronizedCollection(list);
    }
}
