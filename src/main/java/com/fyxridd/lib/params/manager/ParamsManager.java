package com.fyxridd.lib.params.manager;

import com.fyxridd.lib.params.api.StringGetter;
import com.fyxridd.lib.params.api.ObjectGetter;
import com.fyxridd.lib.params.api.ParamsApi;
import com.fyxridd.lib.params.getter.obj.ObjectGetterA;
import com.fyxridd.lib.params.getter.str.StringGetterA;
import com.fyxridd.lib.params.getter.str.StringGetterB;
import com.fyxridd.lib.params.getter.str.StringGetterC;

import java.util.HashMap;
import java.util.Map;

public class ParamsManager {
    private Map<String, Class<? extends ObjectGetter>> getObjects = new HashMap<>();
    private Map<String, Class<? extends StringGetter>> getStrings = new HashMap<>();

    {
        registerObjectGetter(ObjectGetterA.PREFIX, ObjectGetterA.class);
        
        registerStringGetter(StringGetterA.PREFIX, StringGetterA.class);
        registerStringGetter(StringGetterB.PREFIX, StringGetterB.class);
        registerStringGetter(StringGetterC.PREFIX, StringGetterC.class);
    }

    public ParamsManager() {
    }

    public void registerObjectGetter(String prefix, Class<? extends ObjectGetter> objectGetterClass) {
        getObjects.put(prefix, objectGetterClass);
    }

    public void registerStringGetter(String prefix, Class<? extends StringGetter> formatClass) {
        getStrings.put(prefix, formatClass);
    }

    /**
     * @see ParamsApi#loadObjectGetter(String, String)
     */
    public ObjectGetter loadObjectGetter(String objName, String objValue) throws Exception{
        for (Map.Entry<String, Class<? extends ObjectGetter>> entry:getObjects.entrySet()) {
            if (objName.startsWith(entry.getKey())) return entry.getValue().getConstructor(String.class).newInstance(objValue);
        }
        throw new Exception("objName has no match prefix!");
    }

    /**
     * @see com.fyxridd.lib.params.api.ParamsApi#loadStringGetter(String, String)
     */
    public StringGetter loadStringGetter(String strName, String strValue) throws Exception{
        for (Map.Entry<String, Class<? extends StringGetter>> entry:getStrings.entrySet()) {
            if (strName.startsWith(entry.getKey())) return entry.getValue().getConstructor(String.class).newInstance(strValue);
        }
        throw new Exception("strName has no match prefix!");
    }
}
