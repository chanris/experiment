package com.chenyue.experiment.designpattern.strcuturepattern.proxy.simpleproxy;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description 代理对象
 */
public class ProxySubject implements Subject{

    private RealSubject realSubject;

    @Override
    public void request() {
        // 在转发请求前，可以做一些额外处理，比如权限检查、缓存、记录日志等。
        System.out.println("ProxySubject: Preprocessing before forwarding the request.");

        // 转发请求给真实对象
        realSubject.request();

        // 请求后可以做一些附加处理
        System.out.println("ProxySubject: Postprocessing after forwarding the request.");
    }

}
