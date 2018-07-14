package org.liuxin.beans.factory.support;

import org.liuxin.beans.BeanDefinition;
import org.liuxin.beans.factory.BeansCreationException;
import org.liuxin.beans.factory.config.ConfigurableBeanFactory;
import org.liuxin.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zjin010 on 6/11/18.
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory, BeanDefinitionRegistry {

    public final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public DefaultBeanFactory(){

    }

    public Object getBean(String beanId) {
        BeanDefinition bd = this.getBeanDefinition(beanId);

        if (bd == null) {
            throw new BeansCreationException("Bean Definition does not exist");
        }

        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();
        try {
            Class<?> clz = cl.loadClass(beanClassName);
            return clz.newInstance();
        } catch (Exception e) {
           throw new BeansCreationException("Bean Definition does not exist");
        }
    }

    public void registerBeanDefinition(String beanId, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanId, bd);
    }

    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {

    }

    public ClassLoader getBeanClassLoader() {
        return null;
    }
}
