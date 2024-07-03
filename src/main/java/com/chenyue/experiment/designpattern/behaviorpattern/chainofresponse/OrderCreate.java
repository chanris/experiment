package com.chenyue.experiment.designpattern.behaviorpattern.chainofresponse;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/2
 * @description 创建订单
 */
public class OrderCreate extends Handler{

    @Override
    protected boolean process(OrderInfo orderInfo) {
        System.out.println("创建订单");
        return true;
    }
}
