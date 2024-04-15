package com.chenyue.experiment.designpattern.strcuturepattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 */
public class ServiceInvocationHandler implements InvocationHandler {
    private final IService service;

    public ServiceInvocationHandler(IService service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在实际方法调用前你可以添加自己的操作
        System.out.println("Performing some operations before invoking serve");

        // 调用实际方法
        Object result = method.invoke(service, args);

        // 在实际方法调用后你可以添加自己的操作
        System.out.println("Performing some operations after invoking serve");

        return result;
    }
}
