package io.shey.beans.factory.support;

import io.shey.beans.BeansException;
import io.shey.beans.factory.BeanFactory;
import io.shey.beans.factory.config.BeanDefinition;

/**
 * @Project: spring-implement-learning
 * @File: AbstractBeanFactory.java
 * @PACKAGE_NAME: io.shey.beans.factory.support
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: AbstractBeanFactory.java 继承DefaultSingletonBeanRegistry，实现BeanFactory
 **/
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    /**
     * 获取bean
     * @param beanName bean的名称
     * @return bean实例
     */
    @Override
    public Object getBean(String beanName) throws BeansException {
        Object bean = getSingleton(beanName);

        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    /**
     * 获取bean的定义信息
     * @param beanName bean的名称
     * @return bean的定义信息
     * @throws BeansException BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建bean实例
     * @param beanName bean的名称
     * @param beanDefinition bean的定义信息
     * @return bean实例
     * @throws BeansException BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
