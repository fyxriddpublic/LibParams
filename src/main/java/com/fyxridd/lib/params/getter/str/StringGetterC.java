package com.fyxridd.lib.params.getter.str;

import com.fyxridd.lib.core.api.UtilApi;
import com.fyxridd.lib.params.api.Session;
import com.fyxridd.lib.params.api.StringGetter;

/**
 * 单个的组合额外变量
 */
public class StringGetterC extends StringGetter{
    public static final String PREFIX = "c";

    public StringGetterC(String value) throws Exception {
        super(value);
    }

    @Override
    public String get(Session session) {
        return UtilApi.convertArg(session.getExtra(), getValue());
    }
}
