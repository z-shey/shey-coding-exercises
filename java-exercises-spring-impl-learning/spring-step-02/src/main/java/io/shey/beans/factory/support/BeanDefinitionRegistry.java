package io.shey.beans.factory.support;

import io.shey.beans.factory.config.BeanDefinition;

/**
 * @Project: spring-implement-learning
 * @File: BeanDefinitionRegidtry.java
 * @PACKAGE_NAME: io.shey.beans.factory.support
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: BeanDefinitionRegidtry.java
 **/
public interface BeanDefinitionRegistry {
    /**
     * 注册BeanDefinition
     * @param beanName bean名称
     * @param beanDefinition BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
