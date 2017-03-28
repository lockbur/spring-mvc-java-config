package com.lockbur.visit.enums;

/**
 * 婚姻状态
 * Created by wangkun23 on 2017/3/21.
 */
public enum MaritalEnum {

    MARRIED("已婚"),
    SINGLE("未婚"),
    DIVORCED("离异"),
    SEPARATED("分居"),
    WIDOWED("丧偶");

    private final String key;

    private MaritalEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
