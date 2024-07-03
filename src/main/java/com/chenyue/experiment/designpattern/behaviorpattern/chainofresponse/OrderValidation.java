package com.chenyue.experiment.designpattern.behaviorpattern.chainofresponse;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/2
 * @description 校验订单信息
 */
public class OrderValidation extends Handler{

    @Override
    protected boolean process(OrderInfo orderInfo) {
        System.out.println("校验订单基本信息");
        return handler.process(orderInfo);
    }
}
