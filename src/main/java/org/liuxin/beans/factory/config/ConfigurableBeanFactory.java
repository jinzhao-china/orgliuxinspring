package org.liuxin.beans.factory.config;

import org.liuxin.beans.factory.BeanFactory;

/**
 * Created by zjin010 on 6/18/18.
 */
public interface ConfigurableBeanFactory extends BeanFactory{
    void setBeanClassLoader(ClassLoader beanClassLoader);
    ClassLoader getBeanClassLoader();
}
