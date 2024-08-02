package com.chenyue.experiment.oj.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/1
 * @description 填充每个节点的下一个右侧节点指针 II
 * 进阶： 使用常量级额外空间，使用递归也可以。
 */
public class lc117 {
    public Node connect(Node root) {
        Deque<Node> q = new LinkedList<>();
        if(root == null) return root;
        q.addLast(root);
        while(!q.isEmpty()) {
            int len = q.size();
            Node pre = null;
            while(len-- > 0) {
                Node node = q.removeFirst();
                if(pre != null) {
                    pre.next = node;
                }
                pre = node;
                if(node.left != null) q.addLast(node.left);
                if(node.right != null) q.addLast(node.right);
            }
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
