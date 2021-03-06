package com.fyxridd.lib.params.getter.obj;

import com.fyxridd.lib.params.ParamsPlugin;
import com.fyxridd.lib.params.Util;
import com.fyxridd.lib.params.api.Session;

import java.util.List;

/**
 * 从插件中获取对象
 */
public class ObjectGetterA extends ObjectGetter{
    public static final String PREFIX = "o";

    //插件名
    private String plugin;

    //获取名
    private String getName;
    //获取需要传入的参数列表,不为null可为空列表
    private List<String> getParams;

    public ObjectGetterA(String value) throws Exception {
        super(value);
        try {
            String[] ss = value.split(":");

            //格式错误
            if (ss.length != 2) throw new Exception("format error");
            
            {
                plugin = ss[0];
            }

            {
                getName = ss[1].substring(0, ss[1].indexOf('('));
                getParams = Util.getMethodParams(ss[1].substring(getName.length()));
            }
        } catch (Exception e) {
            throw new Exception("new ObjectGetterA error: "+e.getMessage(), e);
        }
    }

    @Override
    public Object get(Session session) {
        return ParamsPlugin.instance.getObjectGetterAManager().getValue(session, this);
    }

    public String getPlugin() {
        return plugin;
    }

    public String getGetName() {
        return getName;
    }

    public List<String> getGetParams() {
        return getParams;
    }
}
