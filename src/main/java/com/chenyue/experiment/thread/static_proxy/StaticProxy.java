package com.chenyue.experiment.thread.static_proxy;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/18
 * 静态代理，需要实现被代理的对象的接口
 * 加强代理的接口方法
 *
 */
public class StaticProxy {
    public static void main(String[] args) {
        /*new Thread(()->{}).start();*/
        new WeddingCompany(new You()).happyMarry();
    }
}
interface Marry {
    void happyMarry();
}

class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("Xxx结婚了...");
    }
}

class WeddingCompany implements Marry{
    // 被代理的对象，要和代理对象实现同一个接口
    private Marry target;
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void happyMarry() {
        // 代理之前加强
        before();
        target.happyMarry();
        after();
        // 代理之后加强
    }
    private void before(){
        System.out.println("代理之前加强处理");
    }
    private void after(){
        System.out.println("代理之后加强处理");
    }
}
