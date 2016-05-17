package com.fyxridd.lib.params.api;

import com.fyxridd.lib.params.ParamsPlugin;
import com.fyxridd.lib.params.getter.obj.ObjectGetterAManager.Getter;

public class ParamsApi {
    /**
     * 注册插件获取器
     * @param plugin 插件名
     * @param getName 获取名
     * @param getter 获取器
     */
    public static void register(String plugin, String getName, Getter getter) {
        ParamsPlugin.instance.getObjectGetterAManager().register(plugin, getName, getter);
    }
}
