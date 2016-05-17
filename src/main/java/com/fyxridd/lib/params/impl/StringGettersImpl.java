package com.fyxridd.lib.params.impl;

import com.fyxridd.lib.params.api.StringGetter;
import com.fyxridd.lib.params.api.ObjectGetters;
import com.fyxridd.lib.params.api.StringGetters;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringGettersImpl implements StringGetters{
    private Map<String, StringGetter> map;

    public StringGettersImpl(Map<String, StringGetter> map) {
        this.map = map;
    }

    @Override
    public boolean hasValue(String name) {
        return map.containsKey(name);
    }

    @Override
    public String get(ObjectGetters objectGetters, String name, String[] extra) {
        return map.get(name).get(objectGetters, this, extra);
    }

    @Override
    public StringGetters clone() {
        Map<String, StringGetter> newMap = new HashMap<String, StringGetter>();
        for (Entry<String, StringGetter> entry:map.entrySet()) newMap.put(entry.getKey(), entry.getValue().clone());
        return new StringGettersImpl(newMap);
    }
    
}
