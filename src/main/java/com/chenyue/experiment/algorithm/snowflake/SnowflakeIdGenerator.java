package com.chenyue.experiment.algorithm.snowflake;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/3/17
 * @description 分布式雪花算法
 */
public class SnowflakeIdGenerator  {
    // 开始时间戳 (2024-01-01)
    private final long twepoch = 1704067200000L;
    // 机器ID所占的位数
    private final long workerIdBits = 5L;
    // 数据中心ID所占的位数
    private final long datacenterIdBits = 5L;
    // 支持的最大机器ID
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 支持的最大数据中心ID
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    // 序列在ID中占的位数
    private final long sequenceBits = 12L;
    // 机器ID向左移12位
    private final long workerIdShift = sequenceBits;
    // 数据中心ID向左移17位
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    // 时间戳向左移22位
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    // 生成序列的掩码
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowflakeIdGenerator(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

}
