package org.liuxin.util;

/**
 * Created by zjin010 on 6/11/18.
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
            if (cl == null) {
                // When this method is called for initializing a ICU4J class
                // during bootstrap, cl might be still null (other than Android?).
                // In this case, we want to use the bootstrap class loader.
                cl = ClassLoader.getSystemClassLoader();
            }
        }
        return cl;
    }
}
