package com.chenyue.experiment.designpattern.strcuturepattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author chenyue7@foxmail.com
 * @date 11/4/2024
 * @description
 *
 * 代理的意思是隐藏方法的实现，实现对方法的包装、代理。
 *
 * jdk动态代理只能代理接口，不能直接代理类？
 * 1. Java单继承限制，由于JDK动态代理原理是在运行时创建一个新的代理类，它已经继承了Proxy类，所以它不能再去继承其他类。
 * 但是，一个类可以实现多个接口，因此动态代理可以不受限制地实现任意数量的接口。
 * 2. 保证简单：代理接口而不是类可以保持代理机制的简单性和一致性。代理一个类可能涉及到复杂的继承层次和状态继承问题，而代理接口可以避免这些复杂性，因为接口只定义行为，不维护状态。
 * 3. 鼓励面向接口编程： JDK动态代理的这种限制鼓励开发者编写更加模块化、更易于维护和测试的代码。
 * 4. 安全和清晰： 这种设计也符合接口和实现分离的原则，在不暴露实际对象内部实现的情况下，只需要对外提供接口服务。
 *
 * cglib动态代理可以代理类， 它是通过使用ASM框架操作字节码，直接在字节码上进行修改，达到动态代理的效果。
 */
public class Test {
    public static void main(String[] args) {
        // 创建实际对象实例
        IService realService = new ServiceImpl();

        // 创建InvocationHandler实例
        InvocationHandler handler = new ServiceInvocationHandler(realService);

        // 创建代理实例
        IService proxyService = (IService) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                new Class[]{IService.class},
                handler); // 创建代理类

        // 调用代理实例上的方法
        proxyService.serve();
    }
}
