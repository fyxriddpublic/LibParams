package com.fyxridd.lib.params;

import com.fyxridd.lib.params.getter.obj.ObjectGetterAManager;
import com.fyxridd.lib.core.api.plugin.SimplePlugin;
import com.fyxridd.lib.params.manager.ParamsManager;

public class ParamsPlugin extends SimplePlugin{
    public static ParamsPlugin instance;

    private ParamsManager paramsManager;
    private ObjectGetterAManager objectGetterAManager;

    @Override
    public void onEnable() {
        instance = this;

        paramsManager = new ParamsManager();
        objectGetterAManager = new ObjectGetterAManager();

        super.onEnable();
    }

    public ParamsManager getParamsManager() {
        return paramsManager;
    }

    public ObjectGetterAManager getObjectGetterAManager() {
        return objectGetterAManager;
    }
    
}