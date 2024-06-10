package io.shey.beans.factory.support;

import io.shey.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: spring-implement-learning
 * @File: DefaultSingletonBeanRegistry.java
 * @PACKAGE_NAME: io.shey.beans.factory.support
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: DefaultSingletonBeanRegistry.java 默认的单例注册器
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    // 单例池
    private Map<String, Object> singletonObject = new HashMap<>();

    /**
     * 获取单例对象
     * @param beanName bean的名称
     * @return 单例对象
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObject.get(beanName);
    }

    /**
     * 注册单例对象
     * @param beanName        bean的名称
     * @param singletonObject 单例Bean
     */
    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        this.singletonObject.put(beanName, singletonObject);
    }
}
