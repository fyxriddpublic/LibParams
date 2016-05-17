package com.fyxridd.lib.params.formats;

import com.fyxridd.lib.core.api.UtilApi;
import com.fyxridd.lib.params.api.Format;
import com.fyxridd.lib.params.api.ValueGetter;

/**
 * 单个的组合额外变量
 */
public class FormatC extends Format{
    public static final String PREFIX = "c";

    public FormatC(String value) {
        super(value);
    }

    @Override
    public String convert(ValueGetter getter, String[] extra) {
        return UtilApi.convertArg(extra, value);
    }
}
