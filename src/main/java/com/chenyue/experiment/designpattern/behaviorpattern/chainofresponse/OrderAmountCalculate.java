package com.chenyue.experiment.designpattern.behaviorpattern.chainofresponse;

import java.util.Random;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/2
 * @description 订单算价
 */
public class OrderAmountCalculate extends Handler{

    @Override
    protected boolean process(OrderInfo orderInfo) {
        System.out.println("订单算价");
        boolean ans = new Random().nextInt(0, 10) % 2 == 0;
        return ans && handler.process(orderInfo);
    }
}
