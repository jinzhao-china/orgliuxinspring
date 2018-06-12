package org.liuxin.beans.factory;

import org.liuxin.beans.BeanDefinition;

/**
 * Created by zjin010 on 6/11/18.
 */
public interface BeanFactory {

    BeanDefinition getBeanDefinition(String beanId);

    Object getBean(String petStore);
}
