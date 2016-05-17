package com.fyxridd.lib.params.manager;

import com.fyxridd.lib.params.ParamsPlugin;
import com.fyxridd.lib.params.api.Format;
import com.fyxridd.lib.params.formats.FormatA;
import com.fyxridd.lib.params.formats.FormatB;
import com.fyxridd.lib.params.formats.FormatC;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ParamsManager {
    private Map<String, Class<? extends Format>> formats = new HashMap<>();

    {
        register(FormatA.PREFIX, FormatA.class);
        register(FormatB.PREFIX, FormatB.class);
        register(FormatC.PREFIX, FormatC.class);
    }

    public ParamsManager() {
    }

    public void register(String prefix, Class<? extends Format> formatClass) {
        formats.put(prefix, formatClass);
    }

    /**
     * @see com.fyxridd.lib.params.api.ParamsApi#loadFormat(String, String)
     */
    public Format loadFormat(String name, String value) {
        for (Map.Entry<String, Class<? extends Format>> entry:formats.entrySet()) {
            if (name.startsWith(entry.getKey())) {
                try {
                    return entry.getValue().getConstructor(String.class).newInstance(value);
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return null;
    }
}
