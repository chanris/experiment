package com.chenyue.experiment.designpattern.behaviorpattern.chainofresponse;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/2
 * @description
 */
public abstract class Handler {

    protected Handler handler;
    public void setNext(Handler handler) {
        this.handler = handler;
    }

    protected abstract boolean process(OrderInfo orderInfo);
}
