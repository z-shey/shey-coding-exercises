package io.shey.beans.factory;

import io.shey.beans.BeansException;

/**
 * @Project: spring-implement-learning
 * @File: BeanFactory.java
 * @PACKAGE_NAME: io.shey.beans.factory
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: BeanFactory.java bean工厂
 **/
public interface BeanFactory {
    /**
     * 获取Bean
     * @param beanName bean的名称
     * @return bean实例
     */
    Object getBean(String beanName) throws BeansException;;
}
