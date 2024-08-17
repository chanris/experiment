package com.chenyue.experiment.oj;

import java.util.*;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/15
 * @description
 */
public class lc909 {
    public static void main(String[] args) {
        int[][] board = new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        lc909 lc = new lc909();
        lc.snakesAndLadders(board);
//        System.out.println(0 / 4);
        HashMap<String, Integer> m = new HashMap<>();
    }

    Deque<Integer> q = new LinkedList<>();
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        q.addFirst(1);
        int count = 0;
        while(!q.isEmpty()) {
            count++;
            int curr = q.removeLast();
            if(curr == n * n) return count;
            int x = n - (curr / n) - 1;
            int y = x % 2 == 0 ? n - 1 - (curr-1 % n) : (curr -1%n);
            System.out.println("x:" + x +",y:" + y);
            if(board[x][y] != -1) {
                q.addFirst(board[x][y]);
            }else {
                for(int next = curr + 1; next <= Math.min(curr+6, n*n); next++) {
                    q.addFirst(next);
                }
            }
        }
        return count;
    }
}
