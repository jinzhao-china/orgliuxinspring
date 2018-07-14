package org.liuxin.beans.factory;

import org.liuxin.beans.BeansException;

/**
 * Created by zjin010 on 6/11/18.
 */
public class BeanCreationException extends BeansException {
    private String beanName;

    public BeanCreationException(String msg){
        super(msg);
    }

    public BeanCreationException(String msg, Throwable cause){
        super(msg, cause);
    }

    public BeanCreationException(String beanName, String msg){
        super("Error creating bean with name '" + beanName+"': " + msg);
        this.beanName = beanName;
    }

    public BeanCreationException(String beanName, String msg, Throwable cause){
        this(beanName, msg);
        initCause(cause);
    }

    public String getBeanName(){
        return this.beanName;
    }
}
