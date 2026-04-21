package com.chenyue.experiment.oj.binarytree;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chenyue7@qq.com
 * @date 2026/4/20
 */
public class lc437_2 {
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;

    public static void main(String[] args) {
        lc437_2 lc437 = new lc437_2();
        TreeNode root = new TreeNode(10);
        TreeNode sec1 = new TreeNode(5);
        TreeNode sec2 = new TreeNode(-3);
        TreeNode thr1 = new TreeNode(3);
        TreeNode thr2 = new TreeNode(2);
        TreeNode thr3 = new TreeNode(11);
        TreeNode f1 = new TreeNode(3);
        TreeNode f2 = new TreeNode(-2);
        TreeNode f3 = new TreeNode(1);
        root.left = sec1;
        root.right = sec2;
        sec1.left = thr1;
        sec1.right = thr2;
        sec2.right = thr3;
        thr1.left = f1;
        thr1.right = f2;
        thr2.right = f3;
        lc437.pathSum(root, 8);
        System.out.println(lc437.ans);
    }
    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和 + hash表
        dfs(root, 0, targetSum);
        return ans;
    }

    public void dfs(TreeNode root, int prefixSum, int target) {
        if(root == null) return;
        prefixSum += root.val;
        System.out.println(prefixSum);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        if(map.containsKey(prefixSum - target) && map.get(prefixSum - target) > 0) {
            ans += map.get(prefixSum - target);
        }
        dfs(root.left, prefixSum, target);
        dfs(root.right, prefixSum, target);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) - 1);
    }

    private static class TreeNode {
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
