package com.chenyue.experiment.datastructure.binarytree;

import com.chenyue.experiment.datastructure.TNode;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/13
 * @description
 */
@SuppressWarnings("all")
public class RebuildBTree {

    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        int n = preOrder.length;
        TNode root = null;
        if (n <= 1) {
            root = new TNode(preOrder[0]);
        }
        int val = preOrder[0];
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (inOrder[i] == val) {
//                root = rebuild(preOrder, inOrder, 1, , );
                break;
            }
        }

    }

    private static TNode rebuild(int[] prevOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
        return null;
    }


    private static class BNode {
        BNode left;
        BNode right;
        int val;
        public BNode(int val) {
            this.val = val;
        }
    }
}
