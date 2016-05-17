package com.fyxridd.lib.params.api;

public interface ObjectGetters extends Cloneable{
    /**
     * @param name 变量名
     */
    boolean hasValue(String name);
    
    /**
     * @param name 变量名
     * @return 可为null
     */
    Object get(StringGetters stringGetters, String name, String[] extra);

    public ObjectGetters clone();
}
