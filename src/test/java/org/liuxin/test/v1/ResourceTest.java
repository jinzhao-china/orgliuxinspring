package org.liuxin.test.v1;

import org.junit.Assert;
import org.junit.Test;
import org.liuxin.core.io.ClassPathResource;
import org.liuxin.core.io.FileSystemResource;
import org.liuxin.core.io.Resource;

import java.io.InputStream;

/**
 * Created by zjin010 on 6/18/18.
 */
public class ResourceTest {
    @Test
    public void testClassPathResource() throws Exception {
        Resource r = new ClassPathResource("petstore-v1.xml");
        InputStream is = null;
        try {
            is = r.getInputStream();

            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @Test
    public void testFileSystemPathResource() throws Exception {
        String filePath = TestUtils.getPath();
        filePath = String.format("%s/%s", filePath, "src/test/resources/petstore-v1.xml");
        System.out.println(filePath);
        Resource r = new FileSystemResource(filePath);

        InputStream is = null;
        try {
            is = r.getInputStream();

            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }


}
