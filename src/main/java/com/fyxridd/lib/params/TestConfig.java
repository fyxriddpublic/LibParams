package com.fyxridd.lib.params;

import com.fyxridd.lib.config.api.basic.Path;
import com.fyxridd.lib.config.api.convert.ConfigConvert;
import com.fyxridd.lib.params.api.FormatConverter;
import com.fyxridd.lib.params.api.ValueGetter;

public class TestConfig {
    @Path("")
    @ConfigConvert(FormatConverter.class)
    private ValueGetter getter;
}
