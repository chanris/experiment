package com.chenyue.experiment.os.util;

import com.chenyue.experiment.os.model.PCB;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 */
public class ProcessUtil {

    public static List<PCB> createProcesses(){
        List<PCB> pcbs = new ArrayList<>();
        pcbs.add(new PCB(0, 0, 7));
        pcbs.add(new PCB(1, 1, 5));
        pcbs.add(new PCB(2, 2, 1));
        pcbs.add(new PCB(3, 2, 1));
        pcbs.add(new PCB(4, 2, 1));
        pcbs.add(new PCB(5, 2, 1));
        pcbs.add(new PCB(6, 2, 1));
        pcbs.add(new PCB(7, 2, 1));
        pcbs.add(new PCB(8, 2, 1));
        pcbs.add(new PCB(9, 2, 1));
        pcbs.add(new PCB(3, 3, 2));
        return pcbs;
    }


    public static String  executeCmd(String cmd){
        return "";
    }
}
