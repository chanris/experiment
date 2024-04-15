package com.chenyue.experiment.designpattern.strcuturepattern.proxy.simpleproxy;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class Client {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Subject proxy = new RealSubject();
        proxy.request();
    }
}
