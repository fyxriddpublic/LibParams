package com.fyxridd.lib.params;

import com.fyxridd.lib.params.getter.obj.ObjectGetter;
import com.fyxridd.lib.params.getter.str.StringGetter;

import java.util.ArrayList;
import java.util.List;

public class Util {
    /**
     * 获取传入方法的变量名列表
     * @param s 格式'([{param},...])'
     * @return 返回的变量名不包含{},不为null可为空列表
     */
    public static List<String> getMethodParams(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 2) return result;
        String[] ss = s.substring(1, s.length()-1).split(",");
        for (String tmp:ss) result.add(tmp.substring(1, tmp.length()-1));
        return result;
    }

    public static ObjectGetter loadObjectGetter(String objName, String objValue) throws Exception {
        return ParamsPlugin.instance.getParamsManager().loadObjectGetter(objName, objValue);
    }

    /**
     * @param strName 变量名
     * @param strValue 变量定义字符串
     * @return 不为null
     */
    public static StringGetter loadStringGetter(String strName, String strValue) throws Exception {
        return ParamsPlugin.instance.getParamsManager().loadStringGetter(strName, strValue);
    }
}
