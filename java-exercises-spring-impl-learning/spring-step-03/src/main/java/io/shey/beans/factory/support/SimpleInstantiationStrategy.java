package io.shey.beans.factory.support;

import io.shey.beans.BeansException;
import io.shey.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Project: spring-implement-learning
 * @File: SimpleInstantiationStrategy.java
 * @PACKAGE_NAME: io.shey.beans.factory.support
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-25
 * @Modified: 2024-05-25
 * @Description: SimpleInstantiationStrategy.java
 **/
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    /**
     * 实例化Bean对象
     * @param beanDefinition BeanDefinition
     * @param beanName BeanName
     * @param constructor 获取与入参信息相对应的构造函数
     * @param args 具体的入参信息，实例化对象时会使用到
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        // 先通过BeanDefinition Class 信息，Class 信息是在定义 Bean 时传递进去的
        try {
            // 如果构造器不为空，则需要传递构造函数的入参信息进行实例化，就是将入参信息传递给newInstace进行实例化
            if (constructor != null) {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                // 如果构造器为空，则无构造函数可实例化
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
