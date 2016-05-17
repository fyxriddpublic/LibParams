package com.fyxridd.lib.params.api;

public abstract class StringGetter{
    private String value;

    public StringGetter(String value) throws Exception{
        this.value = value;
    }

    public abstract String get(Session session);

    public String getValue() {
        return value;
    }
}
