package com.chenyue.experiment.oj.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/1
 * @description 对称二叉树
 */
public class lc101 {

    // *** 递归做法 ***

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // *** 迭代做法 ***

    public boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(u);
        q.addLast(v);
        while(!q.isEmpty()) {
            u = q.removeFirst();
            v = q.removeFirst();
            if(u == null && v == null) {
                continue;
            }
            if(u == null || v == null || (u.val != v.val)) {
                return false;
            }
            q.addLast(u.left);
            q.addLast(v.right);

            q.addLast(u.right);
            q.addLast(v.left);
        }
        return true;
    }

    private static class TreeNode {
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
