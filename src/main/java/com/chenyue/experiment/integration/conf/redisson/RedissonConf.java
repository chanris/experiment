package com.chenyue.experiment.integration.conf.redisson;

import com.chenyue.experiment.integration.annotation.EnableRpc;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/3
 * @description Redisson配置信息
 */
@EnableRpc
@Configuration

public class RedissonConf {

    @Value("${spring.data.redis.host}")
    private String host;
    @Value("${spring.data.redis.port}")
    private String port;
    @Value("${spring.data.redis.password}")
    private String password;

    /**
     * 配置redisson
     */
    @Bean
    RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress(String.format("redis://%s:%s", host, port)).setPassword(password);
        return Redisson.create(config);
    }
}
