package io.shey.beans.factory.config;

/**
 * @Project: spring-implement-learning
 * @File: SingletonBeanRegistry.java
 * @PACKAGE_NAME: io.shey.beans.factory.config
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: SingletonBeanRegistry.java 单例模式的Bean注册接口
 **/
public interface SingletonBeanRegistry {

    /**
     * 获取单例Bean
     *
     * @param beanName bean的名称
     * @return 单例Bean
     */
    Object getSingleton(String beanName);

    /**
     * 注册单例Bean
     *
     * @param beanName        bean的名称
     * @param singletonObject 单例Bean
     */
    void registerSingleton(String beanName, Object singletonObject);
}
