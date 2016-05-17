package com.fyxridd.lib.params.getter.str;

import java.util.Set;

import com.fyxridd.lib.params.api.ObjectGetters;
import com.fyxridd.lib.params.api.StringGetter;
import com.fyxridd.lib.params.api.ParamsApi;
import com.fyxridd.lib.params.api.StringGetters;

/**
 * 直接设置值,可包含变量
 */
public class StringGetterB extends StringGetter{
    public static final String PREFIX = "b";

    private Set<String> params;

    public StringGetterB(String value) throws Exception {
        super(value);
        params = ParamsApi.getParams(value);
    }

    @Override
    public String get(ObjectGetters objectGetters, StringGetters stringGetters, String[] extra) {
        if (params != null) {
            for (String param:params) {
                if (stringGetters.hasValue(param)) {
                    String replace = stringGetters.get(objectGetters, param, extra);
                    if (replace != null) value = value.replace("{"+param+"}", replace);
                }
            }
        }
        return value;
    }
}
