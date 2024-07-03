package com.chenyue.experiment.designpattern.behaviorpattern.chainofresponse;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/2
 * @description 执行责任链
 */
public class Test {
    public static void main(String[] args) {
        Handler orderValidation = new OrderValidation();
        Handler orderFill = new OrderFill();
        Handler orderAmountCalculate = new OrderAmountCalculate();
        Handler orderCreate = new OrderCreate();

        //设置责任链
        orderValidation.setNext(orderFill);
        orderFill.setNext(orderAmountCalculate);
        orderAmountCalculate.setNext(orderCreate);


        //开始执行
        boolean process = orderValidation.process(new OrderInfo());
        System.out.println("结果:" + process);
    }
}
