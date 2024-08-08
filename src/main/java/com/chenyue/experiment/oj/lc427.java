package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/8
 * @description
 */
public class lc427 {
    public static void main(String[] args) {
        lc427 lc = new lc427();
        int[][] grid = new int[][]{
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}};
        System.out.println(grid[0][4] == 1);
        Node construct = lc.construct(grid);

    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return buildTree(null, grid, 0, 0, n-1, n-1);
    }

    Node buildTree(Node root, int[][] grid, int leftTopR, int leftTopC, int rightBottomR, int rightBottomC) {
        System.out.println(leftTopR + ":" + leftTopC + ", " + rightBottomR + ":" + rightBottomC);
        if(leftTopR == rightBottomR || leftTopC == rightBottomC) {
            Node node = new Node();
            node.isLeaf = true;
            node.val = grid[leftTopR][leftTopC] == 1;
            return node;
        }
        if(root == null) {
            root = new Node();
        }
        boolean flag = grid[leftTopR][leftTopC] == 1;
        if(flag) {
            boolean b1 = true; // 是叶子节点
            for(int i = leftTopR; i <= rightBottomR && b1; i++) {
                for(int j = leftTopC; j <= rightBottomC && b1; j++) {
                    if(grid[i][j] != 1) {
                        root.isLeaf = false;
                        b1 = false;
                        root.topLeft = buildTree(root.topLeft, grid, leftTopR, leftTopC, (leftTopR + rightBottomR) / 2, (leftTopC + rightBottomC) / 2);
                        root.topRight = buildTree(root.topRight, grid, leftTopR, (leftTopC + rightBottomC) / 2 + 1, (leftTopR + rightBottomR) / 2, rightBottomC);
                        root.bottomLeft = buildTree(root.bottomLeft, grid, (leftTopR + rightBottomR) / 2 + 1, leftTopC, rightBottomR, (leftTopC + rightBottomC) / 2);
                        root.bottomRight = buildTree(root.bottomRight, grid, (leftTopR + rightBottomR) / 2 + 1, (leftTopC + rightBottomC) / 2 + 1, rightBottomR, rightBottomC);
                    }
                }
            }
            if(b1) {
                root.isLeaf = true;
                root.val = true;
            }
        }else {
            boolean b2 = true;
            for(int i = leftTopR; i <= rightBottomR && b2; i++) {
                for(int j = leftTopC; j <= rightBottomC && b2; j++) {
                    if(grid[i][j] != 0) {
                        root.isLeaf = false;
                        b2 = false;
                        root.topLeft = buildTree(root.topLeft, grid, leftTopR, leftTopC, (leftTopR + rightBottomR) / 2, (leftTopC + rightBottomC) / 2);
                        root.topRight = buildTree(root.topRight, grid, leftTopR, (leftTopC + rightBottomC) / 2 + 1, (leftTopR + rightBottomR) / 2, rightBottomC);
                        root.bottomLeft = buildTree(root.bottomLeft, grid, (leftTopR + rightBottomR) / 2 + 1, leftTopC, rightBottomR, (leftTopC + rightBottomC) / 2);
                        root.bottomRight = buildTree(root.bottomRight, grid, (leftTopR + rightBottomR) / 2 + 1, (leftTopC + rightBottomC) / 2 + 1, rightBottomR, rightBottomC);
                    }
                }
            }
            if(b2) {
                root.isLeaf = true;
                root.val = false;
            }
        }
        return root;
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
