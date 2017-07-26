package com.qunar.algorithm;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by ershu.liang on 2017/7/20.
 */

public enum AppealTypeEnum {
    ONLINE_CELAN("ONLINE_CELAN", "线上清除身份信息申诉"),
    OFFLINE_CELAN("OFFLINE_CELAN", "线下清除身份信息申诉"),
    OFFLINE_OCCUPIED("OFFLINE_OCCUPIED", "线下身份被占用申诉"),
    ONLINE_OCCUPIED("ONLINE_OCCUPIED", "线上身份被占用申诉");

    private String value;
    private String desc;
    private static Map<String, AppealTypeEnum> cacheMap = Maps.newHashMap();

    static {
        AppealTypeEnum[] var3;
        int var2 = (var3 = values()).length;

        for(int var1 = 0; var1 < var2; ++var1) {
            AppealTypeEnum each = var3[var1];
            cacheMap.put(each.getValue(), each);
        }

    }

    private AppealTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static AppealTypeEnum getByValue(String value) {
        return (AppealTypeEnum)cacheMap.get(value);
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static void main(String[] args) {
        System.out.println(getByValue("ONLINE_CELAN").getValue());
    }
}
