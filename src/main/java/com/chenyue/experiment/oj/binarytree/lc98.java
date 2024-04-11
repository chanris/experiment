package com.chenyue.experiment.oj.binarytree;

/**
 * @author chenyue7@foxmail.com
 * @date 27/3/2024
 * @description [5, 4, 3333]
 */
public class lc98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode t2 = new TreeNode();
        TreeNode t3 = new TreeNode();
        TreeNode t4  = new TreeNode();
        TreeNode t5 = new TreeNode();
        TreeNode t6 = new TreeNode();

    }

    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return flag;
    }

    public void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        if(node.left != null && node.val <= node.left.val) {
            flag = false;
        }
        if(node.right != null && node.val >= node.right.val) {
            flag = false;
        }
        inOrder(node.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
