package org.liuxin.beans.factory.support;

import org.liuxin.beans.factory.config.SingletonBeanRegistry;

/**
 * Created by zjin010 on 6/18/18.
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    public void registerSingleton(String beanName, Object singletonObject) {

    }

    public Object getSingleton(String beanName) {
        return null;
    }
}
