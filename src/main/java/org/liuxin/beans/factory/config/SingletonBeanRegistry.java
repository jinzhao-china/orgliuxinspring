package org.liuxin.beans.factory.config;

/**
 * Created by zjin010 on 6/18/18.
 */
public interface SingletonBeanRegistry {
    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);
}
