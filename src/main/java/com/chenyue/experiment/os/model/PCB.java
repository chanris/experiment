package com.chenyue.experiment.os.model;

/**
 * @author chenyue7@foxmail.com
 */
public class PCB {
    private Integer pid;
    private Integer comingTime;
    private Integer serviceTime;

    public PCB() {
    }

    public PCB(Integer pid, Integer comingTime, Integer startTime) {
        this.pid = pid;
        this.comingTime = comingTime;
        this.serviceTime = startTime;
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

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }


    @Override
    public String toString() {
        return "PCB{" +
                "pid=" + pid +
                ", comingTime=" + comingTime +
                ", serviceTime=" + serviceTime +
                '}';
    }
}
