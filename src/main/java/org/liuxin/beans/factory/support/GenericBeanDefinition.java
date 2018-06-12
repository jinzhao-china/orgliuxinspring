package org.liuxin.beans.factory.support;

import org.liuxin.beans.BeanDefinition;

/**
 * Created by zjin010 on 6/11/18.
 */
public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String beanClassName;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    public String getBeanClassName() {
        return this.beanClassName;
    }
}
