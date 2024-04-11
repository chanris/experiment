package com.chenyue.experiment.os;

import java.util.*;


/**
 * @author chenyue7@foxmail.com
 *
 * 改进clock页面置换算法
 *
 * commons page replacement algorithm
 * 最佳置换算法 :以后都不使用的页面,理想算法现实实现难度很大,通常作为衡量其他算法的效率的标准
 * 先进先服务(FIFC):先进去内存的页面最先被置换出来
 * 最久未被使用:根据使用页面的情况来判断是否置换,最久未被使用优先置换
 * 简单clock算法: 根据最后访问的时间,进行排序形成一个时钟环,一次判断访问位是否为0,是零换出,遍历当第二遍时,将1置为0
 * 改进clock算法: 根据最后访问的时间,进行排序形成一个时钟环,判断访问位和修改位是否为0,都是置换,
 * 遍历第2遍访问位和修改位不都是0,将访问位置为0,遍历置换0 1
 */
public class AdvancedClockReplaceAlgorithm {


//    private static final List<Integer> visitOrderList = new ArrayList<>();

    private final Scanner sc = new Scanner(System.in);
    private int maxPage;
    private int maxActivePage;  //最大活动页数
    private int curActivePage;
    private List<PageInfo> pageInfos;
    private List<PageInfo> activePageInfos;
    private int lastScheduleTime = 1; // 第一次调度
//    private int sumRequestCount;
//    private int missPageCount;

    public AdvancedClockReplaceAlgorithm(){
        init();
    }

    private void init(){
        System.out.print("-------init begin--------\n总页数:");
        maxPage = sc.nextInt();
        System.out.print("内存块数:");
        maxActivePage = sc.nextInt();
        System.out.println("-------init end--------");
        curActivePage = 0; // 当前活动的page num
        pageInfos = new ArrayList<>(11);
        activePageInfos = new ArrayList<>();
        for (int i = 1; i <= maxPage; i++){
            pageInfos.add(new PageInfo(i,0,(int)(Math.random()*2)));  // 随机设置  修改位
        }
//        for (PageInfo pageInfo : pageInfos){
//            System.out.println(pageInfo);
//        }

        for (int i = 0; i < maxActivePage; i++){
            int pageId = (int)(Math.random()*maxPage)+1;
            PageInfo info = findPage(pageId);
            while (activePageInfos.contains(info)){
                pageId = (int)(Math.random()*maxPage)+1;
                info = findPage(pageId);
            }
            mockPageReplaceSchedule(pageId);
        }
    }

    private void mockPageReplaceSchedule(int pageId){
        PageInfo newPageInfo = findPage(pageId);
        newPageInfo.setVisited(1);
        if (curActivePage < maxActivePage ){
            activePageInfos.add(newPageInfo);
            newPageInfo.setLastVisitedTime(lastScheduleTime++);
            curActivePage++;
        }else {
            if (activePageInfos.contains(newPageInfo)){
                newPageInfo.setLastVisitedTime(lastScheduleTime++);
                return;
            }

            //advanced clock replace algorithm
            activePageInfos.sort(new Comparator<PageInfo>() { //排序
                @Override
                public int compare(PageInfo o1, PageInfo o2) {
                    return o1.lastVisitedTime - o2.lastVisitedTime;
                }
            });
//            Collections.reverse(activePageInfos);
            for (PageInfo info: activePageInfos){
                if (info.getVisited() == 0 && info.getModified() == 0) {
                    activePageInfos.remove(info);
                    activePageInfos.add(newPageInfo);
                    newPageInfo.setLastVisitedTime(lastScheduleTime++);
                    return;
                }
            }
            for (PageInfo info: activePageInfos){
                if (info.getVisited() != 0 && info.getModified() != 1) {
                    info.setVisited(0);
                    continue;
                }
                if (info.getVisited() == 0 && info.getModified() == 1){
                    activePageInfos.remove(info);
                    activePageInfos.add(newPageInfo);
                    newPageInfo.setLastVisitedTime(lastScheduleTime++);
                    return;
                }
            }
            for (PageInfo info: activePageInfos){
                if (info.getVisited() != 0){
                    info.setVisited(0);
                }
            }
            for (PageInfo info: activePageInfos){
                if (info.getVisited() == 0 && info.getModified() == 0) {
                    activePageInfos.remove(info);
                    activePageInfos.add(newPageInfo);
                    newPageInfo.setLastVisitedTime(lastScheduleTime++);
                    return;
                }
            }

        }
    }

