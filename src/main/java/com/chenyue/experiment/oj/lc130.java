package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/12
 * @description
 */
public class lc130 {

    public static void main(String[] args) {
        lc130 lc = new lc130();
        char[][] board = new char[][]{{'O','O'},{'O','O'}};
        lc.solve(board);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[m-1].length;
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if(board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if(board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'R') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int r, int c) {
        board[r][c] = 'R';
        if(inArea(board, r+1, c) && board[r+1][c] == 'O') {
            dfs(board, r+1, c);
        }
        if(inArea(board, r-1, c) && board[r-1][c] == 'O') {
            dfs(board, r+1, c);
        }
        if(inArea(board, r, c-1) && board[r][c-1] == 'O') {
            dfs(board, r, c-1);
        }
        if(inArea(board, r, c+1) && board[r][c+1] == 'O') {
            dfs(board, r, c+1);
        }
    }

    public boolean inArea(char[][] board, int i, int j) {
        return 0 <= i && i < board.length && 0 <= j && j < board[i].length;
    }
}
