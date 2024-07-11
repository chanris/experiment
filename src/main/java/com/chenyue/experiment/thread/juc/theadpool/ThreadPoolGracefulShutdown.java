package com.chenyue.experiment.thread.juc.theadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/11
 * @description 测试线程池的关闭
 * 两种方式，每种关闭都有不同的效果
 * 1.shutdown
 * 2.shutdownNow
 *
 * 线程池提交任务execute 和 submit 的不同
 * execute 会直接提交 Runnable实现的类，作为Thread的 target
 * submit 会把 实现Runnable接口的类，装载到FutureTask,
 * 所以当线程池shutdownNow是返回的是List<FutureList>,而不是List<自定义的Task>！！
 */
public class ThreadPoolGracefulShutdown {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        shutdown_test();
//        shutdownNow_test();
    }

    private static void shutdownNow_test() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 10; i++) {
            try {
                threadPool.execute(new Task(i));
            }catch (Exception e) {
                System.out.println("rejected, task-" + i);
            }
            if(i == 5) {
                List<Runnable> tasks = threadPool.shutdownNow();
                for (Runnable task : tasks) {
                    if (task instanceof Task) {
                        System.out.println("waiting task:" + ((Task) task).getName());
                    }
                }
            }
        }
    }

    private static void shutdown_test() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 10; i++) {
            System.out.println("第：" + i + " 提交任务");
            threadPool.execute(new Task(i));
            if (i==5) {
                threadPool.shutdown(); // 关闭任务提交接口，等待已提交和正在运行的任务都执行完毕才关闭线程池。
            }
        }
        System.out.println("Main Threads execute statement.");

    /*    try {
            boolean isStop = threadPool.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("is pool isStop: " + isStop);
            System.out.println(Thread.currentThread().getName() + "111111111111111");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------------");
        System.out.println(Thread.currentThread().getName()+ " mission is over");
        System.out.println();*/

    }

    // 参考jdk文档
    public static void finalOK_shutdownAndAwaitTermination(ExecutorService threadPool) {
        if (threadPool == null || threadPool.isShutdown()) return;
        threadPool.shutdown(); // 禁止新任务提交到线程池
        try {
            // 等待一段时间，让已存在的任务执行完毕
            // awaitTermination 规定时间内返回true，超过时间返回false，可能抛出InterruptedException
            if(!threadPool.awaitTermination(120, TimeUnit.SECONDS)) {
                threadPool.shutdownNow(); // 等待超时，尝试关闭已存在的任务
                if (!threadPool.awaitTermination(120, TimeUnit.SECONDS)) { // 在任务被取消后等待一段时间才作出反应
                    System.out.println("Thread Pool not terminate.");
                }
            }
        }catch (InterruptedException e) {
            // 如果当前线程也被打断，则重新关闭
            threadPool.shutdown();
            // 保存 当前线程的 中断状态
            Thread.currentThread().interrupt();
        }
    }

    static class Task implements Runnable {
        String name = "";

        public Task(int i) {
            name = "task-" + i;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("sleep completed, " + getName());
            }catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println("interrupted, " + getName());
                return;
            }
            System.out.println(getName() + " finished");
            System.out.println();
        }
    }
}
