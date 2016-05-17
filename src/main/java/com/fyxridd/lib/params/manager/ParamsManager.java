package com.fyxridd.lib.params.manager;

import com.fyxridd.lib.params.StringGetter;
import com.fyxridd.lib.params.ObjectGetter;
import com.fyxridd.lib.params.getter.obj.ObjectGetterA;
import com.fyxridd.lib.params.getter.str.StringGetterA;
import com.fyxridd.lib.params.getter.str.StringGetterB;
import com.fyxridd.lib.params.getter.str.StringGetterC;

import java.util.HashMap;
import java.util.Map;

public class ParamsManager {
    private static Map<String, Class<? extends ObjectGetter>> getObjects = new HashMap<>();
    private static Map<String, Class<? extends StringGetter>> getStrings = new HashMap<>();

    static {
        registerObjectGetter(ObjectGetterA.PREFIX, ObjectGetterA.class);
        
        registerStringGetter(StringGetterA.PREFIX, StringGetterA.class);
        registerStringGetter(StringGetterB.PREFIX, StringGetterB.class);
        registerStringGetter(StringGetterC.PREFIX, StringGetterC.class);
    }

    public static void registerObjectGetter(String prefix, Class<? extends ObjectGetter> objectGetterClass) {
        getObjects.put(prefix, objectGetterClass);
    }

    public static void registerStringGetter(String prefix, Class<? extends StringGetter> formatClass) {
        getStrings.put(prefix, formatClass);
    }

    /**
     * @see com.fyxridd.lib.params.Util#loadObjectGetter(String, String)
     */
    public ObjectGetter loadObjectGetter(String objName, String objValue) throws Exception{
        for (Map.Entry<String, Class<? extends ObjectGetter>> entry:getObjects.entrySet()) {
            if (objName.startsWith(entry.getKey())) return entry.getValue().getConstructor(String.class).newInstance(objValue);
        }
        throw new Exception("objName has no match prefix!");
    }

    /**
     * @see com.fyxridd.lib.params.Util#loadStringGetter(String, String)
     */
    public StringGetter loadStringGetter(String strName, String strValue) throws Exception{
        for (Map.Entry<String, Class<? extends StringGetter>> entry:getStrings.entrySet()) {
            if (strName.startsWith(entry.getKey())) return entry.getValue().getConstructor(String.class).newInstance(strValue);
        }
        throw new Exception("strName has no match prefix!");
    }
}
