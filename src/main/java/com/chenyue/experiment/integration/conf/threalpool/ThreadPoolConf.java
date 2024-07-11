package com.chenyue.experiment.integration.conf.threalpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/11
 * @description
 *
 */
@Configuration
public class ThreadPoolConf {

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        threadPool.setMaxPoolSize(Runtime.getRuntime().availableProcessors() * 2);
        threadPool.setQueueCapacity(50);
        threadPool.setThreadNamePrefix("Async-");
        threadPool.initialize();
        return threadPool;
    }
}
