package org.liuxin.beans.factory;

import org.liuxin.beans.BeansException;

/**
 * Created by zjin010 on 6/11/18.
 */
public class BeansCreationException extends BeansException {
    private String beanName;

    public BeansCreationException(String msg){
        super(msg);
    }

    public BeansCreationException(String msg, Throwable cause){
        super(msg, cause);
    }

    public BeansCreationException(String beanName, String msg){
        super("Error creating bean with name '" + beanName+"': " + msg);
        this.beanName = beanName;
    }

    public BeansCreationException(String beanName, String msg, Throwable cause){
        this(beanName, msg);
        initCause(cause);
    }

    public String getBeanName(){
        return this.beanName;
    }
}