    public static class PageInfo  {
        private Integer id;        // 1 ~ +∞
        private Integer visited;   // 0 1
        private Integer modified;  // 0 1
        private Integer lastVisitedTime; // 最后访问时间
        public PageInfo() {
        }

        public Integer getLastVisitedTime() {
            return lastVisitedTime;
        }

        public void setLastVisitedTime(Integer lastVisitedTime) {
            this.lastVisitedTime = lastVisitedTime;
        }

        public PageInfo(Integer id, Integer visited, Integer modified, Integer lastVisitedTime) {
            this.id = id;
            this.visited = visited;
            this.modified = modified;
            this.lastVisitedTime = lastVisitedTime;
        }

        public PageInfo(Integer id, Integer visited, Integer modified) {
            this.id = id;
            this.visited = visited;
            this.modified = modified;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getVisited() {
            return visited;
        }

        public void setVisited(Integer visited) {
            this.visited = visited;
        }

        public Integer getModified() {
            return modified;
        }

        public void setModified(Integer modified) {
            this.modified = modified;
        }

        @Override
        public String toString() {
            return "PageInfo{" +
                    "id=" + id +
                    ", visited=" + visited +
                    ", modified=" + modified +
                    ", lastVisitedTime=" + lastVisitedTime +
                    '}';
        }
    }


    private List<PageInfo> deepCopy(List<PageInfo> pageInfos){
        List<PageInfo> copiedList = new ArrayList<>();
        for (PageInfo pageInfo : pageInfos){
            copiedList.add(new PageInfo(pageInfo.id, pageInfo.visited, pageInfo.modified, pageInfo.lastVisitedTime));
        }
        return copiedList;
    }

    private PageInfo findPage(int id){
        for (PageInfo pageInfo: pageInfos){
            if (id == pageInfo.id){
                return pageInfo;
            }
        }
        throw new RuntimeException("错误的pageId: "+ id);
    }

    private void receiveAndHandleCmdOrder(){
        String cmd;
        System.out.print("cmd:");
        cmd = sc.nextLine();
        if (cmd.equalsIgnoreCase("exit")){
            System.out.println("[echo]退出程序成功..");
            System.exit(0);
        }else if (cmd.startsWith("page")){
            int pageIdx = handleReqParams(cmd)[0];
            if (pageIdx > 0 && pageIdx < 12   ){
                mockPageReplaceSchedule(pageIdx);
            }
        }else if (cmd.startsWith("fix")){
            int[] params = handleReqParams(cmd);
            int pageId = params[0];
            int visited = params[1];
            int modified = params[2];
            PageInfo pageInfo = findPage(pageId);
            if (activePageInfos.contains(pageInfo)){
                pageInfo.setVisited(visited);
                pageInfo.setModified(modified);
                pageInfo.setLastVisitedTime(lastScheduleTime++);
                System.out.println("[echo]修改成功 pageId: " + pageId);
            }else {
                System.out.println("[echo]当前页 pageId:"+ pageId+"不在内存 不可修改");
            }


        }else if (cmd.equalsIgnoreCase("showdetail")){
            showdetail();
        }
        else {
            System.out.println("[echo]未知命令‘"+cmd+"’");
        }


    }

    public int[] handleReqParams(String cmd){
        int[] requestVec = new int[3];
        try {
            String[] params = cmd.substring(cmd.indexOf('(')).replaceAll("[()]", "").split(",");
            if (params.length != 1 && params.length != 3){
                throw new Exception("参数个数不正确");
            }
            for (int i = 0; i < params.length; i++){
                requestVec[i] = Integer.parseInt(params[i]);
            }
        }catch (Exception e){
            System.out.println("[echo]request命名格式错误！！ 格式:page(pageId) or fix(pageId,visited,modified)");
        }
        return requestVec;
    }


    private void showdetail(){
        System.out.println("----------------------showdetail-------------------------");
        System.out.println("当前内存页面信息");
        for (PageInfo info: activePageInfos){
            System.out.println(info);
        }
        System.out.println("----------------------showdetail-------------------------");
    }

    public static void main(String[] args) {
        AdvancedClockReplaceAlgorithm clockAlgorithm = new AdvancedClockReplaceAlgorithm();
        while(true){
            clockAlgorithm.receiveAndHandleCmdOrder();
        }
    }
}
