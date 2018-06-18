package org.liuxin.beans;

/**
 * Created by zjin010 on 6/11/18.
 */
public interface BeanDefinition {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROTOTYPE = "singleton";
    String SCOPE_DEFAULT = "singleton";

    String getBeanClassName();
    String getScope();
    void setScope(String scope);
    boolean isSingleton();
    boolean isPrototype();
}
