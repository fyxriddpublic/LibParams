package com.fyxridd.lib.params.impl;

import com.fyxridd.lib.params.api.ObjectGetters;
import com.fyxridd.lib.params.api.ParamsFactory;
import com.fyxridd.lib.params.api.StringGetters;

public class ParamsFactoryImpl implements ParamsFactory{
    private ObjectGetters objectGetters;
    private StringGetters stringGetters;
    
    public ParamsFactoryImpl(ObjectGetters objectGetters, StringGetters stringGetters) {
        super();
        this.objectGetters = objectGetters;
        this.stringGetters = stringGetters;
    }

    @Override
    public ObjectGetters produceObjectGetters() {
        return objectGetters.clone();
    }

    @Override
    public StringGetters produceStringGetters() {
        return stringGetters.clone();
    }
}
