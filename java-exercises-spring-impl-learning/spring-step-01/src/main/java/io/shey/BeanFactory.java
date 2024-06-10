package io.shey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Project: spring-implement-learning
 * @File: BeanFactory.java
 * @PACKAGE_NAME: io.shey
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: BeanFactory.java 负责Bean的创建和获取，现在包括注册和获取
 **/
public class BeanFactory {
    // 使用ConcurrentHashMap来存储BeanDefinition，保证线程安全
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 注册BeanDefinition
     *
     * @param name BeanDefinition的名称
     * @return 返回BeanDefinition Bean对象
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 注册BeanDefinition
     *
     * @param name           BeanDefinition的名称
     * @param beanDefinition BeanDefinition对象
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}