package com.fyxridd.lib.params.api;

/**
 * 对象获取器
 */
public interface Getter {
    /**
     * 获取对象
     * @param args 传入的字符串变量列表
     */
    Object get(String... args);
}
