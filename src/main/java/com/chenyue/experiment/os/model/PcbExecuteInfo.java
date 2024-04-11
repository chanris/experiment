package com.chenyue.experiment.os.model;

/**
 * @author chenyue7@foxmail.com
 */
public class PcbExecuteInfo {
    private Integer pid;
    private Integer comingTime;
    private Integer startTime; // 开始执行时间
    private Integer serviceTime; // 要求服务时间
    private Integer endTime; //调度完成时间

    public PcbExecuteInfo() {
    }

    public PcbExecuteInfo(Integer pid, Integer comingTime,
                          Integer startTime, Integer serviceTime, Integer endTime) {
        this.pid = pid;
        this.comingTime = comingTime;
        this.startTime = startTime;
        this.serviceTime = serviceTime;
        this.endTime = endTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getComingTime() {
        return comingTime;
    }

    public void setComingTime(Integer comingTime) {
        this.comingTime = comingTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "PcbExecuteInfo{" +
                "pid=" + pid +
                ", comingTime=" + comingTime +
                ", startTime=" + startTime +
                ", serviceTime=" + serviceTime +
                ", endTime=" + endTime +
                '}';
    }
}
