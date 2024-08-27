package com.chenyue.experiment.integration;

import com.chenyue.experiment.integration.annotation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author chenyue7@foxmail.com
 * @date 2024/7/3
 * @description
 */
//@EnableRpc
@SpringBootApplication
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
