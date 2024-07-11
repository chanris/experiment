package com.chenyue.experiment.thread.juc.theadpool;

import java.util.concurrent.*;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/11
 * @description 关于线程池异常的测试
 */
@SuppressWarnings("all")
public class ThreadPoolExceptionTest {
    public static void main(String[] args) {
//        defaultSubmit();
//        defaultSubmitAndGet();
        defaultExecute();
       //  ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(6); //ArrayBlockingQueue强制有界
    }

    private static void defaultSubmit() {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        try {
            // 默认调用submit会吞掉异常
            threadPool.submit(()->{
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中submit方法--start");
                for (int i = 1; i <= 4; i++) {
                    if (i==3) {
                        int age = 10 / 0;
                    }
                    System.out.println("----come in execute: " +i);
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中submit方法--end");
            });
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    /**
     * submit执行后，如果get方法调用想要获得返回值，会抛出异常
     */
    private static void defaultSubmitAndGet() {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        try {

            Future<?> task = threadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中submit方法--start");
                for (int i = 1; i <= 4; i++) {
                    if (i == 3) {
                        int age = 10 / 0;
                    }
                    System.out.println("----come in execute: " + i);
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中submit方法--end");
            });
            task.get();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    private static void defaultExecute() {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        try {
            // 默认调用execute会抛出异常
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中execute方法--start");
                for (int i = 1; i <= 4; i++) {
                    if (i==3) {
                        int age = 10 / 0;
                    }
                    System.out.println("----come in execute: " +i);
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中execute方法--end");
            });
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    private static void handleException() {
        ExecutorService threadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() * 2,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(100)) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                if (t == null &&
                r instanceof Future<?>
                && ((Future<?>)r).isDone()) {
                    try {
                        Object result = ((Future<?>)r).get();
                    }catch (CancellationException ce) {
                        t = ce;
                    }catch (ExecutionException ee) {
                        t = ee.getCause();
                    }catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (t != null) {
                    System.out.println(t);
                }
            }
        };
    }
}
