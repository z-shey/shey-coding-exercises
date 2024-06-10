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
     *
     * @param beanName bean的名称
     * @return bean实例
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 获取Bean
     * @param beanName bean的名称
     * @param args 构造函数的参数,编译器会把这个形参转化为一个数组形参，并在编译出的class文件里作上一个记号，表明这是个实参个数可变的方法。
     * @return bean实例
     * @throws BeansException
     */
    Object getBean(String beanName, Object... args) throws BeansException;
}
