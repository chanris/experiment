package com.chenyue.experiment.datastructure.binarytree;

/**
 * @author chenyue7@foxmail.com
 * @date 26/3/2024
 * @description Java版本的 AVL（自平衡二叉查找/搜索树） 查找效率O(logn)
 */
class AVLNode {
    int key, height;
    AVLNode left, right;
    AVLNode(int d) {
        key = d;
        height = 1;
    }
}

public class AVLTree {
    AVLNode root;

    // 获取节点的高度
    int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // 右旋转
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // 旋转
        x.right = y;
        y.left = T2;

        // 更新高度
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // 返回新的根节点
        return x;
    }

    // 左旋转
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // 旋转
        y.left = x;
        x.right = T2;

        // 更新高度
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // 返回新的根节点
        return y;
    }

    // 获取平衡因子
    int getBalanceFactor(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // 插入节点
    AVLNode insert(AVLNode node, int key) {

        /* 1. 正常的BST插入 */
        if (node == null)
            return (new AVLNode(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // 不允许重复值
            return node;

        /* 2. 更新节点的高度 */
        node.height = 1 + Math.max(height(node.left), height(node.right));

        /* 3. 获取平衡因子，检查节点是否失去平衡 */
        int balance = getBalanceFactor(node);

        // 如果节点不平衡，有4种情况

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* 返回未改变的节点指针 */
        return node;
    }

    // 中序遍历函数辅助函数
    void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    // 中序遍历AVL树
    public void inOrder() {
        inOrder(root);
    }

    // AVL树的插入函数
    void insert(int key) {
        root = insert(root, key);
    }

    public class Main {
        public static void main(String[] args) {
            AVLTree tree = new AVLTree();

            /* 可以按照需求插入数据 */
            tree.insert(10);
            tree.insert(20);
            tree.insert(30);
            tree.insert(40);
            tree.insert(50);
            tree.insert(25);

            /* 中序遍历这个AVL树 */
            tree.inOrder();
        }
    }
}
