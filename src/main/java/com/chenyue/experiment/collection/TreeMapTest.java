package com.chenyue.experiment.collection;

import java.util.TreeMap;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/16
 * @description TreeMap底层使用红黑树作为数据结构，红黑树是一个自平衡二叉搜索树，
 * 查找效率为logn,效率较好，与MySQL的底层数据结构B+Tree相比，红黑树更高更瘦，B+Tree数更埃更胖，
 * B+Tree的数据都落在叶子节点，红黑树的数据分布在每个节点中。红黑树通过维护红黑树的特性：
 *
 * 1.null节点为黑色
 * 2.每个外部节点到根结点的路径上的黑色节点一致。
 * 3.没有两个连续的红色节点
 * 4.根结点是黑色
 * 5.结点不是红色就是黑色
 *
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println(map);
    }
}
