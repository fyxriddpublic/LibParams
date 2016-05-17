package com.fyxridd.lib.params.getter.str;

import com.fyxridd.lib.core.api.UtilApi;
import com.fyxridd.lib.params.api.ObjectGetters;
import com.fyxridd.lib.params.api.StringGetter;
import com.fyxridd.lib.params.api.StringGetters;

/**
 * 单个的组合额外变量
 */
public class StringGetterC extends StringGetter{
    public static final String PREFIX = "c";

    public StringGetterC(String value) throws Exception {
        super(value);
    }

    @Override
    public String get(ObjectGetters objectGetters, StringGetters stringGetters, String[] extra) {
        return UtilApi.convertArg(extra, value);
    }
}
