package com.chenyue.experiment.integration.conf;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/26
 * @description
 */
public class BeanHandler implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("bean:" + bean);
//        System.out.println("beanName:" + beanName);
        return bean;
    }
}
