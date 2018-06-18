package org.liuxin.context.support;

import org.liuxin.beans.BeanDefinition;
import org.liuxin.beans.context.ApplicationContext;
import org.liuxin.core.io.ClassPathResource;
import org.liuxin.core.io.Resource;

/**
 * Created by zjin010 on 6/18/18.
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    public ClassPathXmlApplicationContext(String configFile) {
        super(configFile);
    }

    protected Resource getResourceByPath(String path) {
        return new ClassPathResource(path, this.getBeanClassLoader());
    }


}
