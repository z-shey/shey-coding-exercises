package io.shey.beans.factory.support;

import io.shey.beans.BeansException;
import io.shey.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

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
    private InstantiationStrategy instantiationStrategy = new CglibSubclassInstantiationStrategy();

    /**
     * 创建bean
     *
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

    /**
     * 创建bean
     *
     * @param beanName       bean的名称
     * @param beanDefinition bean的定义信息
     * @return bean对象
     * @throws BeansException BeansException
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;

        try {
            bean = createBeanInstance(beanName, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        registerSingleton(beanName, bean);
        return bean;
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        Object bean = null;

        try {
            bean = createBeanInstance(beanName, getBeanDefinition(beanName), args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        registerSingleton(beanName, bean);

        return bean;
    }

    protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object... args) throws BeansException {
        Constructor constructorToUse = null;

        // 获取类
        Class<?> beanClass = beanDefinition.getBeanClass();

        // 获取构造函数
        Constructor<?>[] defaultConstructors = beanClass.getDeclaredConstructors();

        // 遍历构造函数
        for (Constructor<?> constructor : defaultConstructors) {
            if (args != null && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }


    protected InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
