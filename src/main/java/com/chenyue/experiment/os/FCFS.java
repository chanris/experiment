package com.chenyue.experiment.os;

import com.chenyue.experiment.os.model.PCB;
import com.chenyue.experiment.os.model.PcbExecuteInfo;

import java.util.*;

/**
 * @author chenyue7@foxmail.com
 */
public class FCFS {

    private int time; //run time
    private int sumRunTime;
    private static List<PcbExecuteInfo> infos = new ArrayList<>();
    private volatile List<PCB> pcbs;


    public List<PCB> getPcbs() {
        return pcbs;
    }

    public void setPcbs(List<PCB> pcbs) {
        this.pcbs = pcbs;
    }

    public void cmd(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                String cmd = null;
                while (true){
                    System.out.print("cmd:");
                    cmd = sc.nextLine();
                    System.out.println("[echo]: "+cmd);
                    if (cmd.equalsIgnoreCase("exit")){
                        System.out.println("退出命令行...");
                        break;
                    }else if (cmd.equalsIgnoreCase("fixtime")){
                        System.out.print("need fix process pid:");
                        String pidStr = sc.nextLine();
                        System.out.print("need fix comingTime:");
                        cmd = sc.nextLine();
                        System.out.println("[echo]: " + pidStr + " " + cmd);
                        Integer pid = Integer.parseInt(pidStr);
                        if (pcbs.size() != 0 && pcbs.get(0).getPid().equals(pid)){
                            System.out.println("不能修改正在运行的进程的到达时间！！");
                            break;
                        }
                        for (PCB pcb: pcbs){
                            if (pcb.getPid().equals(pid)){
                                pcb.setComingTime(Integer.parseInt(cmd));
                                System.out.println("fix pid: "+pid + " comingTime: "+pcb.getComingTime()+" successfully");
                            }
                        }
                    }else if ("showdetail".equalsIgnoreCase(cmd)){

                        for (PcbExecuteInfo info: infos){
                            System.out.println(info);
                        }
                    }

                    Thread.yield();
                }
            }
        }).start();
    }

    public void execute(){
        new Thread(() -> {
            while (true){
//                    System.out.println(time);
//                    System.out.println(pcbs);
                if (pcbs == null || pcbs.size() == 0){
                    System.out.println("没有进程");
                    for (PcbExecuteInfo info: infos){
                        System.out.println(info);
                    }
                    break;
                }
                sort(pcbs);
                PcbExecuteInfo info = new PcbExecuteInfo();
//                    System.out.println(pcbs.get(0));
                PCB pcb = pcbs.get(0);
                if(sumRunTime >= pcb.getComingTime() && pcb.getServiceTime() == time){
                    info.setPid(pcb.getPid());
                    info.setComingTime(pcb.getComingTime());
                    info.setServiceTime(pcb.getServiceTime());
                    info.setStartTime(sumRunTime - time);
                    info.setEndTime(sumRunTime);
                    infos.add(info);
                    time = 0;
                    pcbs.remove(0);
                }

                if(sumRunTime < pcb.getComingTime()){
                    time = 0;
                }

                try {
                    time = time + 1;
                    sumRunTime = sumRunTime + 1;
                    Thread.sleep(1000);
                }catch (Exception e){
                }
                Thread.yield();
            }
        }).start();

    }

    public List<PCB> sort(List<PCB> pcbs){
        Collections.sort(pcbs, new Comparator<PCB>() {
            @Override
            public int compare(PCB o1, PCB o2) {
                return o1.getComingTime() - o2.getComingTime();
            }
        });
//        for (PCB pcb: pcbs){
//            System.out.println(pcb);
//        }
        return pcbs;
    }

    public static List<PcbExecuteInfo> getInfos(){
        return infos;
    }
}
