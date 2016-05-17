package com.fyxridd.lib.params.api;

import com.fyxridd.lib.params.ObjectGetter;
import com.fyxridd.lib.params.StringGetter;

import java.util.Map;

/**
 * 每个配置对应一个此实例
 */
public interface ParamsFactory {
    /**
     * @return 不存在返回null
     */
    ObjectGetter getObjGetter(String objName);

    /**
     * @return 不存在返回null
     */
    StringGetter getStrGetter(String strName);

    /**
     * 新建会话
     */
    Session openSession(Map<String, Object> objDefaults, Map<String, String> strDefaults, String[] extra);
}
