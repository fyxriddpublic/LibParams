package com.fyxridd.lib.params.api;

import java.util.Map;

/**
 * 每个配置对应一个此实例
 */
public interface ParamsFactory {
    /**
     * 新建会话
     */
    Session openSession(Map<String, Object> objDefaults, Map<String, String> strDefaults, String[] extra);
}
