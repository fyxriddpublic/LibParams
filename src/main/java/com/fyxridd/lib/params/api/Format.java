package com.fyxridd.lib.params.api;

public abstract class Format {
    protected String value;

    public Format(String value) {
        this.value = value;
    }

    /**
     * 转换格式
     * @param getter 变量获取器
     * @param extra 额外变量
     * @return 转换后的值
     */
    public abstract String convert(ValueGetter getter, String[] extra);
}
