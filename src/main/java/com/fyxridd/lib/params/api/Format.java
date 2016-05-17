package com.fyxridd.lib.params.api;

public interface Format {
    String getPrefix();

    /**
     * 转换格式
     * @param getter 变量获取器
     * @param extra 额外变量
     * @return 转换后的值
     */
    String convert(String value, ValueGetter getter, String[] extra);
}
