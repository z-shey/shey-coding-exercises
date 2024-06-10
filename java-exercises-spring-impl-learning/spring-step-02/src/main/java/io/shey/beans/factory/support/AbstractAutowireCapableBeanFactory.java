package io.shey.beans.factory.support;

import io.shey.beans.BeansException;
import io.shey.beans.factory.config.BeanDefinition;

/**
 * @Project: spring-implement-learning
 * @File: AbstractAutowireCapableBeanFactory.java
 * @PACKAGE_NAME: io.shey.beans.factory.support
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: AbstractAutowireCapableBeanFactory.java
 **/
public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 创建bean
     * @param beanName bean的名称
     * @return bean对象
     * @throws BeansException BeansException
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = getBeanDefinition(beanName);

        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }

        return beanDefinition;
    }

    /**·
     * 创建bean
     * @param beanName bean的名称
     * @param beanDefinition bean的定义信息
     * @return bean对象
     * @throws BeansException BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;

        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        registerSingleton(beanName, bean);

        return bean;
    }
}
