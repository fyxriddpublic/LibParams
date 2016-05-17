package com.fyxridd.lib.params.getter.obj;

import com.fyxridd.lib.params.api.Session;

/**
 * 对象获取器
 */
public abstract class ObjectGetter{
    private String value;

    public ObjectGetter(String value) throws Exception{
        this.value = value;
    }

    /**
     * 获取对象
     * @return 获取到的对象
     */
    public abstract Object get(Session session);

    public String getValue() {
        return value;
    }
}
