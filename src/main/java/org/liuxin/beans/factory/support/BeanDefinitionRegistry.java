package org.liuxin.beans.factory.support;

import org.liuxin.beans.BeanDefinition;

/**
 * Created by zjin010 on 6/18/18.
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanId, BeanDefinition id);
    BeanDefinition getBeanDefinition(String beanId);
}
