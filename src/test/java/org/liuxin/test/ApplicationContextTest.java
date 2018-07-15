package org.liuxin.test;

import org.junit.Assert;
import org.junit.Test;
import org.liuxin.beans.context.ApplicationContext;
import org.liuxin.context.support.ClassPathXmlApplicationContext;
import org.liuxin.context.support.FileSystemXmlApplicationContext;
import org.liuxin.services.PetStoreService;

/**
 * Created by zjin010 on 6/18/18.
 */
public class ApplicationContextTest {
    @Test
    public void testGetBean(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("petstore.xml");

        PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");

        Assert.assertNotNull(petStore);
    }

    @Test
    public void testGetBeanFromFileSystemContext(){
        String filePath = TestUtils.getPath();
        filePath = String.format("%s/%s", filePath, "src/test/resources/petstore.xml");
        ApplicationContext ctx = new FileSystemXmlApplicationContext(filePath);

        PetStoreService petStore = (PetStoreService)ctx.getBean("petStore");

        Assert.assertNotNull(petStore);
    }
}
