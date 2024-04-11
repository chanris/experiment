package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 18/1/2024
 * @description 二分搜索 构造 平衡二叉树
 */
public class lc108 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        traversal(treeNode);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val;}
        TreeNode() {}
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        binaryCreate(root, nums, 0, nums.length - 1);
        return root;
    }

    // -10 0 2
    public static void binaryCreate(TreeNode node, int[] nums, int left, int right) {
        if(left <= right) {
           int mid = (left + right) / 2;
           node.val = nums[mid];
           if(left <= mid - 1) {
               TreeNode n = new TreeNode();
               node.left = n;
               binaryCreate(n, nums, left, mid - 1);
           }
           if(mid + 1 <= right) {
               TreeNode n = new TreeNode();
               node.right = n;
               binaryCreate(n, nums, mid + 1, right);
           }
        }
    }

    public static void traversal(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + " ");
            traversal(root.left);
            traversal(root.right);
        }
    }
}
