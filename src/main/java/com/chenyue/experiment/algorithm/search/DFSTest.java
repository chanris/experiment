package com.chenyue.experiment.algorithm.search;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author chenyue7@foxmail.com
 * @date 10/1/2024
 * @description
 */
public class DFSTest {
    private int V; // 节点数量
    private LinkedList<Integer> adj[]; // 邻接矩阵

    public DFSTest(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // 添加边到图中
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // 从节点s打印图
    public void DFS(int s) {
        boolean[] visited = new boolean[V];
        DFSUtil(s, visited);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    public static void main(String[] args) {
        DFSTest test = new DFSTest(6);
        test.addEdge(0, 1);
        test.addEdge(1, 2);
        test.addEdge(2, 3);
        test.addEdge(2, 4);
        test.addEdge(4, 5);
        test.DFS(1);
    }
}
