package com.fyxridd.lib.params.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fyxridd.lib.params.api.ObjectGetter;
import com.fyxridd.lib.params.api.ObjectGetters;
import com.fyxridd.lib.params.api.StringGetters;

public class ObjectGettersImpl implements ObjectGetters{
    private Map<String, ObjectGetter> map;
    
    public ObjectGettersImpl(Map<String, ObjectGetter> map) {
        this.map = map;
    }

    @Override
    public boolean hasValue(String name) {
        return map.containsKey(name);
    }

    @Override
    public Object get(StringGetters stringGetters, String name, String[] extra) {
        return map.get(name).get(this, stringGetters, extra);
    }

    @Override
    public ObjectGetters clone() {
        Map<String, ObjectGetter> newMap = new HashMap<String, ObjectGetter>();
        for (Entry<String, ObjectGetter> entry:map.entrySet()) newMap.put(entry.getKey(), entry.getValue().clone());
        return new ObjectGettersImpl(newMap);
    }
}
