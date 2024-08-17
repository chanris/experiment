package com.chenyue.experiment.oj;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/13
 * @description
 */
public class lc149 {

    public static void main(String[] args) {
        lc149 lc = new lc149();
        int[][] points = new int[][]{{4,5},{4,-1},{4,0}};
        int i = lc.maxPoints(points);
        System.out.println(i);
    }
    boolean[] visited;
    public int maxPoints(int[][] points) {
        visited = new boolean[points.length];
        return dfs(points, null, null, null, 0);
    }

    public int dfs(int[][] points, Integer a, Integer b, Integer prev, int start) {
        int count = 0;
        for(int i = start; i < points.length; i++) {
            if(prev == null) {
                visited[i] = true;
                count = Math.max(dfs(points, null, null, i, i+1) + 1, count);
                visited[i] = false;
            }else if(a == null) {
                int detX = points[prev][0] - points[i][0];
                int detY = points[prev][1] - points[i][1];
                int kx = detX / gcd(Math.abs(detX), Math.abs(detY));
                int ky = detY / gcd(Math.abs(detX), Math.abs(detY));
                if(kx < 0) {
                    kx = -kx;
                    ky = -ky;
                }
                count = Math.max(dfs(points, kx, ky, i, i+1) + 1, count);
            }else if(a != null) {
                int detX = points[prev][0] - points[i][0];
                int detY = points[prev][1] - points[i][1];
                int kx = detX / gcd(Math.abs(detX), Math.abs(detY));
                int ky = detY / gcd(Math.abs(detX), Math.abs(detY));
                if(kx < 0) {
                    kx = -kx;
                    ky = -ky;
                }
                if((kx == a && ky == b) || (kx == 0 && a == 0) || (ky == 0 && b == 0)) {
                    count = Math.max(dfs(points, kx, ky, i, i+1) + 1, count);
                }
            }
        }
        return count;
    }

    public int gcd(int a, int b) {
        if(a < b) {
            a = a ^ b; // 第一次异或
            b = a ^ b; // 第二次异或
            a = a ^ b; // 第三次异或
        }
        while(b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
