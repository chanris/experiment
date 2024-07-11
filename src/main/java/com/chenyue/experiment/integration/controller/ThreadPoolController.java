package com.chenyue.experiment.integration.controller;

import com.chenyue.experiment.integration.util.TaskBatchSendUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/11
 * @description 测试spring 线程池
 */
@RestController
public class ThreadPoolController {

    @Resource
    private ThreadPoolTaskExecutor threadPool;

    @RequestMapping("testThreadPool")
    String test() {
        List<String> coupons = getCoupons();
        long startTime = System.currentTimeMillis();
        try {
            TaskBatchSendUtils.send(coupons, threadPool, TaskBatchSendUtils::disposeTask);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success";
    }

    private List<String> getCoupons() {
        List<String> coupons = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            coupons.add("优惠卷-" + i);
        }
        return coupons;
    }
}
