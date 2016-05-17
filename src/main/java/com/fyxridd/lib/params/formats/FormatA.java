package com.fyxridd.lib.params.formats;

import com.fyxridd.lib.params.ParamsPlugin;
import com.fyxridd.lib.params.api.Format;
import com.fyxridd.lib.params.api.ParamsApi;
import com.fyxridd.lib.params.api.ValueGetter;

import java.util.ArrayList;
import java.util.List;

/**
 * 从插件中获取值
 */
public class FormatA extends Format{
    public static final String PREFIX = "a";

    //插件名
    private String plugin;

    //获取名
    private String getName;
    //获取需要传入的参数列表,不为null可为空列表
    private List<String> getParams;

    //true:属性;false:方法
    private boolean property;
    //属性/方法名
    private String proName;
    //方法需要传入的参数列表,不为null可为空列表
    private List<String> proMethodParams;
    private Class<?>[] proMethodClasses;

    public FormatA(String value) throws Exception {
        super(value);
        {
            String[] ss = value.split(":");

            {
                plugin = ss[0];
            }

            {
                getName = ss[1].substring(0, ss[1].indexOf('('));
                getParams = ParamsApi.getMethodParams(ss[1].substring(getName.length()));
            }

            {
                if (ss.length == 2) {
                    property = false;
                    proName = "toString";
                    proMethodParams = new ArrayList<>();
                    proMethodClasses = new Class[0];
                }else if (ss.length == 3) {
                    property = ss[2].charAt(ss[2].length()-1) != ')';
                    proName = ss[2].substring(0, ss[2].indexOf('('));
                    proMethodParams = ParamsApi.getMethodParams(ss[2].substring(proName.length()));
                    proMethodClasses = new Class<?>[proMethodParams.size()];
                    for (int index=0;index<proMethodParams.size();index++) proMethodClasses[index] = String.class;
                }else throw new Exception("error");
            }
        }
    }

    @Override
    public String convert(ValueGetter getter, String[] extra) {
        return ParamsPlugin.instance.getFormatAManager().getValue(this, getter);
    }

    public String getPlugin() {
        return plugin;
    }

    public String getGetName() {
        return getName;
    }

    public List<String> getGetParams() {
        return getParams;
    }

    public boolean isProperty() {
        return property;
    }

    public String getProName() {
        return proName;
    }

    public List<String> getProMethodParams() {
        return proMethodParams;
    }

    public Class<?>[] getProMethodClasses() {
        return proMethodClasses;
    }
}
