package com.chenyue.experiment.datastructure.binarytree;

import java.util.List;
import java.util.Scanner;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/11
 * @description 测试二叉平衡树（binary search tree）
 */
public class BSTTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(50);
        /*var i = 10;
        while(i-- > 0) {
            System.out.print("输入新节点值:");
            root.insert(sc.nextInt());
        }*/
        List.of(25, 75, 10, 35, 65, 100, 5, 30, 70).forEach(root::insert);
        inOrderTraversal(root);
        System.out.print("\n输入想要查找的数：");
        int num = sc.nextInt();
        if(search2(root, num) != null) {
            System.out.println("找到了 num: " + num);
        } else {
            System.out.println("没有找到");
        }
        System.out.print("输入想要删除的数：");
        int remove = sc.nextInt();
        TreeNode treeNode = removeElement(root, remove);
        inOrderTraversal(treeNode);
    }

    // 左 根 右
    static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    /**
     * 二分查找（递归版）
     */
    static Integer search(TreeNode root, Integer target) {
        if(root == null) {
            return null;
        }
        if (target > root.val) {
            return search(root.right, target);
        }else if(target < root.val){
            return search(root.left, target);
        }else {
            return root.val;
        }
    }

    /**
     * 二分查找（迭代版）
     */
    static Integer search2(TreeNode root, Integer target) {
        TreeNode cur = root;
        while (cur != null) {
            if (target > cur.val) {
                cur = cur.right;
            }else if(target < cur.val) {
                cur = cur.left;
            }else {
                return cur.val;
            }
        }
        return null;
    }

    /**
     * 删除二叉搜索树中的元素
     */
    static TreeNode removeElement(TreeNode root, Integer target) {
        if (root == null) return null;
        if (target > root.val) {
            root.right = removeElement(root.right, target);
            return root;
        }else if(target < root.val) {
            root.left = removeElement(root.left, target);
            return root;
        }else  {
            //找到了目标位置 三种情况
            //1. 目标节点没有左、右子节点，则把目标位置置为null
            if (root.left == null && root.right == null) {
                return null; // 目标位置置为null
            }
            //2. 目标节点只有一个左或右节点,则子节点代替目标节点
            else if((root.left != null && root.right == null)) {
                return  root.left;
            }
            else if(root.right != null && root.left == null) {
                return root.right;
            }
            //3. 目标节点左右节点都不为null,
            else {
                TreeNode cur = root.left;
                while(cur.right != null) {
                    cur = cur.right;
                }
                cur.right = root.right;
                return root.left;
            }
        }
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        void insert(int data) {
            if (data > val) {
                if(this.right == null) {
                    this.right = new TreeNode(data);
                }else {
                    this.right.insert(data);
                }
            }else {
                if (this.left == null) {
                    this.left = new TreeNode(data);
                }else {
                    this.left.insert(data);
                }
            }
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
