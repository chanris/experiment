package com.chenyue.experiment.datastructure.binarytree;

import java.sql.SQLOutput;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/1
 * @description 二叉树的遍历(前、中、后序、层次，递归版和迭代版)
 */
public class TreeTraversalTest {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(35);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(40);
        TreeNode t5 = new TreeNode(25);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(-5);
        TreeNode t8 = new TreeNode(30);
        TreeNode t9 = new TreeNode(15);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t5.right = t9;
//        levelTraversal(t1);
        inorder(t1);
    }


    /**
     * 层次遍历
     */
    public static void levelTraversal(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while(!q.isEmpty()) {
            int len = q.size();
            while(len-- > 0) {
                TreeNode node = q.removeFirst();
                System.out.print(node.val + " ");
                if(node.left != null) q.addLast(node.left);
                if(node.right != null) q.addLast(node.right);
            }
            System.out.println();
        }
    }

    /**
     * 层次遍历，非递归
     */
    public static void levelTraversal2() {

    }



    /**
     * 非递归前序遍历
     */
    public static void preorder(TreeNode root) {
        Deque<TreeNode> st = new LinkedList<>();
        st.addFirst(root);
        while (!st.isEmpty()) {
            TreeNode node = st.removeFirst();
            System.out.print(node.val + " ");
            if (node.left != null) {
                st.addFirst(node.left);
            }
            if (node.right != null) {
                st.addFirst(node.right);
            }
        }
    }

    /**
     * 中序遍历
     */
    public static void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.val + " 步骤1");
        System.out.println(root.val + " 步骤2");
        System.out.println(root.val + " 步骤3");
        inorder(root.right);
    }

    /**
     * 非递归中序遍历
     */
    public static void inorder2(TreeNode root) {
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }


    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
