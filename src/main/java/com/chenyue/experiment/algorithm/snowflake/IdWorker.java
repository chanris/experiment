package com.chenyue.experiment.algorithm.snowflake;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/17
 */
public class IdWorker {
    /*机器ID*/
    private long workerId;
    /*机房ID*/
    private long datacenterId;
    private long sequence;
    private long twepoch = 1585644268888L;
    // 5位的机器id
    private long workIdBits = 5L;
    private long datacenterIdBits = 5L;
    // 每毫秒内产生的id数 2^12次方
    private long sequenceBits = 12L;
    private long maxWorkerId = -1L ^ (-1L << workIdBits);
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workIdBits;
    private long timestampLeftShift = sequenceBits + workIdBits + datacenterIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

}
