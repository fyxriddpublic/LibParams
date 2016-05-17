package com.fyxridd.lib.params;

import com.fyxridd.lib.params.formats.FormatAManager;

import com.fyxridd.lib.core.api.plugin.SimplePlugin;
import com.fyxridd.lib.params.manager.ParamsManager;

public class ParamsPlugin extends SimplePlugin{
    public static ParamsPlugin instance;

    private ParamsManager paramsManager;
    private FormatAManager formatAManager;

    @Override
    public void onEnable() {
        instance = this;

        paramsManager = new ParamsManager();
        formatAManager = new FormatAManager();

        super.onEnable();
    }

    public ParamsManager getParamsManager() {
        return paramsManager;
    }

    public FormatAManager getFormatAManager() {
        return formatAManager;
    }
}