package com.fyxridd.lib.params.getter.str;

import java.util.Set;

import com.fyxridd.lib.core.api.UtilApi;
import com.fyxridd.lib.params.api.Session;

/**
 * 直接设置值,可包含变量
 */
public class StringGetterB extends StringGetter{
    public static final String PREFIX = "b";

    private Set<String> params;

    public StringGetterB(String value) throws Exception {
        super(value);
        params = UtilApi.getParams(value);
    }

    @Override
    public String get(Session session) {
        String result = getValue();
        if (params != null) {
            for (String strName:params) {
                String replace = session.getStr(strName);
                if (replace != null) result = result.replace("{"+strName+"}", replace);
            }
        }
        return result;
    }
}
