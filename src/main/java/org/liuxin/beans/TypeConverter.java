package org.liuxin.beans;

/**
 * Created by zjin010 on 7/15/18.
 */
public interface TypeConverter {
    <T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;
}
