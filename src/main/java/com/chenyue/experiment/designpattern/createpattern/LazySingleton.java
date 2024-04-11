package com.chenyue.experiment.designpattern.createpattern;

/**
 * @author chenyue7@foxmail.com
 *
 * volatile:一个线程修改了这个变量，其他线程能够立即看得见修改的值
 */
public class LazySingleton {
    private static volatile LazySingleton instance; // 保证instance在所有进程中同步
    private LazySingleton(){} // 私有构造器

    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
