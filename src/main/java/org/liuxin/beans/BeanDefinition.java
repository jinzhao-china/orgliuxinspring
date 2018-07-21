package org.liuxin.beans;

import java.util.List;

/**
 * Created by zjin010 on 6/11/18.
 */
public interface BeanDefinition {
    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    public boolean isSingleton();
    public boolean isPrototype();
    String getScope();
    void setScope(String scope);

    public String getBeanClassName();

    public List<PropertyValue> getPropertyValues();
    public ConstructorArgument getConstructorArgument();
    public String getID();
    public boolean hasConstructorArgumentValues();
}
