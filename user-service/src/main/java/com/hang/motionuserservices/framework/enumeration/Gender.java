package com.hang.motionuserservices.framework.enumeration;

public enum Gender {
    M("Male"),
    F("Female"),
    O("Other");

    private String description;

    // 构造器
    Gender(String description) {
        this.description = description;
    }

    // 获取性别描述
    public String getDescription() {
        return description;
    }

    // 根据数据库字段值来获取Gender枚举
    public static Gender fromValue(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.name().equalsIgnoreCase(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Unknown gender value: " + value);
    }
}
