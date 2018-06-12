package org.liuxin.beans.factory.support;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.liuxin.beans.BeanDefinition;
import org.liuxin.beans.factory.BeanFactory;
import org.liuxin.beans.factory.BeansCreationException;
import org.liuxin.beans.factory.BeansDefinitionStoreException;
import org.liuxin.util.ClassUtils;

import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zjin010 on 6/11/18.
 */
public class DefaultBeanFactory implements BeanFactory {
    public static final String ID_ATTRIBUTE = "id";
    public static final String CLASS_ATTRIBUTE = "class";
    public final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public DefaultBeanFactory(String configFile) {
        loadBeanDefinition(configFile);

    }

    private void loadBeanDefinition(String configFile) {
        InputStream is = null;
        try {
            ClassLoader cl = ClassUtils.getDefaultClassLoader();
            is = cl.getResourceAsStream(configFile);

            SAXReader reader = new SAXReader();

            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();

            while (iter.hasNext()) {
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                this.beanDefinitionMap.put(id, bd);
            }

        } catch (DocumentException ex) {
            throw new BeansDefinitionStoreException("IOException parsing XML document", ex.getCause());
        }finally {
            if(is != null){
                try{
                    is.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
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

    public BeanDefinition getBeanDefinition(String beanId) {
        return this.beanDefinitionMap.get(beanId);
    }
}
