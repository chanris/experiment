package com.chenyue.experiment.datastructure;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/3
 */
public class TreeBuilder {
    private TNode root = new TNode();
    private TNode point = root;

    public static TreeBuilder builder() {
        return new TreeBuilder();
    }

    public TNode build() {
        return root;
    }

    public  TNode build(Object rootData) {
        root.data = rootData;
        return root;
    }

    public TreeBuilder left(Object data) {
        TNode left = new TNode(data);
        point.left = left;
        point = left;
        return this;
    }

    /*移动指针*/
    public TreeBuilder left() {
        if (point.left != null) {
            point = point.left;
        }
        return this;
    }

    public TreeBuilder right(Object data) {
        TNode right = new TNode(data);
        point.right = right;
        point = right;
        return this;
    }

    public TreeBuilder right() {
        if (point.right != null) {
            point = point.right;
        }
        return this;
    }

    /*重新指向root*/
    public TreeBuilder reset() {
        point = root;
        return this;
    }

    public static TNode createBTreeByDeep(Integer deep, TNode node) {
        if (deep == 0) {
            return null;
        }
        node.left = new TNode();
        node.right = new TNode();
        createBTreeByDeep(deep-1, node.left);
        createBTreeByDeep(deep-1, node.right);
        return node;
    }
}
