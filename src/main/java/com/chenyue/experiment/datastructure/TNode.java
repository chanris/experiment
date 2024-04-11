package com.chenyue.experiment.datastructure;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/3
 */
public class TNode {
    public Object data;
    public TNode left;
    public TNode right;

    public TNode() {
    }

    public TNode(Object data) {
        this.data = data;
    }

    public TNode(Object data, TNode left, TNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
