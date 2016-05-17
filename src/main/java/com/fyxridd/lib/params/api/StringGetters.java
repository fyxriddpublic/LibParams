package com.fyxridd.lib.params.api;

public interface StringGetters extends Cloneable{
    /**
     * @param name 变量名
     */
    boolean hasValue(String name);
    
    /**
     * @param name 变量名
     * @return 可为null
     */
    String get(ObjectGetters objectGetters, String name, String[] extra);

    public StringGetters clone();
}
