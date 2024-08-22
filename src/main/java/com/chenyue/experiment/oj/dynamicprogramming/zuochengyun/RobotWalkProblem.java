package com.chenyue.experiment.oj.dynamicprogramming.zuochengyun;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/21
 * @description 假设设有排成一行的N个位置记为1到N（N>=2）
 * 开始时机器人在其中的M位置上(M一定时1-N中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2位置
 * 如果机器人来到N位置，那么下一步只能往左来到N-1位置
 * 如果机器人来到中间位置，那么下一步可能往左走或往右走
 * 规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数N、M、K、P，返回方法数
 * N:总共的位置
 * M:机器人起始位置
 * K:机器人一共走K步
 * P:最后停止的目标位置
 */
public class RobotWalkProblem {

    public static void main(String[] args) {
        RobotWalkProblem r = new RobotWalkProblem();
        int N = 5, M = 2, K = 3, P = 3;
        //int m = r.getMethodCount1(N, M, K, P);// 正确答案：3
        //System.out.println(m);
        int[][] dp = new int[N+1][K+1]; //变化二元组(N, M)
        for (int i = 0; i <= N; i++) {
            // 填充-1代表 位置为i, 剩余步数为M的情况还没有计算过。
            Arrays.fill(dp[i], -1);
        }
        int m2 = r.getMethodCount2(N, M, K, P, dp);
        System.out.println(m2);
    }

    // 暴力求解
    public int getMethodCount1(int N, int M, int K, int P) {
        if(K == 0) {
            return M == P ? 1 : 0;
        }
        if(M == 1) {
           return getMethodCount1(N, 2, K - 1, P);
        }
        if(M == N) {
            return getMethodCount1(N, N-1, K - 1, P);
        }
        return getMethodCount1(N, M-1, K - 1, P) + getMethodCount1(N, M+1, K - 1, P);
    }

    // 动态规范：用缓存表缓存之前的结果，不再重复计算
    public int getMethodCount2(int N, int M, int K, int P, int[][] dp) {
        // 如果（M,K）的状态已经被计算过，则直接返回
        if(dp[M][K] != -1) return dp[M][K];
        // 剩余步数为0时，
        int ans = 0;
        if(K == 0) {
            return M == P ? 1 : 0;
        }
        if(M == 1) {
            ans = getMethodCount2(N, 2, K - 1, P, dp);
        }
        else if(M == N) {
            ans = getMethodCount2(N, N - 1, K - 1, P, dp);
        }else {
            ans = getMethodCount2(N, M - 1, K - 1, P, dp) + getMethodCount2(N, M + 1, K - 1, P, dp);
        }
        // 缓存计算结果
        dp[M][K] = ans;
        return ans;
    }

    // 使用迭代代替递归填充缓存表
    // todo 24/8/22
    public int getMethod3(int N, int M, int K, int P, int[][] dp) {
        return -1;
    }
}
