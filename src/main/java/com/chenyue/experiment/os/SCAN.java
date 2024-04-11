package com.chenyue.experiment.os;


import java.util.*;

/**
 * @author chenyue7@foxmail.com
 *
 * 磁盘调度算法
 * FIFO:先到先服务
 * SCAN:(电梯算法)
 * CSAN:循环扫描算法
 */
public class SCAN {


    private final Scanner sc = new Scanner(System.in);
    private final List<RequestInfo> requestInfos = new ArrayList<>();
    private final List<RequestInfo> receiveRequestInfos = new ArrayList<>();
    private int requestListSize; // 总寻道次数
    private int searchUnitTime; //寻道单位时间
    private int sumSearchNum;
//    private int handleNum; //处理请求的个数
    private int time;  //请求时间
    private int curTrackNum = 100; //当前磁头
    private boolean isUp = true; // 磁头朝向上

    public SCAN(){
        init();
    }

    private void init() {
        System.out.println("-------init begin-------");
        System.out.print("最大请求队列数:");
        requestListSize = sc.nextInt();
        System.out.print("单位寻道时间:");
        searchUnitTime = sc.nextInt();
        System.out.println("默认磁道范围:1~200");
        System.out.println("--------init end--------");
        //调度请求队列
        int track = 55;  // 测试一样的track请求
        int id = 0;
        for (int i = 0; i < requestListSize; i++){
            track = (int)(Math.random()*200)+1; // 1~200
            requestInfos.add(new RequestInfo(id++, time++, track));
        }
    }


    //接收请求信息
    private void receiveRequest(){ // 一秒接收一个请求
        new Thread(() -> {
            while (true){
                if (requestInfos.size() != 0){
                    receiveRequestInfos.add(requestInfos.get(0));
                    requestInfos.remove(0);
                }
                try {
                    Thread.sleep(1000);
                }catch(Exception e){
                }
                Thread.yield();
            }
        }).start();
    }


    private void mockScanDisSchedule(){
        List<RequestInfo> requestInfos = receiveRequestInfos;
        if (requestInfos.size() == 0){
            System.out.println("无需要处理的请求");
            return;
        }

        Collections.sort(receiveRequestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                return o1.getTrack() - o2.getTrack();
            }
        });

        boolean isfind = false;
        if (isUp){
            for (RequestInfo request: requestInfos){
                if (curTrackNum <= request.getTrack()){
                    sumSearchNum += request.getTrack() - curTrackNum;
                    curTrackNum = request.getTrack();
                    removeBeforeRequest(curTrackNum);
                    isfind = true;
                    break;
                }
            }
        }else {
            for (int i = requestInfos.size() - 1; i >= 0; i--){
                RequestInfo request = requestInfos.get(i);
                if (curTrackNum >= request.getTrack()){
                    sumSearchNum += curTrackNum - request.getTrack();
                    curTrackNum = request.getTrack();
                    removeBeforeRequest(curTrackNum);
                    isfind = true;
                    break;
                }
            }
        }
        Collections.sort(receiveRequestInfos, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                return o1.getId() - o2.getId();
            }
        });
        if (!isfind){
            isUp = !isUp;
            mockScanDisSchedule();
        }else {
            showdetail();
        }
    }

    private void updateRequestInfo(int id, int time, int track){
        RequestInfo info = find(id);
        if (info == null){
            return;
        }
        info.setTime(time);
        info.setTrack(track);
    }

    public RequestInfo find(int id){
        for (RequestInfo info: requestInfos){
            if (info.id == id){
                return info;
            }
        }
        for (RequestInfo info: receiveRequestInfos){
            if (info.id == id){
                return info;
            }
        }
        throw new RuntimeException("错误的请求id: "+id);
    }


    public static class RequestInfo{
        private int id;
        private int time; // 请求时间
        private int track; //磁道


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public RequestInfo(int id, int time, int track) {
            this.id = id;
            this.time = time;
            this.track = track;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getTrack() {
            return track;
        }

        public void setTrack(int track) {
            this.track = track;
        }

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    ", time=" + time +
                    ", track=" + track +
                    '}';
        }
    }

    //处理最早的请求
    private void removeBeforeRequest(int track){
        List<RequestInfo> requestList = new ArrayList<>();
        for (RequestInfo request: receiveRequestInfos){
            if (request.getTrack() == track){
                requestList.add(request);
            }
        }
        Collections.sort(requestList, new Comparator<RequestInfo>() {
            @Override
            public int compare(RequestInfo o1, RequestInfo o2) {
                return o1.getTime() - o2.getTime();
            }
        });
//        handleNum++;
        receiveRequestInfos.remove(requestList.get(0));
    }


    private void receiveAndHandleCmdOrder(){
        new Thread(()->{
            while (true){
                String cmd;
                System.out.print("cmd:");
                cmd = sc.nextLine();
                if (cmd.equalsIgnoreCase("exit")){
                    System.out.println("[echo]退出程序成功..");
                    System.exit(0);
                }else if (cmd.startsWith("mock")){
                    mockScanDisSchedule();
                }else if (cmd.startsWith("update")){
                    int[] params = handleReqParams(cmd);
                    updateRequestInfo(params[0],params[1], params[2]);
                }else if (cmd.equalsIgnoreCase("show")){
                    showdetail();
                } else {
                    System.out.println("[echo]未知命令‘"+cmd+"’");
                }
                Thread.yield();
            }
        }).start();

    }

    public int[] handleReqParams(String cmd){
        int[] requestVec = new int[3];
        try {
            String[] params = cmd.substring(cmd.indexOf('(')).replaceAll("[()]", "").split(",");
            if (params.length != 3){
                throw new Exception("参数个数不正确");
            }
            for (int i = 0; i < params.length; i++){
                requestVec[i] = Integer.parseInt(params[i]);
            }
        }catch (Exception e){
            System.out.println("[echo]request命名格式错误！！ 格式:update(requestId,time,trackNum)");
        }
        return requestVec;
    }


    private void showdetail(){
        System.out.println("--------showdetail begin--------");
        System.out.println("当前磁头位置:"+curTrackNum);
        System.out.println("磁头朝: "+ (isUp?"↑":"↓"));
        System.out.println("当前需要处理的请求");
        for (RequestInfo info: receiveRequestInfos){
            System.out.println(info);
        }
        System.out.println("--------showdetail end--------");
    }


    public static void main(String[] args) {
        SCAN scan = new SCAN();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        }
        scan.receiveRequest();
        scan.receiveAndHandleCmdOrder();
    }
}
