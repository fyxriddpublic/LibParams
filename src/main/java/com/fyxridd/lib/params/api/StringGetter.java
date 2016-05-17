package com.fyxridd.lib.params.api;

public abstract class StringGetter implements Cloneable{
    protected String value;

    public StringGetter(String value) throws Exception{
        this.value = value;
    }

    /**
     * 转换格式
     * @param getter 变量获取器
     * @param extra 额外变量
     * @return 转换后的值
     */
    public abstract String get(ObjectGetters objectGetters, StringGetters stringGetters, String[] extra);

    public abstract StringGetter clone();
}
