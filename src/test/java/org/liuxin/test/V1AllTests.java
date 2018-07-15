package org.liuxin.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by zjin010 on 6/18/18.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ApplicationContextTest.class,
        BeanFactoryTest.class,
        ResourceTest.class})
public class V1AllTests {

}
