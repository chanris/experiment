package com.chenyue.experiment.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/22
 * @description
 * Future 用于表示异步任务的结果
 * get(): 获取异步任务的结果，若任务此时还没有完成，会一直阻塞直到任务的完成，并返回结果
 * get(long timeout, TimeUnit unit)： 限时等待
 * isDone(): 检查任务是否完成
 * isCancelled(): 检查任务是否取消
 * cancel(boolean mayInterruptIfRunning) 取消任务，mayInterruptIfRunning 决定是否中断正在执行的任务
 */
public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyAsyncTask task = new MyAsyncTask();
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future, "callable Thread 01").start();
        TimeUnit.SECONDS.sleep(2);
        if (future.isDone()) {
            System.out.println("任务已结束");
        }else {
            System.out.println("任务正在执行中...已运行时间：" + 2 + "秒");
        }
        String s = future.get();// 阻塞获得异步任务返回值
        System.out.println("异步任务结果：" + s);
    }



    private static class MyAsyncTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            // mock task running
            TimeUnit.SECONDS.sleep(10);
            return "Mission completed!";
        }
    }
}
