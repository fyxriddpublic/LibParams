package com.fyxridd.lib.params.api;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParamsApi {
    private static final Pattern paramsPattern = Pattern.compile("\\{([\\w]+)\\}");
    
    /**
     * 获取变量名集合
     * 变量名在字符串中都以'{变量名}'的格式存在
     * @return 返回的变量名不包含{}
     */
    public static Set<String> getParams(String s) {
        Set<String> result = new HashSet<String>();
        if (s != null) {
            Matcher matcher = paramsPattern.matcher(s);
            while (matcher.find()) result.add(matcher.group(1));  
        }
        return result;
    }
}
