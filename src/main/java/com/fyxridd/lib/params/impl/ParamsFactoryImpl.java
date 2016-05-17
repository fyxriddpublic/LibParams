package com.fyxridd.lib.params.impl;

import com.fyxridd.lib.params.ObjectGetter;
import com.fyxridd.lib.params.StringGetter;
import com.fyxridd.lib.params.api.*;

import java.util.Map;

public class ParamsFactoryImpl implements ParamsFactory{
    private Map<String, ObjectGetter> objs;
    private Map<String, StringGetter> strs;

    public ParamsFactoryImpl(Map<String, ObjectGetter> objs, Map<String, StringGetter> strs) {
        this.objs = objs;
        this.strs = strs;
    }

    @Override
    public ObjectGetter getObjGetter(String objName) {
        return objs.get(objName);
    }

    @Override
    public StringGetter getStrGetter(String strName) {
        return strs.get(strName);
    }

    @Override
    public Session openSession(Map<String, Object> objDefaults, Map<String, String> strDefaults, String[] extra) {
        return new SessionImpl(this, objDefaults, strDefaults, extra);
    }
}
