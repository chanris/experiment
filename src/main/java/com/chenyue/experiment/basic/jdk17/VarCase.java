package com.chenyue.experiment.basic.jdk17;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/9/18
 * @description
 * JDK 10引入的 var 关键字，用来声明变量，可以省略类型声明，
 * 编译器会根据上下文自动推导出变量的类型
 */
public class VarCase {
    public static void main(String[] args) {
        var s = "Hello, World!";
        System.out.println(s);
        Object obj = new Object();
    }
}
