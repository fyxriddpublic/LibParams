package com.fyxridd.lib.params.impl;

import com.fyxridd.lib.params.ObjectGetter;
import com.fyxridd.lib.params.StringGetter;
import com.fyxridd.lib.params.api.ParamsFactory;
import com.fyxridd.lib.params.api.Session;

import java.util.HashMap;
import java.util.Map;

/**
 * 会话
 */
public class SessionImpl implements Session{
    private ParamsFactory factory;
    //缓存

    //获取对象名 缓存的对象
    //在一次会话里,获取到的一个对象假定都是相同的
    private Map<String, Object> objCache = new HashMap<>();
    //获取字符串名 缓存的字符串
    private Map<String, String> strCache = new HashMap<>();
    //额外变量
    private String[] extra;

    public SessionImpl(ParamsFactory factory, Map<String, Object> objDefaults, Map<String, String> strDefaults, String[] extra) {
        this.factory = factory;
        this.objCache.putAll(objDefaults);
        this.strCache.putAll(strDefaults);
        this.extra = extra;
    }

    /**
     * @return 可能为null
     */
    public String getStr(String strName) {
        //先从缓存中读取
        String result = strCache.get(strName);
        if (result != null) return result;

        //再获取
        StringGetter getter = ((ParamsFactoryImpl)factory).getStrGetter(strName);
        if (getter == null) return null;

        //添加缓存
        result = getter.get(this);
        if (result != null) strCache.put(strName, result);

        //返回
        return result;
    }

    /**
     * 重要: 需要缓存
     * @return 可为null
     */
    public Object getObj(String objName) {
        //先从缓存中读取
        Object result = objCache.get(objName);
        if (result != null) return result;

        //再获取
        ObjectGetter getter = ((ParamsFactoryImpl)factory).getObjGetter(objName);
        if (getter == null) return null;

        //添加缓存
        result = getter.get(this);
        if (result != null) objCache.put(objName, result);

        //返回
        return result;
    }

    public String[] getExtra() {
        return extra;
    }
}
