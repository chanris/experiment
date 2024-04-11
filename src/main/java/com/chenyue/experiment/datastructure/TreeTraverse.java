package com.chenyue.experiment.datastructure;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/3
 */
public class TreeTraverse {
    public static void traverse(TNode tNode) {
        if (tNode == null) {
            return;
        }
        System.out.println(tNode.data);
        traverse(tNode.left);
        traverse(tNode.right);
    }

    public static void main(String[] args) {
        TNode t = TreeBuilder.builder()
                .left(1).reset().right(2)
                .reset().left().left(3)
                .reset().right().right(4).build(0);
        traverse(t);

        TNode t2 = TreeBuilder.createBTreeByDeep(10, new TNode(1));
        traverse(t2);
    }
}
