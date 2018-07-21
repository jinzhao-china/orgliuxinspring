package org.liuxin.beans.factory.support;

/**
 * Created by zjin010 on 7/20/18.
 */

import org.liuxin.beans.factory.BeanFactory;
import org.liuxin.beans.factory.config.RuntimeBeanReference;
import org.liuxin.beans.factory.config.TypedStringValue;

public class BeanDefinitionValueResolver {
    private final BeanFactory beanFactory;

    public BeanDefinitionValueResolver(
            BeanFactory beanFactory) {

        this.beanFactory = beanFactory;
    }

    public Object resolveValueIfNecessary(Object value) {

        if (value instanceof RuntimeBeanReference) {
            RuntimeBeanReference ref = (RuntimeBeanReference) value;
            String refName = ref.getBeanName();
            Object bean = this.beanFactory.getBean(refName);
            return bean;

        }else if (value instanceof TypedStringValue) {
            return ((TypedStringValue) value).getValue();
        } else{
            //TODO
            throw new RuntimeException("the value " + value +" has not implemented");
        }
    }
}
