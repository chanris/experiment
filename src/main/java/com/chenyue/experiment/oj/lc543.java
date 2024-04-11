package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 6/3/2024
 * @description 求二叉树的直径
 * 树的深度定义： 叶子节点的深度为0， 叶子节点的父节点为1，向上遍历 深度依次加1。
 * 树的直径： 两个叶子节点深度之和。
 */
public class lc543 {
    static int ans = 0;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode node2 = new TreeNode(1);
        node.left = node2;
        int i = diameterOfBinaryTree(node);
        System.out.println(i);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public static int depth(TreeNode tr) {
        if (tr == null) {
            return 0;
        }
        int l = 0, r = 0;
        l = depth(tr.left);
        r = depth(tr.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
