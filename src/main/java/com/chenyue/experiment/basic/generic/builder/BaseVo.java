package com.chenyue.experiment.basic.generic.builder;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/19
 */
public class BaseVo <T> {
    private Integer code;
    private String msg;
    private T data;

    private static BaseVo instance;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
