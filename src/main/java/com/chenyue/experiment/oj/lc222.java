package com.chenyue.experiment.oj;


/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/20
 */
public class lc222 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        int num = countNodes(node);
        System.out.println(num);
    }

    public static int countNodes(TreeNode root) {
        return dfs(root);
    }

    public static int dfs(TreeNode root) {
        if(root == null) return 0;
        int depthL = 0, depthR = 0;
        TreeNode curL = root, curR = root;
        while(curL != null) {
            depthL++;
            curL = curL.left;
        }
        while(curR != null) {
            depthR++;
            curR = curR.right;
        }
        if(depthL == depthR) {
            return (1 << depthL) - 1;
        }else {
            return 1 + dfs(root.left) + dfs(root.right);
        }
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {
        }
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
