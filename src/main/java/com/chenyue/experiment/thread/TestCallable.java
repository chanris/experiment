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
public class TestCallable implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        System.out.println("callable线程执行....");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建job线程
        TestCallable t1 = new TestCallable();
        TestCallable t2 = new TestCallable();
        TestCallable t3 = new TestCallable();

        //创建执行服务
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
        executorService.shutdown();
    }
}
