package com.chenyue.experiment.oj.binarytree;

import java.util.*;

/**
 * @author chenyue7@foxmail.com
 * @date 14/3/2024
 * @description
 *               3
 *              / \
 *             /    \
 *            9      \
 *                   20
 *                  / \
 *                 /   \
 *                15     7
 *
 */
public class lc102 {
    public static void main(String[] args) {
        lc102 lc102 = new lc102();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>> lists = lc102.levelOrder(root);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Deque<TreeNode> que = new LinkedList<TreeNode>();
        que.addFirst(root); // 插入队尾

        while (!que.isEmpty()) {
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while (len > 0) {
                TreeNode tmpNode = que.removeLast(); // 删除队列第一个
                itemList.add(tmpNode.val);
                if (tmpNode.left != null) {
                    que.addFirst(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.addFirst(tmpNode.right);
                }
                len--;
            }
            ans.add(itemList);
        }
        return ans;
    }
}

class TreeNode {
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
