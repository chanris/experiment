package com.chenyue.experiment.oj.matrix;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenyue7@qq.com
 * @date 2026/4/3
 */
public class lc200 {

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        System.out.println(new lc200().numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        Deque<Node> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    q.addLast(new Node(i, j));
                    while(!q.isEmpty()) {
                        int len = q.size();
                        while(len--> 0) {
                            Node tmp = q.removeFirst();
                            grid[tmp.x][tmp.y] = '2';
                            if(0 <= tmp.x-1 && grid[tmp.x-1][tmp.y] == '1') {
                                q.addLast(new Node(tmp.x-1, tmp.y));
                            }
                            if(tmp.x+1 < m && grid[tmp.x+1][tmp.y] == '1') {
                                q.addLast(new Node(tmp.x+1, tmp.y));
                            }
                            if(0 <= tmp.y-1 && grid[tmp.x][tmp.y-1] == '1') {
                                q.addLast(new Node(tmp.x, tmp.y-1));
                            }
                            if(tmp.y+1 < n && grid[tmp.x][tmp.y+1] == '1') {
                                q.addLast(new Node(tmp.x, tmp.y+1));
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    static class Node{
        int x, y;
        Node() {}
        Node(int x, int y) {this.x=x; this.y=y;}
    }
}
