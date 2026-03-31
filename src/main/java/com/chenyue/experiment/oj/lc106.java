package com.chenyue.experiment.oj;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyue7@foxmail.com
 * @date 2026/3/19
 */
public class lc106 {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inL, int inR, int postL, int postR) {
        if(postL > postR) return null;
        TreeNode root = new TreeNode();
        root.val = postorder[postR];
        int idx = map.get(root.val);
        int leftLen = idx - inL;
        int rightLen = inR - idx;
        root.left = build(inorder, postorder, inL, idx - 1, postL, postL + leftLen - 1);
        root.right = build(inorder, postorder, idx + 1, inR, postL + leftLen, postR - 1);
        return root;
    }
    public static void main(String[] args) {
        lc106 lc = new lc106();
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        lc.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
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
