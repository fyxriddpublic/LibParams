package com.fyxridd.lib.params.getter.obj;

import com.fyxridd.lib.params.api.Getter;
import com.fyxridd.lib.params.api.Session;

import java.util.HashMap;
import java.util.Map;

public class ObjectGetterAManager {
    //插件名 获取名 获取器
    private Map<String, Map<String, Getter>> map = new HashMap<>();

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
    public Object getValue(Session session, ObjectGetterA objectGetterA) {
        try {
            Map<String, Getter> gets = map.get(objectGetterA.getPlugin());
            if (gets != null) {
                Getter objectAGetter = gets.get(objectGetterA.getGetName());
                if (objectAGetter != null) {
                    String[] args = new String[objectGetterA.getGetParams().size()];
                    for (int index=0;index<args.length;index++) args[index] = session.getStr(objectGetterA.getGetParams().get(index));
                    return objectAGetter.get(args);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
