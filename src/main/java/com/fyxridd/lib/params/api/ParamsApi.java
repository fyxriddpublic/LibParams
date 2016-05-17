package com.fyxridd.lib.params.api;

import com.fyxridd.lib.params.ParamsPlugin;
import com.fyxridd.lib.params.getter.obj.ObjectGetterAManager.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamsApi {
    private static final Pattern paramsPattern = Pattern.compile("\\{([\\w]+)\\}");

    /**
     * 注册插件获取器
     * @param plugin 插件名
     * @param getName 获取名
     * @param getter 获取器
     */
    public static void register(String plugin, String getName, Getter getter) {
        ParamsPlugin.instance.getObjectGetterAManager().register(plugin, getName, getter);
    }
    
    /**
     * 获取变量名集合
     * 变量名在字符串中都以'{变量名}'的格式存在
     * @return 返回的变量名不包含{},不为null可为空列表
     */
    public static Set<String> getParams(String s) {
        Set<String> result = new HashSet<>();
        if (s != null) {
            Matcher matcher = paramsPattern.matcher(s);
            while (matcher.find()) result.add(matcher.group(1));  
        }
        return result;
    }

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
