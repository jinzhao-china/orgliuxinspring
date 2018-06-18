package org.liuxin.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.liuxin.beans.BeanDefinition;
import org.liuxin.beans.factory.BeanFactory;
import org.liuxin.beans.factory.BeansDefinitionStoreException;
import org.liuxin.beans.factory.support.BeanDefinitionRegistry;
import org.liuxin.beans.factory.support.GenericBeanDefinition;
import org.liuxin.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by zjin010 on 6/18/18.
 */
public class XmlBeanDefinitionReader {
    public static final String ID_ATTRIBUTE = "id";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String SCOPE_ATTRIBUTE = "scope";

    BeanDefinitionRegistry registry = null;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void loadBeanDefinition(Resource resource) {
        InputStream is = null;
        try {
            is = resource.getInputStream();

            SAXReader reader = new SAXReader();

            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            Iterator<Element> eleList = root.elementIterator();

            while (eleList.hasNext()) {
                Element ele = eleList.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);
                if(ele.attribute(SCOPE_ATTRIBUTE) != null){
                    bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }
                this.registry.registerBeanDefinition(id, bd);
            }

        } catch (Exception ex) {
            throw new BeansDefinitionStoreException("IOException parsing XML document", ex.getCause());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
