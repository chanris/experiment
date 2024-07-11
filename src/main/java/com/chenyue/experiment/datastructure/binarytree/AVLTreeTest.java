package com.chenyue.experiment.datastructure.binarytree;

import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/12
 * @description AVL树（平衡二叉搜索树）
 */
@SuppressWarnings("all")
public class AVLTreeTest {

    public static void main(String[] args) {
        AVLNode root = null;
        for (Integer i : List.of(10, 20, 30, 40, 50, 60, 70)) {
            root = insertNode(root, i);
        }
//        find(root, 70);
//        prevOrderTraversal(root);
        inOrderTraversal(root);

        AVLNode node = deleteNode(root, 30);
        System.out.println();
        inOrderTraversal(node);
    }

    /**
     * A.V.L Tree Node
     */
    private static class AVLNode {
        AVLNode left;
        AVLNode right;
        int height; //树高，规定叶子节点树高为0
        int val;
        public AVLNode(int val) {
            this.val = val;
        }
    }

    private static int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // 定义左旋
    // 节点x 左右子树高度差为 -2（左子树-右子树），并且是RR型，那么就应该左旋
    // 左旋过程：节点x的右节点作为 新根结点（newRoot）, 旧根结点x,会作为newRoot的左子节点
    // 如果，新根结点，原本有左子树，原来的左子树会作为旧根结点x的右子树
    private static AVLNode leftRotate(AVLNode node) {
        // 旋转完成
        AVLNode root = node.right;
        node.right = root.left;
        root.left = node;

        // 更新树高
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    // 定义右旋
    // 节点y 左右子树高度差为 2（左子树-右子树），并且是LL型，那么就应该右旋
    // 右旋过程：节点y的左节点作为 新根结点（newRoot）,旧根结点y作为newRoot的右子节点
    // 如果，新根结点，原本有右子树，那么，原来的左子树会作为旧根结点x的左子节点
    private static AVLNode rightRotate(AVLNode node) {
        AVLNode root = node.left;
        node.left = root.right;
        root.right = node;
        //更新树高
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    /**
     * 插入AVL节点
     */
    private static AVLNode insertNode(AVLNode node, int newVal) {
        if (node == null) {
            return new AVLNode(newVal);
        }
        if (newVal > node.val) {
            node.right = insertNode(node.right, newVal);
        }else if (newVal < node.val) {
            node.left = insertNode(node.left, newVal);
        }

        //更新树高
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        // LL失衡
        if (balance > 1 && getBalance(node.left) > 0) {
           return rightRotate(node);
        }
        // LR失衡
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left =  leftRotate(node.left);
            return rightRotate(node);
        }
        // RR失衡
        if (balance < -1 && getBalance(node.right) < 0) {
            return leftRotate(node);
        }
        // RL失衡
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = leftRotate(node.right);
            return rightRotate(node);
        }
        return node;
    }

    private static AVLNode deleteNode(AVLNode node, int val) {
        if (node == null) {
            return node;
        }
        if (val < node.val) {
            node.left = deleteNode(node.left, val);
        }else if (val > node.val) {
            node.right = deleteNode(node.right, val);
        }else {
            // 情况一 删除的节点是叶子节点
            if (node.left == null && node.right == null) {
                return null;
            }else if (node.left == null && node.right != null) {
                // 情况二 左节点为null
                node = node.right;
                return node;
            }else if (node.left != null && node.right == null) {
                node = node.left;
                return node;
            }else{
                // 情况三 要删除的节点有左右子节点
                AVLNode cur = node.right;
                while(cur.left != null) {
                    cur = cur.left;
                }
                node.val = cur.val;
                node.right = deleteNode(node.right, cur.val);
            }
        }

        //更新树高
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);
        // LL失衡
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        // LR失衡
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left =  leftRotate(node.left);
            return rightRotate(node);
        }
        // RR失衡
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        // RL失衡
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = leftRotate(node.right);
            return rightRotate(node);
        }
        return node;
    }

    private static void prevOrderTraversal(AVLNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        prevOrderTraversal(node.left);
        prevOrderTraversal(node.right);
    }

    private static void inOrderTraversal(AVLNode node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right);
    }

    // 迭代二分查找
    private static AVLNode find(AVLNode root, int key) {
        int counter = 0;
        AVLNode cur = root;
        while(cur != null) {
            if (key > cur.val) {
                cur = cur.right;
            }else if(key < cur.val) {
                cur = cur.left;
            }else {
                System.out.println("找到了 key: " + cur.val + "，查找次数： " + counter);
                return cur;
            }
            counter++;
        }
        return null;
    }

    private static int getBalance(AVLNode node) {
        return getHeight(node.left) - getHeight(node.right);
    }
}
