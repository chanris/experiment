package com.chenyue.experiment.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chenyue7@foxmail.com
 * @date 8/5/2024
 * @description InvocationHandler 代理对象实例
 * 被代理对象作为属性保留在代理对象中，
 * 代理对象继承InvocationHandler,实现 invoke方法。
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object object;
    public MyInvocationHandler(Object realObject) {
        this.object = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method execution");
        Object result = method.invoke(object, args);
        System.out.println("After method execution");
        return result;
    }

    public static void main(String[] args) {
        UserService userService = new UserService() {
            @Override
            public void getUserInfo() {
                System.out.println("Real object is doing something.");
            }
        };

        UserService proxy = (UserService) Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(),
                new Class[]{UserService.class}, new MyInvocationHandler(userService));

        // 调用代理对象的方法
        proxy.getUserInfo();
    }
}
