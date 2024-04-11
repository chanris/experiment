package com.chenyue.experiment.os.enums;

/**
 * @author chenyue7@foxmail.com
 */
public enum PriorityEnum {
    MAX_PRIORITY(0),
    HIGHEST_PRIORITY(1),
    HIGHER_PRIORITY(2),
    HIGH_PRIORITY(3),
    MEDIUM_PRIORITY(4),
    LOW_PRIORITY(5),
    LOWER_PRIORITY(6),
    LOWEST_PRIORITY(7),
    MIN_PRIORITY(8);


    private final Integer value;

    PriorityEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue(){
        return this.value;
    }

    public boolean isMaxPriority(int value){
        return value == MAX_PRIORITY.value;
    }

    public boolean isHighPriority(int value){
        return value == HIGH_PRIORITY.value;
    }

    public boolean isMediumPriority(int value){
        return value == MEDIUM_PRIORITY.value;
    }

    public boolean isLowPriority(int value){
        return value == LOW_PRIORITY.value;
    }

    public boolean isMinPriority(int value){
        return value == MIN_PRIORITY.value;
    }
}
