package com.chenyue.experiment.datastructure;

import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 2022/2/9 14:39
 *
 * 二叉树的层次遍历使用BFS思想，需要用队列
 * 1. 对于不为空的结点，先把该节点加入到队列中
 * 2. 从队中拿出节点，如果该节点的左右节点不为空，就分别把左右节点加入队列中
 * 3. 重复以上操作直到队列为空
 */
public class BFS {
    public static void LayerTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode currentNode;
        while(!list.isEmpty()) {
            currentNode = list.poll();
            System.out.println(currentNode.value);
            if (currentNode.left != null) {
                list.add(currentNode.left);
            }
            if (currentNode.right != null) {
                list.add(currentNode.right);
            }
        }
    }

}
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) { this.value = value; }
}
