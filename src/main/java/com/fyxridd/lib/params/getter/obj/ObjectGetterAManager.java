package com.fyxridd.lib.params.getter.obj;

import com.fyxridd.lib.params.api.ObjectGetters;
import com.fyxridd.lib.params.api.ParamsApi;
import com.fyxridd.lib.params.api.StringGetters;

import java.util.HashMap;
import java.util.Map;

public class ObjectGetterAManager {
    /**
     * 获取器
     */
    public interface Getter {
        /**
         * 获取值
         * @param args 传入的字符串变量列表
         */
        Object get(String... args);
    }
    
    //插件名 获取名 获取器
    private Map<String, Map<String, Getter>> map = new HashMap<>();

    /**
     * @see ParamsApi#register(String, String, ObjectAGetter)
     */
    public void register(String plugin, String getName, Getter getter) {
        Map<String, Getter> m = map.get(plugin);
        if (m == null) {
            m = new HashMap<>();
            map.put(plugin, m);
        }
        m.put(getName, getter);
    }

    /**
     * @return 可能为null
     */
    public Object getValue(ObjectGetterA objectGetterA, ObjectGetters objectGetters, StringGetters stringGetters, String[] extra) {
        try {
            Map<String, Getter> gets = map.get(objectGetterA.getPlugin());
            if (gets != null) {
                Getter objectAGetter = gets.get(objectGetterA.getGetName());
                if (objectAGetter != null) {
                    String[] args = new String[objectGetterA.getGetParams().size()];
                    for (int index=0;index<args.length;index++) args[index] = stringGetters.get(objectGetters, objectGetterA.getGetParams().get(index), extra);
                    return objectAGetter.get(args);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
