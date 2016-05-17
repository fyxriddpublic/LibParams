package com.fyxridd.lib.params.formats;

import com.fyxridd.lib.core.api.UtilApi;
import com.fyxridd.lib.params.api.FormatAGetter;
import com.fyxridd.lib.params.api.ValueGetter;

import java.util.HashMap;
import java.util.Map;

public class FormatAManager {
    //插件名 获取名 获取器
    private Map<String, Map<String, FormatAGetter>> map = new HashMap<>();

    /**
     * 注册插件获取器
     * @param plugin 插件名
     * @param getName 获取名
     * @param getter 获取器
     */
    public void register(String plugin, String getName, FormatAGetter getter) {
        Map<String, FormatAGetter> m = map.get(plugin);
        if (m == null) {
            m = new HashMap<>();
            map.put(plugin, m);
        }
        m.put(getName, getter);
    }

    /**
     * @return 可能为null
     */
    public String getValue(FormatA formatA, ValueGetter valueGetter) {
        try {
            Map<String, FormatAGetter> gets = map.get(formatA.getPlugin());
            if (gets != null) {
                FormatAGetter formatAGetter = gets.get(formatA.getGetName());
                if (formatAGetter != null) {
                    String[] args = new String[formatA.getGetParams().size()];
                    for (int index=0;index<args.length;index++) args[index] = valueGetter.getValue(formatA.getGetParams().get(index));
                    Object o = formatAGetter.get(args);
                    Object result;
                    if (formatA.isProperty()) {
                        result = UtilApi.getField(o.getClass().getDeclaredField(formatA.getProName()), o);
                    }else {
                        String[] proArgs = new String[formatA.getProMethodParams().size()];
                        for (int index=0;index<args.length;index++) proArgs[index] = valueGetter.getValue(formatA.getProMethodParams().get(index));
                        result = UtilApi.getMethod(o.getClass().getDeclaredMethod(formatA.getProName(), formatA.getProMethodClasses()), proArgs);
                    }
                    if (result == null) return null;
                    else return result.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
