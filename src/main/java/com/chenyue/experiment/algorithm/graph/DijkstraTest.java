package com.chenyue.experiment.algorithm.graph;

/**
 * @author chenyue7@foxmail.com
 * @date 18/4/2024
 * @description
 */
public class DijkstraTest {
    /**
     * 基于邻接矩阵的迪杰斯特拉算法实现
     * @param start
     * @param end
     */
    public void dijkstra(int start, int end){
        int n = 6;
        final int INF = Integer.MAX_VALUE;
        //用邻接矩阵存储带权无向图
        int[][] graph = new int[][]{
                {INF, 6, 3, INF, INF, INF},
                {6, INF, 2, 5 ,INF, INF},
                {3, 2, INF, 3, 4, INF},
                {INF, 5, 3, INF, 2, 3},
                {INF, INF, 4, 2, INF, 5},
                {INF, INF, INF, 3, 5, INF}
        };

        int[] cost = new int[n]; // 存储start顶点到其它顶点的权值
        boolean[] use = new boolean[n]; // 记录S集合和U集合的元素
        int[] path = new int[n]; // 记录当前顶点的前驱顶点位置

        use[start] = true; // start顶点本身算作已经是求了最短的路径信息了

        // 初始化const权值数组，并把可通行顶点的path数组相应的下标初始化成start起始顶点的下标
        for (int i = 0; i < n; i++) {
            cost[i] = graph[start][i];
            if(cost[i] < INF){
                path[i] = start;
            }
        }

        // 除过start顶点，求其它顶点的最短路径信息
        for (int i = 1; i < n; i++) {
            int k = -1;
            int min = INF;

            //从未找到最短路径的节点当中，找权值最小的节点，作为源节点继续计算最短路径信息
            for (int j = 0; j < n; j++) {
                if(!use[j] && cost[j] < min){
                    min = cost[j];
                    k = j;
                }
            }

            // 集合中剩下的节点都是不可通行的
            if(k == -1){
                break;
            }

            // 把k节点选入S集合，更新计算所有顶点的最短路径信息
            use[k] = true;
            for (int j = 0; j < n; j++) {
                if(!use[j] && min + graph[k][j] < cost[j]){
                    cost[j] = min + graph[k][j];
                    path[j] = k;
                }
            }
        }

        System.out.print(end + " => ");
        int index = end;
        while(true){
            int val = path[index];
            System.out.print(val + " => ");
            if(val == start){
                break;
            }
            index = val;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DijkstraTest test = new DijkstraTest();
        test.dijkstra(1, 5);
    }
}
