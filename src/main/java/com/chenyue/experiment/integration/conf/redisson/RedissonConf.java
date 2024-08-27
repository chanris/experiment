package com.chenyue.experiment.integration.conf.redisson;

import com.chenyue.experiment.integration.annotation.EnableRpc;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/3
 * @description
 */
@EnableRpc
@Configuration
public class RedissonConf {

    /**
     * 配置redisson
     */
    @Bean
    RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("redis123");
        return Redisson.create(config);
    }
}
