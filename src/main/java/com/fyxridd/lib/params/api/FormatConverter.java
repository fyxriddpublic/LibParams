package com.fyxridd.lib.params.api;

import com.fyxridd.lib.config.api.convert.ConfigConvert;
import com.fyxridd.lib.params.impl.ValueGetterImpl;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class FormatConverter implements ConfigConvert.ConfigConverter<ValueGetter>{
    @Override
    public ValueGetter convert(String plugin, ConfigurationSection config) throws Exception {
        Map<String, Format> map = new HashMap<>();
        for (String param:config.getValues(false).keySet()) map.put(param, ParamsApi.loadFormat(param, config.getString(param)));
        return new ValueGetterImpl(map);
    }
}
