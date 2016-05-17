package com.fyxridd.lib.params.api;

import com.fyxridd.lib.config.api.convert.ConfigConvert;
import com.fyxridd.lib.params.impl.ObjectGettersImpl;
import com.fyxridd.lib.params.impl.ParamsFactoryImpl;
import com.fyxridd.lib.params.impl.StringGettersImpl;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class ParamsConverter implements ConfigConvert.ConfigConverter<ParamsFactory>{
    @Override
    public ParamsFactory convert(String plugin, ConfigurationSection config) throws Exception {
        ObjectGetters objectGetters;
        StringGetters stringGetters;
        
        
        //获取对象列表
        {
            Map<String, ObjectGetter> map = new HashMap<>();
            ConfigurationSection getObjectsConfig = config.getConfigurationSection("getObjects");
            if (getObjectsConfig != null) {
                for (String objName:getObjectsConfig.getValues(false).keySet()) {
                    try {
                        map.put(objName, ParamsApi.loadObjectGetter(objName, getObjectsConfig.getString(objName)));
                    } catch (Exception e) {
                        throw new Exception("load getObjects '"+objName+"' error:"+e.getMessage(), e);
                    }
                }
            }
            objectGetters = new ObjectGettersImpl(map);
        }
        
        //获取字符串列表
        {
            Map<String, StringGetter> map = new HashMap<>();
            ConfigurationSection getStringsConfig = config.getConfigurationSection("getStrings");
            for (String strName:getStringsConfig.getValues(false).keySet()) {
                try {
                    map.put(strName, ParamsApi.loadStringGetter(strName, getStringsConfig.getString(strName)));
                } catch (Exception e) {
                    throw new Exception("load getStrings '"+strName+"' error:"+e.getMessage(), e);
                }
            }
            stringGetters = new StringGettersImpl(map);
        }
        
        //返回
        return new ParamsFactoryImpl(objectGetters, stringGetters);
    }
}
