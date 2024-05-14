package com.chenyue.experiment.basic.enums;

import java.util.Arrays;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/19
 */
/*
  javap Season.class
  public final class com.chenyue.enums.Season extends java.lang.Enum<com.chenyue.enums.Season> {
  public static final com.chenyue.enums.Season SPRING;
  public static final com.chenyue.enums.Season SUMMER;
  public static final com.chenyue.enums.Season AUTUMN;
  public static final com.chenyue.enums.Season WINTER;
  public static com.chenyue.enums.Season[] values();
  public static com.chenyue.enums.Season valueOf(java.lang.String);
  static {};
}
*/
/*
    Java Enumeration Structure
java.lang.Enum<>  Comparable<E>, Serializable

*/

public enum Season {
    SPRING(1,"春天"),
    SUMMER(2,"夏天"),
    AUTUMN(3,"秋天"),
    WINTER(4,"冬天");
    private final Integer code;
    private final String msg;

    Season(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

    public static void main(String[] args) {
        System.out.println(SPRING.name());
        System.out.println(SPRING.toString());
        System.out.println(SPRING.ordinal());
        System.out.println(Season.valueOf("SPRING")); /*传大写name*/
        System.out.println(Arrays.toString(Season.values()));
        System.out.println(Season.WINTER.getMsg());
    }
}
