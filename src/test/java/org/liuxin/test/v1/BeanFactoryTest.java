package org.liuxin.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.liuxin.beans.BeanDefinition;
import org.liuxin.beans.factory.BeanCreationException;
import org.liuxin.beans.factory.BeansDefinitionStoreException;
import org.liuxin.beans.factory.support.DefaultBeanFactory;
import org.liuxin.beans.factory.xml.XmlBeanDefinitionReader;
import org.liuxin.core.io.ClassPathResource;
import org.liuxin.services.v1.PetStoreService;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by zjin010 on 6/11/18.
 */
public class BeanFactoryTest {
    DefaultBeanFactory factory = null;
    XmlBeanDefinitionReader reader = null;

    @Before
    public void setUp() {
        factory = new DefaultBeanFactory();
        reader = new XmlBeanDefinitionReader(factory);
    }

    @Test
    public void testGetBean() {
        reader.loadBeanDefinition(new ClassPathResource("petstore-v1.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");


        assertEquals("org.liuxin.services.v1.PetStoreService", bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

        assertNotNull(petStore);
    }

    @Test
    public void testInvalidBean() {
        reader.loadBeanDefinition(new ClassPathResource("petstore-v1.xml"));

        try {
            factory.getBean("invalidBean");

        } catch (BeanCreationException e) {
            return;
        }

        Assert.fail("expect BeanCreationException");
    }

    @Test
    public void testInvalidXml() {

        try {
            reader.loadBeanDefinition(new ClassPathResource("v2.xml"));
        } catch (BeansDefinitionStoreException e) {
            return;
        }

        Assert.fail("expect BeansDefinitionStoreException");
    }
}