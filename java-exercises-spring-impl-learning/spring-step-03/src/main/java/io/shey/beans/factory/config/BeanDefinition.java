package io.shey.beans.factory.config;


/**
 * @Project: spring-implement-learning
 * @File: BeanDefinition.java
 * @PACKAGE_NAME: io.shey.beans.factory.config
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: BeanDefinition.java
 **/
public class BeanDefinition {
    private Class beanClass; // 私有Bean类

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
