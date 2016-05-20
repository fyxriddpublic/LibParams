package com.fyxridd.lib.params.api;

import java.util.Collection;
import java.util.Map;

/**
 * 每个配置对应一个此实例
 */
public interface ParamsFactory {
    /**
     * 新建会话
     * @param objDefaults 可为null
     * @param strDefaults 可为null
     */
    Session openSession(Map<String, Object> objDefaults, Map<String, String> strDefaults, String[] extra);

    /**
     * 获取所有的str变量的名字(不包括程序自定义传入的Str变量名)
     */
    Collection<String> getStrNames();
}
