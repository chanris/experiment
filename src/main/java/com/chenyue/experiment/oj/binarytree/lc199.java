package com.chenyue.experiment.oj.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 5/4/2024
 * @description
 */
public class lc199 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode2.right = treeNode4;
        treeNode1.right = treeNode3;
        lc199 lc199 = new lc199();
        List<Integer> integers = lc199.rightSideView(treeNode);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        if(root == null) return ans;
        q.addLast(root);
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode tmp = q.removeFirst();

                if(tmp.left != null) q.addLast(tmp.left);
                if(tmp.right != null) q.addLast(tmp.right);
                if(i == n - 1) ans.add(tmp.val);
            }
        }
        return ans;
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
