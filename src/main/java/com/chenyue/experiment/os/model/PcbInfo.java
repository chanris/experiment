package com.chenyue.experiment.os.model;

import com.chenyue.experiment.os.enums.PcbState;

/**
 * @author chenyue7@foxmail.com
 *
 *
 * 基于时间片的高优先级调度模拟实现
 * 进程信息对象
 *
 */
public class PcbInfo {
    private String name;      //进程名称
    private Integer priority; //优先级
    private Integer needTime; //需要执行的时间
    private Integer execTime = 0; //已执行的时间
    private Integer state;    //进程的状态
    private Integer count;    //记录执行的次数


    public PcbInfo() {
    }

    public PcbInfo(String name, Integer priority, Integer needTime, Integer state, Integer count) {
        this.name = name;
        this.priority = priority;
        this.needTime = needTime;
        this.state = state;
        this.count = count;
    }

    public boolean increaseExcTime(Integer time){
        if (execTime < needTime){
            count++;
            execTime += time;
            return true;
        }
        state = PcbState.TERMINATED.getValue();
        return false;
    }

    public Integer getExecTime() {
        return execTime;
    }

    public void setExecTime(Integer execTime) {
        this.execTime = execTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getNeedTime() {
        return needTime;
    }

    public void setNeedTime(Integer needTime) {
        this.needTime = needTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PcbInfo{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", needTime=" + needTime +
                ", state=" + state +
                ", count=" + count +
                '}';
    }
}
