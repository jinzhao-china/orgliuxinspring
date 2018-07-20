package org.liuxin.context.support;

import org.liuxin.beans.context.ApplicationContext;
import org.liuxin.beans.factory.support.DefaultBeanFactory;
import org.liuxin.beans.factory.xml.XmlBeanDefinitionReader;
import org.liuxin.core.io.Resource;
import org.liuxin.util.ClassUtils;

/**
 * Created by zjin010 on 6/18/18.
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    private DefaultBeanFactory factory = null;
    private ClassLoader beanClassLoader = null;

    public AbstractApplicationContext(String configFile){
        factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = this.getResourceByPath(configFile);
        reader.loadBeanDefinitions(resource);

        factory.setBeanClassLoader(this.getBeanClassLoader());
    }

    public Object getBean(String beanId) {
        return this.factory.getBean(beanId);
    }

    protected abstract Resource getResourceByPath(String path);

    public  void setBeanClassLoader(ClassLoader beanClassLoader){
        this.beanClassLoader = beanClassLoader;
    }

    public ClassLoader getBeanClassLoader(){
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
}
