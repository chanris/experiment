package com.chenyue.experiment.oj.backtracking;

/**
 * @author chenyue7@foxmail.com
 * @date 5/4/2024
 * @description
 */
public class lc79 {

    public static void main(String[] args) {
        lc79 lc79 = new lc79();
//        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = new char[][]{{'a','b'},{'c','d'}};
        String word = "cdba";
        boolean exist = lc79.exist(board, word);
        System.out.println(exist);
    }

    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int c = board[i][j];
                if(c == word.charAt(0)) {
                    dfs(board, i, j, word, 1, -1);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] board, int r, int c, String word, int idx, int preDirect) {
        if (idx == word.length()) {
            ans = true;
            return;
        }
        if (inArea(board, r - 1, c) && board[r - 1][c] == word.charAt(idx) && preDirect != 0) {
            dfs(board, r - 1, c, word, idx + 1, 2);
        }
        if (inArea(board, r, c + 1) && board[r][c + 1] == word.charAt(idx) && preDirect != 1) {
            dfs(board, r, c + 1, word, idx + 1, 3);
        }
        if (inArea(board, r + 1, c) && board[r + 1][c] == word.charAt(idx) && preDirect != 2) {
            dfs(board, r + 1, c, word, idx + 1, 0);
        }
        if (inArea(board, r, c - 1) && board[r][c - 1] == word.charAt(idx) && preDirect != 3) {
            dfs(board, r, c - 1, word, idx + 1, 1);
        }
    }

    public boolean inArea(char[][] board, int r, int c) {
        return 0 <= r && r < board.length && 0 <= c && c < board[r].length;
    }

}
