package com.chenyue.experiment.designpattern.behaviorpattern.chainofresponse;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/2
 * @description 补充订单信息
 */
public class OrderFill extends Handler {

    @Override
    protected boolean process(OrderInfo orderInfo) {
        System.out.println("补充订单信息");
        return handler.process(orderInfo);
    }
}
