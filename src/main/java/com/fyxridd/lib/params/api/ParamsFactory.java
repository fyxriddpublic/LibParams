package com.fyxridd.lib.params.api;

public interface ParamsFactory {
    /**
     * 生产出一个实例(对应一次会话)
     */
    ObjectGetters produceObjectGetters();

    /**
     * 生产出一个实例(对应一次会话)
     */
    StringGetters produceStringGetters();
}
