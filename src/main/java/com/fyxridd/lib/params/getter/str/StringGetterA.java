package com.fyxridd.lib.params.getter.str;

import com.fyxridd.lib.core.api.UtilApi;
import com.fyxridd.lib.params.api.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 从获取对象中获取值
 */
public class StringGetterA extends StringGetter{
    public static final String PREFIX = "a";

    //获取对象名
    private String getObjName;

    //true:属性;false:方法
    private boolean property;
    //属性/方法名
    private String proName;
    //方法需要传入的参数列表,不为null可为空列表
    private List<String> proMethodParams;
    //都是String类
    private Class<?>[] proMethodClasses;

    public StringGetterA(String value) throws Exception {
        super(value);
        try {
            String[] ss = value.split(":");

            //格式错误
            if (ss.length != 1 && ss.length != 2) throw new Exception("format error");
            
            {
                getObjName = ss[0];
            }

            {
                if (ss.length == 1) {
                    property = false;
                    proName = "toString";
                    proMethodParams = new ArrayList<>();
                    proMethodClasses = new Class[0];
                }else {//ss.length == 2
                    property = ss[1].charAt(ss[1].length()-1) != ')';
                    proName = ss[1].substring(0, ss[1].indexOf('('));
                    proMethodParams = ParamsApi.getMethodParams(ss[1].substring(proName.length()));
                    proMethodClasses = new Class<?>[proMethodParams.size()];
                    for (int index=0;index<proMethodParams.size();index++) proMethodClasses[index] = String.class;
                }
            }
        } catch (Exception e) {
            throw new Exception("new FormatA error: "+e.getMessage(), e);
        }
    }

    @Override
    public String get(Session session) {
        try {
            Object o = session.getObj(getObjName);
            if (o != null) {
                Object result;
                if (property) {
                    result = UtilApi.getField(o.getClass().getDeclaredField(proName), o);
                }else {
                    String[] proArgs = new String[proMethodParams.size()];
                    for (int index=0;index<proArgs.length;index++) proArgs[index] = session.getStr(proMethodParams.get(index));
                    result = UtilApi.getMethod(o.getClass().getDeclaredMethod(proName, proMethodClasses), proArgs);
                }
                if (result != null) return result.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isProperty() {
        return property;
    }

    public String getProName() {
        return proName;
    }

    public List<String> getProMethodParams() {
        return proMethodParams;
    }

    public Class<?>[] getProMethodClasses() {
        return proMethodClasses;
    }
}
