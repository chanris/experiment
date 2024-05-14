package com.chenyue.experiment.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author chenyue7@foxmail.com
 * @date 13/5/2024
 * @description
 * 测试 CompletableFuture 的使用。
 * CompletableFuture 是一个包含异步任务结果的容器，可以用于异步任务的管理和组合。
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Object> someJobFuture = new CompletableFuture<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000 * 3);
                    someJobFuture.complete("This is a response message.");
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Object o = someJobFuture.get();
        System.out.println((String) o);
    }
}
