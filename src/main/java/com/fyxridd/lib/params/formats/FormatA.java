package com.fyxridd.lib.params.formats;

import java.util.HashMap;
import java.util.Map;

import com.fyxridd.lib.params.api.Format;
import com.fyxridd.lib.params.api.ValueGetter;

public class FormatA implements Format{
    public interface Getter {
        /**
         * 获取值
         * @param args 传入的字符串变量列表
         */
        Object get(String... args);
    }
    
    private static final String PREFIX = "a";
    
    private Map<String, Map<String, Getter>> map = new HashMap<String, Map<String,Getter>>();
    
    @Override
    public String getPrefix() {
        return PREFIX;
    }

    @Override
    public String convert(String value, ValueGetter getter, String[] extra) {
        
    }
    
    public void register(String plugin, String getName, Getter getter) {
        Map<String, Getter> m = map.get(plugin);
        if (m == null) {
            m = new HashMap<String, FormatA.Getter>();
            map.put(plugin, m);
        }
        m.put(getName, getter);
    }
}
