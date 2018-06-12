package org.liuxin.beans;

/**
 * Created by zjin010 on 6/11/18.
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg){
        super(msg);
    }

    public BeansException(String msg, Throwable cause){
        super(msg, cause);
    }
}
