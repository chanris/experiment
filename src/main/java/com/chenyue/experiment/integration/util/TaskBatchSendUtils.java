package com.chenyue.experiment.integration.util;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/11
 * @description 多线程批发任务工具类
 */
public class TaskBatchSendUtils {

    public static <T> void send(List<T> taskList, Executor threadPool, Consumer<? super T> consumer) throws InterruptedException {
        if (taskList == null || taskList.isEmpty()) return;
        if (Objects.isNull(consumer)) return;

        CountDownLatch countDownLatch = new CountDownLatch(taskList.size());
        for (T couponOrShortMsg : taskList) {
            threadPool.execute(()->{
                try {
                    consumer.accept(couponOrShortMsg);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
    }

    public static void disposeTask(String task) {
        System.out.printf("【%s】disposeTask下发优惠卷或短信成功\n", task);
    }
}
