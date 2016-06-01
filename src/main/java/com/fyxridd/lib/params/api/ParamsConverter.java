package com.fyxridd.lib.params.api;

import com.fyxridd.lib.core.api.config.convert.ConfigConvert;
import com.fyxridd.lib.params.getter.obj.ObjectGetter;
import com.fyxridd.lib.params.getter.str.StringGetter;
import com.fyxridd.lib.params.Util;
import com.fyxridd.lib.params.impl.ParamsFactoryImpl;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class ParamsConverter implements ConfigConvert.ConfigConverter<ParamsFactory>{
    @Override
    public ParamsFactory convert(String plugin, ConfigurationSection config) throws Exception {
        Map<String, ObjectGetter> objs = new HashMap<>();
        //获取对象列表
        if (config != null) {
            ConfigurationSection getObjectsConfig = config.getConfigurationSection("getObjects");
            if (getObjectsConfig != null) {
                for (String objName:getObjectsConfig.getValues(false).keySet()) {
                    try {
                        objs.put(objName, Util.loadObjectGetter(objName, getObjectsConfig.getString(objName)));
                    } catch (Exception e) {
                        throw new Exception("load getObjects '"+objName+"' error:"+e.getMessage(), e);
                    }
                }
            }
        }

        Map<String, StringGetter> strs = new HashMap<>();
        //获取字符串列表
        if (config != null) {
            ConfigurationSection getStringsConfig = config.getConfigurationSection("getStrings");
            for (String strName:getStringsConfig.getValues(false).keySet()) {
                try {
                    strs.put(strName, Util.loadStringGetter(strName, getStringsConfig.getString(strName)));
                } catch (Exception e) {
                    throw new Exception("load getStrings '"+strName+"' error:"+e.getMessage(), e);
                }
            }
        }
        
        //返回
        return new ParamsFactoryImpl(objs, strs);
    }
}
