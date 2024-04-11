package com.chenyue.experiment.os.test;

import com.chenyue.experiment.os.util.ProcessUtil;
import com.chenyue.experiment.os.FCFS;

/**
 * @author chenyue7@foxmail.com
 */
public class Test {
    public static void main(String[] args) {
//        Map<Integer, Integer> nodeList = new HashMap<>();
////        System.out.println(nodeList.containsKey(1));
//
////        System.out.println(PriorityEnum.MIN_PRIORITY.ordinal());
//
//        Node node = Node.builder().append(new PcbInfo("1",1,10, 1, 0))
//                .append(new PcbInfo("2",1,10, 1, 0))
//                .append(new PcbInfo("3",1,10, 1, 0)).build();
//        node.traverse(13);
//        System.out.println(node.size);

//        List<Integer> list = new ArrayList<>();
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        for (int i = 0; i < 3; i++){
//            Iterator<Integer> infoIterator = list.iterator();
//
//            while (infoIterator.hasNext()){
//                Integer j = infoIterator.next();
//                if (j == 2){
//                    infoIterator.remove();
//                }
//                System.out.println(j);
//            }
//        }

        fcfsTest();
    }


    private static void fcfsTest(){
        FCFS fcfs = new FCFS();
        fcfs.setPcbs(ProcessUtil.createProcesses());
        fcfs.execute();
//        fcfs.goOn(ProcessUtil.createProcesses());
        fcfs.cmd();
    }
}
