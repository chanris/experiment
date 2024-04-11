package com.chenyue.experiment.oj;

import java.util.HashMap;

/**
 * @author chenyue7@foxmail.com
 * @date 5/4/2024
 * @description
 */
public class lc105 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        rightLeft.right = rightRight;
        lc105 lc105 = new lc105();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = lc105.buildTree(preorder, inorder);
    }


    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = recursion(preorder, inorder, 0, 0, preorder.length - 1);
        return root;
    }

    public TreeNode recursion(int[] preorder, int[] inorder, int deep, int left, int right) {
        if (left >= right) {
            return new TreeNode(preorder[right]);
        }
        TreeNode root = new TreeNode(preorder[deep]);
        int mid = map.get(preorder[deep]);
        root.left = recursion(preorder, inorder, deep + 1, left, mid - 1);
        root.right = recursion(preorder, inorder, deep + 2, mid + 1, right);
        return root;
    }

    public static class TreeNode {
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
