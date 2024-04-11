package com.chenyue.experiment.os;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author chenyue7@foxmail.com
 */
public class Banker {

    private static final Scanner sc = new Scanner(System.in);
    private int[] available; //available[i]=k  i类资源有k个可用资源
    private int[][] max;    // 最大需求矩阵 max[i][j]=k  进程i对j类资源的需求量为k
    private int[][] allocation; // 已分配矩阵 alloc[i][j]=k  进程i获得j类资源的数量为k
    private int[][] need;   //需求矩阵， 每个元素代表每个进程还需要的每类资源的数目
    //private int[][] requestMap; // request[j]=k 表示进程i需要j
    private final List<Integer> finishWorkProcessList = new ArrayList<>();


    public Banker(){
        init();
    }

    //初始化
    private void init(){
        available = new int[]{4,3,6};
        max = new int[][]{{5,2,3},{5,6,6},{6,3,5}};
        allocation = new int[][]{{0,1,0},{1,3,0},{1,1,3}};
        need = new int[max.length][max[0].length];
        for (int i = 0; i < need.length; i++){
            for (int j = 0; j < need[0].length; j++){
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
//        System.out.println(need);
    }

    public void mockBankerSchedule(int[] requestVec){
        int pid = requestVec[0];

//        if (finishWorkProcessList.contains(pid)){
//            System.out.println("pid "+pid+":线程已完成工作");
//            return;
//        }

        for (int i = 1; i < requestVec.length; i++){
            if (requestVec[i] > need[pid][i-1] || requestVec[i] > available[i-1]){
                System.out.println("-------------------\npid:"+pid+"请求 资源id"+(i-1)+"错误.\n原因:请求个数不合理\n-------------------");
                return;
            }
        }

        if (securityCheck(requestVec)){
            for (int i = 1; i < requestVec.length; i++){
                available[i-1] -= requestVec[i];
                allocation[pid][i-1] += requestVec[i];
                need[pid][i-1] -= requestVec[i];
            }
//            checkProcessWorkFinish(pid);
        }else {
            System.out.println("-------------------\n请求不安全,分配资源失败！！\n-------------------");
        }

    }

    //接收一个进程的请求命令 格式: request(pid,srcid_count,srcid2_count,srcid3_count)
    private  void receiveAndHandleCmdOrder(){
        System.out.print("cmd:");
        String cmd = sc.nextLine();
        if (cmd.startsWith("request")){
            int[] requestVec = handleReqParams(cmd);
//            for (int i: requestVec){
//                System.out.println(i);
//            }
            mockBankerSchedule(requestVec);
        }else if ("exit".equals(cmd)){
            System.out.println("[echo]退出命令行...");
            System.exit(0);
        }else if("showdetail".equals(cmd)){
            showdetail();
        }else {
            System.out.println("[echo]未知命令‘"+cmd+"’");
        }
    }

    //判断线程是否完成工作 并工作还回资源
//    public boolean checkProcessWorkFinish(int pid){
//        for (int i = 0; i < max.length; i++){
//            if (max[pid][i] != allocation[pid][i]){
//                return false;
//            }
//        }
//        finishWorkProcessList.add(pid);
//        for (int i = 0; i < allocation.length; i++){
//            available[i] += allocation[pid][i];
//
//        }
//        return true;
//    }

    public int[] handleReqParams(String cmd){
        int[] requestVec = new int[max.length+1];
        try {
            String[] params = cmd.substring(cmd.indexOf('(')).replaceAll("[()]", "").split(",");
            if (params.length != max.length+1){
                throw new Exception("参数个数不正确");
            }
            for (int i = 0; i < params.length; i++){
                requestVec[i] = Integer.parseInt(params[i]);
            }
        }catch (Exception e){
            System.out.println("[echo]request命名格式错误！！ 格式:request(pid,srcid_count,srcid2_count,srcid3_count)");
        }
        return requestVec;
    }

    private void showdetail(){
        System.out.println("----------------------showdetail-------------------------");
        System.out.print("availableVector:");
        for (int j = 0; j < available.length; j++){
            System.out.print(available[j]+" ");
        }
        System.out.println("\n\npid\t\tmax\t\talloc\t\tneed\t\t");
        for (int i = 0; i < max.length; i ++){
            System.out.print(i+"\t\t");
            for (int j = 0; j < max[0].length; j++){
                System.out.print(max[i][j]+" ");
            }
            System.out.print("\t");
            for (int j = 0; j < allocation[0].length; j++){
                System.out.print(allocation[i][j]+" ");
            }
            System.out.print("\t\t");
            for (int j = 0; j < need[0].length; j++){
                System.out.print(need[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("\nsecurity analyze:");
        boolean isSafety = securityCheck(new int[0]);
//        System.out.println("isSafety:" + isSafety);
        if (isSafety){
            int[]  tmpavailable = Arrays.copyOf(available, available.length);
            System.out.println("pid\t\twork\talloc\t\tneed\twork+alloc");
            for (Integer i:finishWorkProcessList){
                System.out.print(i+"\t\t");
                for (int j = 0; j < tmpavailable.length; j++){// work
                    System.out.print(tmpavailable[j]+" ");
                }
                System.out.print("\t");
                for (int j = 0; j < allocation[0].length; j++){
                    System.out.print(allocation[i][j]+" ");
                }
                System.out.print("\t\t");
                for (int j = 0; j < need[0].length; j++){
                    System.out.print(need[i][j]+" ");
                }
                System.out.print("\t");
                for (int j = 0; j < tmpavailable.length; j++){//work + alloc
                    tmpavailable[j] += allocation[i][j];
                    System.out.print(tmpavailable[j]+" ");
                }
                System.out.println();
            }
        }else {
            System.out.println("not safety");
        }
        System.out.println("----------------------showdetail-------------------------");
    }

    //安全检查算法
    private boolean securityCheck(int[] requestVec){

        int[] work = Arrays.copyOf(available, available.length); // resourceVector
//        int[][] tmpmax = copy2Array(max);                        // tmpMax
        int[][] tmpallocation = copy2Array(allocation);
        int[][] tmpneed = copy2Array(need);
//        boolean[] finish = new boolean[work.length];
//        List<Integer> pids = getNotFinishWorkProcessList();

        // work(available)  need   allocation   work+allocation   finish
        // 3 3 2            1 2 1  2 0  0       2 1 1             false

        // work =
        // 先分配
        if (requestVec.length != 0){
            int pid = requestVec[0];
            for (int i = 0; i < work.length; i++){
                tmpallocation[pid][i] += requestVec[i+1];
                work[i] -= requestVec[i+1];
                tmpneed[pid][i] -= requestVec[i+1];
            }
        }

        finishWorkProcessList.clear();
        boolean isSafety = true; // safety
        for (int  r = 0; r < max.length; r++){ // k轮
            for (int i = 0; i <  max.length; i++){
                isSafety = true;
                if (!finishWorkProcessList.contains(i)){
                    for(int j = 0; j < work.length; j++){
                        if (work[j] < tmpneed[i][j]){
                            isSafety = false;
                        }
                    }
                }
                if (isSafety && !finishWorkProcessList.contains(i)){
                    for(int j = 0; j < work.length; j++){
                        work[j] += tmpallocation[i][j];
                    }
                    finishWorkProcessList.add(i);
                }
            }
        }

        return finishWorkProcessList.size() == max.length;
    }

//    private List<Integer> getNotFinishWorkProcessList() {
//        List<Integer> notFinishWorkProcesses = new ArrayList<>();
//        for (int i = 0;  i < max.length; i++){
//            if (!finishWorkProcessList.contains(i)){
//                notFinishWorkProcesses.add(i);
//            }
//        }
//        return notFinishWorkProcesses;
//    }

    public static void main(String[] args) {
        Banker banker = new Banker();
        while (true){
            banker.receiveAndHandleCmdOrder();
        }
//        int[][] max1 = new int[][]{{0,2,0},{0,1,0},{1,0,5}};
//        int[][] max2 = copy2Array(max1);
//        max2[1][1]=2;
//        bl2Array(max1);
//
//        List<Integer> lst = new ArrayList<>();
//        lst.add(1);
//        lst.add(2);
//        if (lst.contains(3)){
//            System.out.println("existed");
//        }else {
//            System.out.println("not existed");
//        }


    }

    //拷贝二维数组
    public static int[][] copy2Array(int[][] max){
        int[][] tmp = new int[max.length][max[0].length];
        for (int i = 0; i < max.length; i++){
            for (int j = 0; j < max[0].length; j++){
//                System.out.println(max[i][j]+" ");
//                if (j == max[0].length - 1){
//                    System.out.println();
//                }
                tmp[i][j] = max[i][j];
            }
        }
        return tmp;
    }

    // 遍历二维数组
    public static void bl2Array(int[][] max){
        for (int i = 0; i < max.length; i++){
            for (int j = 0; j < max[0].length; j++){
                System.out.println(max[i][j]+" ");
                if (j == max[0].length - 1){
                    System.out.println();
                }

            }
        }
    }

}
