package com.fyxridd.lib.params.impl;

import com.fyxridd.lib.params.api.Format;
import com.fyxridd.lib.params.api.ValueGetter;

import java.util.Map;

public class ValueGetterImpl implements ValueGetter{
    private Map<String, Format> map;

    public ValueGetterImpl(Map<String, Format> map) {
        this.map = map;
    }

    @Override
    public boolean hasValue(String name) {
        return map.containsKey(name);
    }

    @Override
    public String getValue(String name, String[] extra) {
        return map.get(name).convert(this, extra);
    }
}
