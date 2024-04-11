package com.chenyue.experiment.klass.loader;

/**
 * @author chenyue7@foxmail.com
 * @date 2020/08/31
 *
 * java类 主动加载的情况
 * 创建类的实例
 * 访问某个类或者接口的静态变量,或者对该类静态变量赋值
 * 调用类的静态方法
 * 反射Class.forName("xxx")
 * 初始化一个类的子类
 * 启动类(有main,且被jvm标记为启动类)
 *
 * 子类对象调用父类静态变量不会加载子类,只能加载父类
 */
public class F {
    public static void main(String[] args) {

        // 类.class 不会加载该类
        System.out.println(A.class);
//        A.load();
//        try {
//            Class.forName("io.cyt.loader.A");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}
