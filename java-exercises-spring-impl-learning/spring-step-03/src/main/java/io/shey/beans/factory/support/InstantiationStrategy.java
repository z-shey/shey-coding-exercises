package io.shey.beans.factory.support;

import io.shey.beans.BeansException;
import io.shey.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Project: spring-implement-learning
 * @File: InstantiationStrategy.java
 * @PACKAGE_NAME: io.shey.beans.factory.support
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-25
 * @Modified: 2024-05-25
 * @Description: InstantiationStrategy.java 实例化策略接口
 **/
public interface InstantiationStrategy {
    /**
     * 实例化策略接口
     * @param beanDefinition BeanDefinition
     * @param beanName BeanName
     * @param constructor 获取与入参信息相对应的构造函数
     * @param args 具体的入参信息，实例化对象时会使用到
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;
}
