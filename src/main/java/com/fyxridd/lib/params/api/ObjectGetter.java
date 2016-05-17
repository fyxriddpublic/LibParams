package com.fyxridd.lib.params.api;

/**
 * 对象获取器
 */
public abstract class ObjectGetter implements Cloneable{
    protected String value;

    public ObjectGetter(String value) throws Exception{
        this.value = value;
    }

    /**
     * 获取对象
     * @return 获取到的对象
     */
    public abstract Object get(ObjectGetters objectGetters, StringGetters stringGetters, String[] extra);
    
    public abstract ObjectGetter clone();
}
