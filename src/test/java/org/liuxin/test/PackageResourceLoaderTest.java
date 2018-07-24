package org.liuxin.test;

import org.junit.*;
import org.liuxin.core.io.Resource;
import org.liuxin.core.io.support.PackageResourceLoader;

import java.io.IOException;

/**
 * Created by zjin010 on 7/24/18.
 */
public class PackageResourceLoaderTest {
    @Test
    public void testGetResources() throws IOException {
        PackageResourceLoader loader = new PackageResourceLoader();
        Resource[] resources = loader.getResources("org.litespring.dao.v4");
        Assert.assertEquals(2, resources.length);

    }
}
