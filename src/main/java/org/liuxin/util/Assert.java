package org.liuxin.util;

/**
 * Created by zhaojin on 7/14/18.
 */
public abstract class Assert {
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
