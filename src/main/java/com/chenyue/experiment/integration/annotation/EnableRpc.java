package com.chenyue.experiment.integration.annotation;

import com.chenyue.experiment.integration.conf.BeanHandler;
import com.chenyue.experiment.integration.conf.RpcInitBootstrap;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/26
 * @description
 */
@Target({ElementType.TYPE})         // 该注解的作用范围
@Retention(RetentionPolicy.RUNTIME) // 运行时保留注解
@Import({BeanHandler.class, RpcInitBootstrap.class}) // 引入额外的Bean
public @interface EnableRpc {
    boolean flag() default false;
}
