package com.chenyue.experiment.os;


import com.chenyue.experiment.os.enums.PcbState;
import com.chenyue.experiment.os.enums.PriorityEnum;
import com.chenyue.experiment.os.model.PcbInfo;

import java.io.*;
import java.util.*;

/**
 * @author chenyue7@foxmail.com
 *
 * 时间片轮转调度算法模拟实现
 *
 */
@SuppressWarnings("all")
public class RoundRobin{

    private static Map<Integer, List<PcbInfo>> nodeList;
    private volatile Integer timeSliceLength = 1; // 1s
    private static BufferedWriter writer;
    private static Scanner sc;

    static {
        sc = new Scanner(System.in);
        try {
            File file = new File("result.log");
            if (!file.exists()){
                file.createNewFile();
            }
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write("");
        }catch (Exception e){
            e.printStackTrace();
        }
        nodeList = new HashMap<>(9);
    }
    public RoundRobin(){
        init();
    }

    private void init(){
        for (int i = 0; i <= PriorityEnum.MIN_PRIORITY.ordinal(); i++){
            int len = (int)(Math.random()*3+1); // 0~3
            List<PcbInfo> pcbInfos = new ArrayList<>(len);
            try {
                for (int j = 0; j < len; j++){
                    PcbInfo pcbInfo = new PcbInfo("pc"+i+"_"+j, i, (int)(Math.random()*10+1), PcbState.RUNNABLE.getValue(), 0);
                    writer.append(pcbInfo.toString()).append("\n");
                    pcbInfos.add(pcbInfo);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            nodeList.put(i, pcbInfos);
        }

    }

    @SuppressWarnings("all")
    public Thread mock() {
       Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                List<PcbInfo> minlist = nodeList.get(PriorityEnum.MIN_PRIORITY.getValue());
                for (int i = 0; i <= 7; i++ ){
                    List<PcbInfo> list = nodeList.get(i);
                    Iterator<PcbInfo> iterator = list.iterator();
                    if (!isWorkFinish(iterator)){
                        Iterator<PcbInfo> iterator2 = list.iterator();
                        while (iterator2.hasNext()){
                            PcbInfo pcbInfo = iterator2.next();
                            if (pcbInfo.increaseExcTime(timeSliceLength)){
                            	pcbInfo.setPriority(i+1);
                                //每次执行的结果
                                try {
                                    writer.append("\n时间片：").append(Integer.toString(timeSliceLength))
                                            .append(" 当前进程名：").append(pcbInfo.getName()).append("已执行时间: ")
                                    .append(Integer.toString(pcbInfo.getExecTime())).append(" 执行次数: ").append(Integer.toString(pcbInfo.getCount()))
                                    .append(" 需要总时间：").append(Integer.toString(pcbInfo.getNeedTime()));
                                    Thread.sleep(300);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                iterator2.remove();
                                List<PcbInfo> lowerlist = nodeList.get(i+1);
                                lowerlist.add(pcbInfo);
                            }
                        }
                    }
                }
                System.out.println("exec --- next----");
                Iterator<PcbInfo> infoIterator3 = minlist.iterator();
                while (infoIterator3.hasNext()){
                    PcbInfo pcbInfo = infoIterator3.next();
                    System.out.println(pcbInfo);
                }
                while (true){
                    Iterator<PcbInfo> infoIterator = minlist.iterator();
                    if (!isWorkFinish(infoIterator)){
                        System.out.println("------");
                        Iterator<PcbInfo> infoIterator2 = minlist.iterator();
                        while (infoIterator2.hasNext()){
                            PcbInfo pcbInfo = infoIterator2.next();
                            if (PcbState.isRunnable(pcbInfo.getState())){
                                if (pcbInfo.increaseExcTime(timeSliceLength)){
                                    //每次执行的结果
                                    try {
                                    	writer.append("\n时间片：").append(Integer.toString(timeSliceLength))
                                        .append(" 当前进程名：").append(pcbInfo.getName()).append(" 已执行时间: ")
                                        .append(Integer.toString(pcbInfo.getExecTime())).append(" 执行次数: ").append(Integer.toString(pcbInfo.getCount()))
                                        .append(" 需要总时间：").append(Integer.toString(pcbInfo.getNeedTime()));
                                    	Thread.sleep(300);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }else {
                        break;
                    }
                }
                System.out.println("exec --- over----");
            }
       });
       t.start();
       return t;
    }

    private boolean isWorkFinish(Iterator<PcbInfo> infoIterator){
        while (infoIterator.hasNext()){
            PcbInfo pcbInfo = infoIterator.next();
            if (PcbState.isRunnable(pcbInfo.getState())){
                return false;
            }
        }
        return true;
    }

    public int[] handleReqParams(String cmd){
        int[] requestVec = new int[3];
        try {
            String[] params = cmd.substring(cmd.indexOf('(')).replaceAll("[()]", "").split(",");
            if (params.length != 1){
                throw new Exception("参数个数不正确");
            }
            for (int i = 0; i < params.length; i++){
                requestVec[i] = Integer.parseInt(params[i]);
            }
        }catch (Exception e){
            System.out.println("[echo]request命名格式错误！！ 格式:fix(pageId)");
        }
        return requestVec;
    }

    public void receiveAndHandleCmdOrder() throws IOException {
        String cmd;
        while (true){
            System.out.print("cmd:");
            cmd = sc.nextLine();
            if (cmd.equalsIgnoreCase("exit")) {
                System.out.println("[echo]退出程序成功..");
                break;
            } else if (cmd.startsWith("fix(")) {
                int[] params = handleReqParams(cmd);
                timeSliceLength = params[0];
                writer.append("\n修改时间片成功！ 当前时间片：").append(String.valueOf(timeSliceLength));
                System.out.println("修改成功");
            }else {
                System.out.println("[echo]未知命令‘" + cmd + "’");
            }
        }

    }


    public static void main(String[] args) throws IOException {
        RoundRobin roundRobin = new RoundRobin();
        Thread t = roundRobin.mock();
        roundRobin.receiveAndHandleCmdOrder();
        while (true){
            if (t.getState().equals(Thread.State.TERMINATED)){
                break;
            }
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
            }
        }
        writer.flush();
        writer.close();
    }
}
