package com.chenyue.experiment.os.enums;

/**
 * @author chenyue7@foxmail.com
 */
public enum  PcbState {
    RUNNABLE(1),
    TERMINATED(0);

    private final int value;

    PcbState(Integer value) {
        this.value  = value;
    }

    public Integer getValue() {
        return value;
    }

    public static boolean isRunnable(int value){
        return value == RUNNABLE.value;
    }

    public static boolean isTerminated(int value){
        return value == TERMINATED.value;
    }
}
