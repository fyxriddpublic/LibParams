package com.fyxridd.lib.params.formats;

import com.fyxridd.lib.core.api.UtilApi;
import com.fyxridd.lib.params.api.Format;
import com.fyxridd.lib.params.api.ValueGetter;

public class FormatC implements Format{
    private static final String PREFIX = "c";
    
    @Override
    public String getPrefix() {
        return PREFIX;
    }

    @Override
    public String convert(String value, ValueGetter getter, String[] extra) {
        return UtilApi.convertArg(extra, value);
    }
}
