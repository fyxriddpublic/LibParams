package com.fyxridd.lib.params.api;

import com.fyxridd.lib.params.ParamsPlugin;

public class ParamsApi {
    /**
     * 注册对象获取器
     * @param plugin 插件名
     * @param getName 获取名
     * @param getter 获取器
     */
    public static void register(String plugin, String getName, Getter getter) {
        ParamsPlugin.instance.getObjectGetterAManager().register(plugin, getName, getter);
    }
}
