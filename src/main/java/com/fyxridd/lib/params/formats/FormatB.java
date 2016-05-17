package com.fyxridd.lib.params.formats;

import java.util.Set;

import com.fyxridd.lib.params.api.Format;
import com.fyxridd.lib.params.api.ParamsApi;
import com.fyxridd.lib.params.api.ValueGetter;

/**
 * 直接设置值,可包含变量
 */
public class FormatB extends Format{
    public static final String PREFIX = "b";

    private Set<String> params;

    public FormatB(String value) {
        super(value);
        params = ParamsApi.getParams(value);
    }

    @Override
    public String convert(ValueGetter getter, String[] extra) {
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
