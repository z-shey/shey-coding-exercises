package io.shey;

/**
 * @Project: spring-implement-learning
 * @File: BeanDefinition.java
 * @PACKAGE_NAME: io.shey
 * @Version: 1.0.0
 * @Author: 轩祎SheyZhang
 * @Created: 2024-05-22
 * @Modified: 2024-05-22
 * @Description: BeanDefinition.java Bean对象
 **/
public class BeanDefinition {
    private Object bean; // 私有Bean对象

    /**
     * 构造方法
     *
     * @param bean Bean对象
     */
    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    /**
     * 获取Bean对象
     *
     * @return Bean对象
     */
    public Object getBean() {
        return bean;
    }
}