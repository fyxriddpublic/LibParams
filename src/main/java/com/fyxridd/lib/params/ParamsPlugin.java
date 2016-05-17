package com.fyxridd.lib.params;

import org.bukkit.Bukkit;

import com.fyxridd.lib.config.api.ConfigApi;
import com.fyxridd.lib.core.api.plugin.SimplePlugin;
import com.fyxridd.lib.params.manager.ParamsManager;

public class ParamsPlugin extends SimplePlugin{
    public static ParamsPlugin instance;

    private ParamsManager paramsManager;

    @Override
    public void onEnable() {
        instance = this;

        paramsManager = new ParamsManager();

        super.onEnable();
    }

    public ParamsManager getParamsManager() {
        return paramsManager;
    }
}