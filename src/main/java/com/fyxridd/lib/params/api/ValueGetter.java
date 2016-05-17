package com.fyxridd.lib.params.api;

public interface ValueGetter {
    /**
     * @param name 变量名
     */
    boolean hasValue(String name);
    
    /**
     * @param name 变量名
     * @return 可为null
     */
    String getValue(String name, String[] extra);
}
