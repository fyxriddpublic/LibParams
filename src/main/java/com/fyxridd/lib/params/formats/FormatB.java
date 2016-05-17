package com.fyxridd.lib.params.formats;

import java.util.Set;

import com.fyxridd.lib.params.api.Format;
import com.fyxridd.lib.params.api.ParamsApi;
import com.fyxridd.lib.params.api.ValueGetter;

public class FormatB implements Format{
    private static final String PREFIX = "b";
    
    @Override
    public String getPrefix() {
        return PREFIX;
    }

    @Override
    public String convert(String value, ValueGetter getter, String[] extra) {
        Set<String> params = ParamsApi.getParams(value);
        if (params != null) {
            for (String param:params) {
                if (getter.hasValue(param)) {
                    String replace = getter.getValue(param);
                    if (replace != null) value = value.replace("{"+param+"}", replace);
                }
            }
        }
        return value;
    }
}
