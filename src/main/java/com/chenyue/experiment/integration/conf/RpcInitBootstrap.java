package com.chenyue.experiment.integration.conf;

import com.chenyue.experiment.integration.annotation.EnableRpc;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author chenyue7@foxmail.com
 * @date 2024/8/26
 * @description
 * ImportBeanDefinitionRegistrar是一个接口，允许我们在@Configuration类中动态注册额外的Bean定义。通过实现这个接口，我们可以在运行时
 * 根据需要灵活地向Spring 容器添加组件。
 * 通过@Import(RpcInitBootstrap.class)，将Configuration类的元数据获得
 */
public class RpcInitBootstrap implements ImportBeanDefinitionRegistrar {
    // 执行一次
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean o = (boolean) importingClassMetadata.getAnnotationAttributes(EnableRpc.class.getName()).get("flag");
        System.out.println("Bean： " + importingClassMetadata.getClassName() + " has annotation: " + EnableRpc.class.getName());
        for(String s : importingClassMetadata.getAnnotationTypes()) {
            System.out.println(s);
        }
    }
}
