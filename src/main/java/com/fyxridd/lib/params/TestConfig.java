package com.fyxridd.lib.params;

import com.fyxridd.lib.config.api.basic.Path;
import com.fyxridd.lib.config.api.convert.ConfigConvert;
import com.fyxridd.lib.params.api.ParamsConverter;
import com.fyxridd.lib.params.api.ParamsFactory;

public class TestConfig {
    @Path("params")
    @ConfigConvert(ParamsConverter.class)
    private ParamsFactory factory;

    public ParamsFactory getFactory() {
        return factory;
    }
}
