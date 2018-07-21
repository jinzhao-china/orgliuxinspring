package org.liuxin.test;

import org.junit.Assert;
import org.junit.Test;
import org.liuxin.beans.BeanDefinition;
import org.liuxin.beans.factory.support.ConstructorResolver;
import org.liuxin.beans.factory.support.DefaultBeanFactory;
import org.liuxin.beans.factory.xml.XmlBeanDefinitionReader;
import org.liuxin.core.io.*;
import org.liuxin.services.PetStoreService;

/**
 * Created by zjin010 on 7/21/18.
 */
public class ConstructorResolverTest {
    @Test
    public void testAutowireConstructor() {

        DefaultBeanFactory factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("petstore.xml");
        reader.loadBeanDefinitions(resource);

        BeanDefinition bd = factory.getBeanDefinition("petStore");

        ConstructorResolver resolver = new ConstructorResolver(factory);

        PetStoreService petStore = (PetStoreService)resolver.autowireConstructor(bd);

        // 验证参数version 正确地通过此构造函数做了初始化
        // PetStoreService(AccountDao accountDao, ItemDao itemDao,int version)
        Assert.assertEquals(1, petStore.getVersion());

        Assert.assertNotNull(petStore.getAccountDao());
        Assert.assertNotNull(petStore.getItemDao());


    }
}
