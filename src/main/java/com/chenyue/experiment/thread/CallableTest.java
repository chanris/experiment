package com.chenyue.experiment.thread;

import java.util.concurrent.*;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/17
 *d
 * callable
 * 1. 可以定义返回值
 * 2. 可以抛出异常
 *
 */
public class CallableTest implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        Thread.sleep(3 * 1000);
        System.out.println("callable线程执行....");
        return true;
    }

    public static void main(String[] args) throws Exception {
        // 创建job线程
        CallableTest t1 = new CallableTest();
        CallableTest t2 = new CallableTest();
        CallableTest t3 = new CallableTest();

       /* //创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = executorService.submit(t1);
        Future<Boolean> r2 = executorService.submit(t2);
        Future<Boolean> r3 = executorService.submit(t3);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        executorService.shutdown();*/
        FutureTask<Boolean> task = new FutureTask<>(t1);
        new Thread(task, "callable Thread 01").start();

        Boolean b = task.get();// 阻塞
        System.out.println(b);
    }
}
