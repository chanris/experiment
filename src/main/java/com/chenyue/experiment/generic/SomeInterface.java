package com.chenyue.experiment.generic;

/**
 * @author chenyue7@foxmail.com
 * @date 24/4/2024
 * @description
 */
public interface SomeInterface {

    /**
     * since jdk 1.8
     * 接口可以拥有静态方法，封装等级 public
     * 只能通过接口名 调用
     */
    static void IStaticMethod (){
        System.out.println("call static method of a interface");
    }

    /**
     * since jdk 1.8
     * 接口可以拥有默认方法， default
     * 实现类可以重写该方法， 通过实例的this调用默认方法
     */
    default void IDefaultMethod() {
        System.out.println("call default method of a interface");
    }
}
