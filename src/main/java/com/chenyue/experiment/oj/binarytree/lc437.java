package com.chenyue.experiment.oj.binarytree;

/**
 * @author chenyue7@foxmail.com
 * @date 6/4/2024
 * @description
 */
public class lc437 {
    public static void main(String[] args) {
        lc437 lc437 = new lc437();
        TreeNode root = new TreeNode(10);
        TreeNode sec1 = new TreeNode(5);
        TreeNode sec2 = new TreeNode(-3);
        TreeNode thr1 = new TreeNode(3);
        TreeNode thr2 = new TreeNode(2);
        TreeNode thr3 = new TreeNode(11);
        TreeNode f1 = new TreeNode(3);
        TreeNode f2 = new TreeNode(-2);
        TreeNode f3 = new TreeNode(1);
        root.left = sec1; root.right = sec2;
        sec1.left = thr1; sec1.right = thr2;
        sec2.right = thr3;
        thr1.left = f1;
        thr1.right = f2;
        thr2.right = f3;
        lc437.pathSum(root, 8);
        System.out.println(lc437.ans);
    }

    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ans;
    }

    public void dfs(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        ans += search(node, val);
        dfs(node.left, val);
        dfs(node.right, val);
    }

    public int search(TreeNode root, long targetSum) {
//        if(val - root.val == 0) {
//            return  1;
//        }
//        int leftF = 0;
//        int rightF = 0;
//        if(root.left != null) {
//            leftF  = search(root.left, val - root.val);
//        }
//        if(root.right != null) {
//            rightF   = search(root.right, val - root.val);
//        }
//        return leftF + rightF;
        int ret = 0; // 记录当符合条件的路径 个数
        if(root == null) { // 如果当前节点为为空 则无符号条件的 路径，返回0
            return 0;
        }
        int val = root.val;
        if(val == targetSum) {// 如何当前节点 等于 剩余的 target之，则说明，开始节点到该节点之间的路径为合法路径 ret++
            return ret++;
        }
        ret += search(root.left, targetSum - val); // 继续找当前节点之后的子节点，如果有符合的路径则 ++
        ret += search(root.right, targetSum - val);
        return  ret;
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
