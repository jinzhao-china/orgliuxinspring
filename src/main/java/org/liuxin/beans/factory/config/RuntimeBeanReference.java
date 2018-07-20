package org.liuxin.beans.factory.config;

/**
 * Created by zjin010 on 7/19/18.
 */
public class RuntimeBeanReference {
    private final String beanName;
    public RuntimeBeanReference(String beanName) {
        this.beanName = beanName;
    }
    public String getBeanName() {
        return this.beanName;
    }
}
