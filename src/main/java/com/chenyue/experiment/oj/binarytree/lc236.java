package com.chenyue.experiment.oj.binarytree;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 6/4/2024
 * @description
 */
public class lc236 {

    public static void main(String[] args) {
        lc236 lc236 = new lc236();
        TreeNode root = new TreeNode(3);
        TreeNode sec1 = new TreeNode(5);
        TreeNode sec2 = new TreeNode(1);
        TreeNode thr1 = new TreeNode(6);
        TreeNode thr2 = new TreeNode(2);
        TreeNode thr3 = new TreeNode(0);
        TreeNode thr4 = new TreeNode(8);
        TreeNode f1 = new TreeNode(7);
        TreeNode f2 = new TreeNode(4);
        root.left = sec1;root.right = sec2;
        sec1.left = thr1; sec1.right = thr2; sec2.left = thr3; sec2.right = thr4;
        thr2.left = f1; thr2.right = f2;

        TreeNode treeNode = lc236.lowestCommonAncestor(root, thr1, f2);
        System.out.println(treeNode.val);
    }
    HashMap<TreeNode, Status> map = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);
        int depth = 1;
        while(!que.isEmpty()) {
            int n = que.size();
            for(int i = 0; i < n; i++) {
                TreeNode pop = que.removeFirst();
                map.put(pop, new Status(null, depth));
                if(pop.left != null) {
                    que.addLast(pop.left);
                }
                if(pop.right != null) {
                    que.addLast(pop.right);
                }
            }
            depth++;
        }
        dfs(root, null);
        int pDepth = map.get(p).depth;
        int qDepth = map.get(q).depth;
        while(pDepth > qDepth) {
            p = map.get(p).parent;
            pDepth--;
        }
        while (pDepth < qDepth) {
            q = map.get(q).parent;
            qDepth--;
        }
        while(p.val != q.val) {
            p = map.get(p).parent;
            q = map.get(q).parent;


        }
        return q;
    }

    public void dfs(TreeNode node, TreeNode pre) {
        if(node == null) {
            return;
        }
        map.get(node).parent = pre;
        dfs(node.left, node);
        dfs(node.right, node);
    }



    public static class Status {
        public TreeNode parent;
        public int depth;

        public Status(TreeNode parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
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
