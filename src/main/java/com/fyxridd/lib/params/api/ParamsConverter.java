package com.fyxridd.lib.params.api;

import com.fyxridd.lib.config.api.convert.ConfigConvert;
import com.fyxridd.lib.params.impl.ParamsFactoryImpl;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class ParamsConverter implements ConfigConvert.ConfigConverter<ParamsFactory>{
    @Override
    public ParamsFactory convert(String plugin, ConfigurationSection config) throws Exception {
        Map<String, ObjectGetter> objs = new HashMap<>();
        //获取对象列表
        {
            ConfigurationSection getObjectsConfig = config.getConfigurationSection("getObjects");
            if (getObjectsConfig != null) {
                for (String objName:getObjectsConfig.getValues(false).keySet()) {
                    try {
                        objs.put(objName, ParamsApi.loadObjectGetter(objName, getObjectsConfig.getString(objName)));
                    } catch (Exception e) {
                        throw new Exception("load getObjects '"+objName+"' error:"+e.getMessage(), e);
                    }
                }
            }
        }

        Map<String, StringGetter> strs = new HashMap<>();
        //获取字符串列表
        {
            ConfigurationSection getStringsConfig = config.getConfigurationSection("getStrings");
            for (String strName:getStringsConfig.getValues(false).keySet()) {
                try {
                    strs.put(strName, ParamsApi.loadStringGetter(strName, getStringsConfig.getString(strName)));
                } catch (Exception e) {
                    throw new Exception("load getStrings '"+strName+"' error:"+e.getMessage(), e);
                }
            }
        }
        
        //返回
        return new ParamsFactoryImpl(objs, strs);
    }
}
